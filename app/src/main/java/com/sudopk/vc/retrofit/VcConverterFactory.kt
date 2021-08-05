package com.sudopk.vc.retrofit

import android.util.Log
import com.sudopk.vc.calendar.Country
import com.sudopk.vc.calendar.DayCalendar
import com.sudopk.vc.calendar.VCalendar
import com.sudopk.vc.location.Location
import java.lang.reflect.Type
import java.util.ArrayList
import java.util.logging.Logger
import okhttp3.ResponseBody
import org.jsoup.Jsoup
import org.jsoup.nodes.Element
import org.jsoup.select.Elements
import retrofit2.Converter
import retrofit2.Retrofit

val logger = Logger.getLogger("VcConverterFactory")

class VcConverterFactory : Converter.Factory() {
  override fun responseBodyConverter(
    type: Type,
    annotations: Array<Annotation>,
    retrofit: Retrofit
  ): Converter<ResponseBody, *> {
    for (annotation in annotations) {
      when (annotation.annotationClass) {
        VcApi.Calendar::class -> return VcCalendarResponseConverter()
        VcApi.Locations::class -> return VcLocationResponseConverter()
      }
    }
    return super.responseBodyConverter(type, annotations, retrofit)!!
  }
}

class VcCalendarResponseConverter :
  Converter<ResponseBody, VCalendar> {

  override fun convert(value: ResponseBody): VCalendar {
    Log.i(javaClass.simpleName, "Url: $value")
    // Note that there is only one instance of VcCalendarResponseConverter for different requests.
    return CalendarParser.convert(value.string())
  }
}

private object CalendarParser {
  fun convert(htmlBody: String): VCalendar {
    val document = Jsoup.parse(htmlBody)
    Log.i(javaClass.simpleName, "Document: $document")
    val weeks = document.select("body > center:nth-child(4) > table:nth-child(3) > tbody > tr")
    logger.info("Calendar rows: ${weeks.size})")
    val calendar = mutableListOf<DayCalendar>()
    // First row is header
    weeks.drop(1).forEach { week ->
      val days = week.select("> td")
      check(days.size == 7) {
        "Invalid number of days in a week: ${days.size}"
      }
      days.forEach { day ->
        val dayCalendar = parseDay(day)
        if (dayCalendar != null) {
          calendar.add(dayCalendar)
        }
      }
    }
    return calendar
  }

  private fun parseDay(day: Element): DayCalendar? {
    // logger.info("Day: $day")
    // each day is a <table>
    val events = day.getElementsByTag("tr").filter { it.text().isNotEmpty() }
    if (events.isEmpty()) {
      logger.info("Calendar cell is not a day, skipping...")
      return null
    }
    var date = 0
    val eventData = ArrayList<String>(events.size)
    events.forEachIndexed { index, event ->
      val details = event.select(">td")
      for ((col, detail) in details.withIndex()) {
        val dateEvent = index == 0 && col == 1
        if (dateEvent) {
          date = parseDate(detail)
        } else {
          eventData += parseEvents(detail)
        }
      }
    }
    if (date != 0 && eventData.isNotEmpty()) {
      return DayCalendar(date, eventData)
    }
    return null
  }

  private fun parseDate(detail: Element): Int {
    val data = detail.text()
    return Integer.parseInt(data)
  }

  private fun parseEvents(detail: Element): List<String> {
    val centerHtml = detail.getElementsByTag("center").single().html()
    return centerHtml.split("<br>").mapNotNull { line ->
      if (line.isBlank()) {
        return@mapNotNull null
      }
      val parsedLine = Jsoup.parse(line)
      var lineText = parsedLine.text()
      val imgText = parseImgToText(parsedLine.getElementsByTag("img"))
      if (imgText.isNotEmpty()) {
        lineText = "$lineText [$imgText]"
      }
      if (lineText.isBlank()) {
        return@mapNotNull null
      }
      lineText
    }
  }

  private fun parseImgToText(imgs: Elements): String {
    if (imgs.size > 0) {
      val title = imgs.attr("title")
      if (title.isNotEmpty()) {
        return title
      }
      val src = imgs.attr("src")
      return when {
        src.endsWith("amavasya.gif") -> "New moon"
        src.endsWith("purnima.gif") -> "Full moon"
        src.endsWith("ap.gif") -> "Appearance"
        src.endsWith("dis.gif") -> "Disappearance"
        else -> ""
      }
    }
    return ""
  }
}

class VcLocationResponseConverter : Converter<ResponseBody, List<Country>> {
  override fun convert(value: ResponseBody): List<Country> {
    val document = Jsoup.parse(value.string())
    Log.i(javaClass.simpleName, "Document: $document")

    val locationGroups = document.select("select")
    Log.i(javaClass.simpleName, "Location groups size: ${locationGroups.size}")

    val locationGroup = locationGroups.single { isLocationSelectTag(it) }
    val countries = parseLocationGroup(locationGroup)
    Log.i(javaClass.simpleName, "Countries: $countries")
    return countries
  }

  private fun parseLocationGroup(locationGroup: Element): List<Country> {
    Log.i(javaClass.simpleName, "Location group: $locationGroup")
    val locations = locationGroup.select(">option")
    Log.i(javaClass.simpleName, "Locations: $locations")

    var locationsWithId: MutableList<Location> = mutableListOf()
    var countryName = ""
    val countries = mutableListOf<Country>()
    for (location in locations) {
      val locationName = location.text()
      if (locationName == "SELECT CITY") {
        continue
      }
      val isCountry = !location.hasAttr("value")

      if (isCountry) {
        // add data of last country
        val country = getCountryData(countryName, locationsWithId)
        if (country != null) {
          countries.add(country)
        }
        countryName = locationName
        locationsWithId = mutableListOf()
      } else {
        locationsWithId.add(
          Location(
            locationName,
            location.attr("value")
              .split("/").first { it.trim().isNotEmpty() }
          )
        )
      }
    }
    return countries
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

  private fun getCountryData(
    country: String,
    locations: List<Location>
  ): Country? {
    return if (locations.isNotEmpty() && country.isNotBlank()) {
      Country(country, locations.sorted())
    } else {
      null
    }
  }
}
