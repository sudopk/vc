package com.sudopk.vc.retrofit

import android.util.Log
import com.sudopk.kandroid.StrFromRes
import com.sudopk.vc.R
import com.sudopk.vc.calendar.Country
import com.sudopk.vc.calendar.DayCalendar
import com.sudopk.vc.calendar.VCalendar
import com.sudopk.vc.location.Location
import okhttp3.ResponseBody
import org.jsoup.Jsoup
import org.jsoup.nodes.Element
import org.jsoup.select.Elements
import retrofit2.Converter
import retrofit2.Retrofit
import java.io.IOException
import java.lang.reflect.Type
import java.util.*


const val TAG = "VcConverterFactory"

class VcConverterFactory(val strFromRes: StrFromRes) : Converter.Factory() {
    companion object {
    }

    override fun responseBodyConverter(type: Type?, annotations: Array<Annotation>?, retrofit: Retrofit?): Converter<ResponseBody, *> {
        if (annotations != null) {
            for (annotation in annotations) {
                when (annotation.annotationClass) {
                    VcApi.Calendar::class -> return VcCalendarResponseConverter(strFromRes)
                    VcApi.Locations::class -> return VcLocationResponseConverter()
                }
            }
        }
        return super.responseBodyConverter(type, annotations, retrofit)
    }
}

class VcCalendarResponseConverter(val strFromRes: StrFromRes) :
        Converter<ResponseBody,
                VCalendar> {

    private var mEventData: MutableList<String> = ArrayList()
    private var mDate: Int = 0

    @Throws(IOException::class)
    override fun convert(value: ResponseBody): VCalendar {
        return convert(value.string())
    }

    fun convert(htmlBody: String): VCalendar {
        val document = Jsoup.parse(htmlBody)
        val days = document.select("body center>table:nth-child(3)" + ">tbody>tr>td>table>tbody")
        val calendar = ArrayList<DayCalendar>()
        for (day in days) {
            val dayCalendar = parseDay(day)
            if (dayCalendar != null) {
                calendar.add(dayCalendar)
            }
        }
        return calendar
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
            if (mDate != 0) {
                val error = "Error parsing the date events. Date repeated: old- ${mDate}, new- ${data}"
                Log.e(TAG, error)
                throw IllegalStateException(error)
            }
            mDate = Integer.parseInt(data)
        } else {
            data += parseImgToText(detail.select("img"))
            if (data.isNotBlank()) {
                mEventData.add(data)
            }
        }
    }

    private fun parseImgToText(imgs: Elements): String {
        if (imgs.size > 0) {
            val src = imgs.attr("src")
            when (src) {
                "amavasya.gif" -> return strFromRes.getString(R.string.new_moon)
                "purnima.gif" -> return strFromRes.getString(R.string.full_moon)
                "ap.gif" -> return strFromRes.getString(R.string.appearance_day)
                "dis.gif" -> return strFromRes.getString(R.string.disappearance_day)
            }
        }
        return ""
    }
}

class VcLocationResponseConverter : Converter<ResponseBody, List<Country>> {
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
        if (locations.isNotEmpty() && country.isNotBlank()) {
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
