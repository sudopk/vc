package com.sudopk.vc.retrofit

import com.sudopk.kandroid.StrFromRes
import com.sudopk.vc.R
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

    @Throws(IOException::class)
    override fun convert(value: ResponseBody): VCalendar {
        return convert(value.string())
    }

    fun convert(htmlBody: String): VCalendar {
        val document = Jsoup.parse(htmlBody)

        val tables = document.getElementsByTag("table")

        val vCalendar = ArrayList<DayCalendar>(/* Max days in a month= */31)
        for (table in tables) {
            parseDayCalendar(table)?.let {
                vCalendar.add(it)
            }
        }

        return vCalendar
    }

    private fun parseDayCalendar(table: Element): DayCalendar? {
        // First row, second column is date
        val rows = table.getElementsByTag("tr")
        var date = -1
        val rowData = ArrayList<String>(rows.size)
        for (rowIndex in 0..rows.size - 1) {
            val cols = rows[rowIndex].getElementsByTag("td")
            for (colIndex in 0..cols.size - 1) {
                if (rowIndex == 0 && colIndex == 1) {
                    val dateOrNull = cols[colIndex].text().toIntOrNull()

                    if (dateOrNull != null && dateOrNull >= 1 && dateOrNull <= 31) {
                        date = dateOrNull
                    }
                } else {
                    val parseImgToText = parseImgToText(cols[colIndex].select("img"))
                    val entry = cols[colIndex].text() + if (parseImgToText.isNotBlank()) (" $parseImgToText") else ""
                    if (entry.isNotBlank()) {
                        rowData.add(entry)
                    }
                }
            }
        }
        if (date != -1 && rowData.isNotEmpty()) {
            return DayCalendar(date, rowData)
        }

        return null
    }

    private fun parseImgToText(imgs: Elements): String {
        if (imgs.size > 0) {
            val src = imgs.attr("src")
            when {
                src.endsWith("amavasya.gif") -> return strFromRes.getString(R.string.new_moon)
                src.endsWith("purnima.gif") -> return strFromRes.getString(R.string.full_moon)
                src.endsWith("ap.gif") -> return strFromRes.getString(R.string.appearance_day)
                src.endsWith("dis.gif") -> return strFromRes.getString(R.string.disappearance_day)
            }
        }
        return ""
    }
}

class VcLocationResponseConverter : Converter<ResponseBody, List<Location>> {

    @Throws(IOException::class)
    override fun convert(value: ResponseBody): List<Location> {
        val document = Jsoup.parse(value.string())
        val selectTags = document.getElementsByTag("select")
        for (selectTag in selectTags) {
            if (isLocationSelectTag(selectTag)) {
                return parseLocations(selectTag)
            }
        }

        return listOf()
    }

    private fun parseLocations(selectTag: Element): List<Location> {
        val locations = ArrayList<Location>()
        val optionTags = selectTag.getElementsByTag("option")
        for (optionTag in optionTags) {
            val valueAttr = optionTag.attr("value")
            val text = optionTag.text()
            if (valueAttr.isBlank() || text.isBlank()) {
                continue
            }

            for (token in valueAttr.split('/')) {
                if (token.isBlank()) {
                    continue
                }

                // First token is location id and tag text is location name
                locations.add(Location(text.trim(), token.trim()))
                break
            }
        }
        return locations
    }

    private fun isLocationSelectTag(selectTag: Element): Boolean {
        val optionTags = selectTag.getElementsByTag("option")
        for (optionTag in optionTags) {
            if (optionTag.text() == "SELECT CITY") {
                return true
            }
        }
        return false
    }

    companion object {
        private val PREFIX_OF_LOCATIONS_WITH_ID = "...."

        private fun isCountryName(locationName: String): Boolean {
            return !locationName.startsWith(PREFIX_OF_LOCATIONS_WITH_ID)
        }
    }
}
