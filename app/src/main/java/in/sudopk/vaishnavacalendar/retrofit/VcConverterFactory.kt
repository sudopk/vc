package `in`.sudopk.vaishnavacalendar.retrofit

import `in`.sudopk.coreandroid.StrFromRes
import `in`.sudopk.vaishnavacalendar.R
import android.text.TextUtils

import org.jsoup.Jsoup
import org.jsoup.nodes.Element
import org.jsoup.select.Elements

import java.io.IOException
import java.lang.reflect.Type
import java.util.ArrayList
import java.util.Collections

import `in`.sudopk.vaishnavacalendar.calendar.Country
import `in`.sudopk.vaishnavacalendar.calendar.DayCalendar
import `in`.sudopk.vaishnavacalendar.location.Location
import `in`.sudopk.vaishnavacalendar.VCalendar
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit

class VcConverterFactory(val strFromRes: StrFromRes) : Converter.Factory() {
    override fun responseBodyConverter(type: Type?, annotations: Array<Annotation>?, retrofit: Retrofit?): Converter<ResponseBody, *> {
        if (annotations != null) {
            for (annotation in annotations) {
                if (annotation.annotationClass == VcApi.Calendar::class) {
                    return VcCalendarResponseConverter(strFromRes)
                } else if (annotation.annotationClass == VcApi.Locations::class) {
                    return VcLocationResponseConverter()
                }
            }
        }
        return super.responseBodyConverter(type, annotations, retrofit)
    }


    private class VcCalendarResponseConverter(val strFromRes: StrFromRes) : Converter<ResponseBody,
            VCalendar> {

        private var mEventData: MutableList<String> = ArrayList()
        private var mDate: Int = 0

        @Throws(IOException::class)
        override fun convert(value: ResponseBody): VCalendar {
            val document = Jsoup.parse(value.string())
            val days = document.select("body center>table:nth-child(3)" + ">tbody>tr>td>table>tbody")
            val calendar = ArrayList<DayCalendar>()
            for (day in days) {
                val dayCalendar = parseDay(day)
                if (dayCalendar != null) {
                    calendar.add(dayCalendar)
                }
            }
            return VCalendar(calendar)
        }

        private fun parseDay(day: Element): DayCalendar? {
            // each day is a <table>
            val events = day.select(">tr")
            mDate = 0
            mEventData = ArrayList<String>(events.size)
            var firstRow = true
            for (event in events) {
                parseDayEvent(event, firstRow)
                firstRow = false
            }
            if (mDate != 0 && !mEventData.isEmpty()) {
                return DayCalendar(mDate, mEventData)
            }
            return null
        }

        private fun parseDayEvent(event: Element, dateEvent: Boolean) {
            var col = 0
            val details = event.select(">td")
            for (detail in details) {
                parseEventDetail(detail, dateEvent && col == 1)
                col++
            }
        }


        private fun parseEventDetail(detail: Element, dateEvent: Boolean) {
            var data = detail.text()
            if (dateEvent) {
                mDate = Integer.parseInt(data)
            } else {
                data += parseImgToText(detail.select("img"))
                data = data.trim { it <= ' ' }
                if (!TextUtils.isEmpty(data)) {
                    mEventData.add(data)
                }
            }
        }

        private fun parseImgToText(imgs: Elements): String {
            if (imgs.size > 0) {
                val src = imgs.attr("src")
                if ("amavasya.gif" == src) {
                    return strFromRes.getString(R.string.new_moon)
                } else if ("purnima.gif" == src) {
                    return strFromRes.getString(R.string.full_moon)
                } else if ("ap.gif" == src) {
                    return strFromRes.getString(R.string.appearance_day)
                } else if ("dis.gif" == src) {
                    return strFromRes.getString(R.string.disappearance_day)
                }
            }
            return ""
        }
    }

    private class VcLocationResponseConverter : Converter<ResponseBody, List<Country>> {
        private var mLocationData: MutableList<Country> = ArrayList()

        @Throws(IOException::class)
        override fun convert(value: ResponseBody): List<Country> {
            val document = Jsoup.parse(value.string())
            val locationGroups = document.select("select[id=CIID]")
            mLocationData = ArrayList()
            for (locationGroup in locationGroups) {
                parseLocationGroup(locationGroup)
            }

            return mLocationData
        }

        private fun parseLocationGroup(locationGroup: Element) {
            val locations = locationGroup.select(">option")
            // initializing it to avoid null check, but it should be overridden in the loop
            var locationsWithId: MutableList<Location> = ArrayList()
            var country = ""
            for (location in locations) {
                val locationName = location.text()
                if (isCountryName(locationName)) {
                    // add data of last country
                    addCountryData(country, locationsWithId)

                    country = locationName
                    locationsWithId = ArrayList<Location>()
                } else {
                    // strip the prefix from locationName
                    locationsWithId.add(
                            Location(
                                    locationName.substring(PREFIX_OF_LOCATIONS_WITH_ID.length),
                                    location.attr("value")))
                }
            }
            addCountryData(country, locationsWithId)
        }

        private fun addCountryData(country: String,
                                   locations: List<Location>) {
            if (!locations.isEmpty() && !TextUtils.isEmpty(country)) {
                Collections.sort(locations)
                mLocationData.add(Country(country, locations))
            }
        }

        companion object {
            private val PREFIX_OF_LOCATIONS_WITH_ID = "...."

            private fun isCountryName(locationName: String): Boolean {
                return !locationName.startsWith(PREFIX_OF_LOCATIONS_WITH_ID)
            }
        }
    }
}
