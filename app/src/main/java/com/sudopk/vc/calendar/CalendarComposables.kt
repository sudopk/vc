package com.sudopk.vc.calendar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Tab
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.EditLocation
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import com.sudopk.vc.R
import com.sudopk.vc.core.monthAbbreviation
import com.sudopk.vc.core.weekDayAbbreviation
import com.sudopk.vc.location.Location
import java.util.Calendar
import kotlin.math.max
import kotlinx.coroutines.launch

object AppBarWithPager {
  @Composable
  fun ShowScaffold(
    calendar: Calendar,
    locationState: State<Location?>,
    pagesData: List<PageData>,
    errorState: State<String>,
    onChangeLocation: () -> Unit,
    onRefreshCalendar: () -> Unit,
    pageContent: @Composable (calendar: Calendar, pageData: PageData, currentPage: Boolean) -> Unit

  ) {
    Scaffold(topBar = { ShowAppBar(locationState, onChangeLocation, onRefreshCalendar) }) {
      val error = errorState.value
      if (error.isBlank()) {
        ShowComposePager(calendar, pagesData, pageContent)
      } else {
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
          Text(error, style = MaterialTheme.typography.body1)
        }
      }
    }
  }

  @Composable
  private fun ShowAppBar(
    locationState: State<Location?>,
    onChangeLocation: () -> Unit,
    onRefreshCalendar: () -> Unit,
  ) {
    TopAppBar(
      title = {
        Column {
          Text(stringResource(R.string.app_name))
          val location = locationState.value?.name ?: ""
          if (location.isNotBlank()) {
            Text(location, style = MaterialTheme.typography.subtitle1)
          }
        }
      },
      actions = {
        // RowScope here, so these icons will be placed horizontally
        IconButton(onClick = onChangeLocation) {
          Icon(Icons.Filled.EditLocation, contentDescription = "Change location")
        }
        IconButton(onClick = onRefreshCalendar) {
          Icon(Icons.Filled.Refresh, contentDescription = "Refresh")
        }
      }
    )
  }

  @OptIn(ExperimentalPagerApi::class)
  @Composable
  private fun ShowComposePager(
    calendar: Calendar,
    pagesData: List<PageData>,
    pageContent: @Composable (calendar: Calendar, pageData: PageData, currentPage: Boolean) -> Unit
  ) {
    // Display 10 items
    val pagerState = rememberPagerState(pageCount = pagesData.size)
    val coroutine = rememberCoroutineScope()
    // LaunchedEffect doesn't seem to work correctly in version 0.19.0
    LaunchedEffect(key1 = pagesData.size) {
      val index = pagesData.indexOfFirst { calendar.monthYear() == it.monthYear }
      if(index != -1) {
        pagerState.animateScrollToPage(index)
      }
    }
    Column {
      ScrollableTabRow(
        // Our selected tab is our current page
        selectedTabIndex = pagerState.currentPage,
        edgePadding = 0.dp,
        // Override the indicator, using the provided pagerTabIndicatorOffset modifier
        indicator = { tabPositions ->
          TabRowDefaults.Indicator(Modifier.pagerTabIndicatorOffset(pagerState, tabPositions))
        }
      ) {
        // Add tabs for all of our pages
        pagesData.forEachIndexed { index, pageData ->
          Tab(
            text = { Text(pageData.monthYear.title) },
            selected = pagerState.currentPage == index,
            onClick = { coroutine.launch { pagerState.scrollToPage(index) } },
          )
        }
      }

      HorizontalPager(state = pagerState) {
        pageContent(calendar, pagesData[it], it == pagerState.currentPage)
      }
    }
  }

  @Composable
  fun ShowCalendar(calendar: Calendar, calendarApi: CalendarApi) {
    val statusDelegate by calendarApi.status.observeAsState()
    when (val status = statusDelegate) {
      is DataStatus.Failed -> Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(
          stringResource(R.string.failed_to_get_calendar_data),
          style = MaterialTheme.typography.body1
        )
      }
      is DataStatus.NotReady -> {
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.TopStart) {
          LinearProgressIndicator(Modifier.fillMaxWidth(), color = MaterialTheme.colors.secondary)
        }
      }
      is DataStatus.Ready -> {
        val currentMonth = calendarApi.monthYear == calendar.monthYear()
        val date = calendar.get(Calendar.DATE)
        val listState = rememberLazyListState()
        if (currentMonth) {
          LaunchedEffect(date) {
            listState.animateScrollToItem(max(0, date - 2))
          }
        }
        LazyColumn(state = listState) {
          items(status.vCalendar) {
            val modifier = if (currentMonth && it.date == date) {
              Modifier.background(Color.LightGray)
            } else {
              Modifier
            }
            Column(modifier) {
              CalendarDay(calendarApi, it)
              Divider()
            }
          }
        }
      }
    }
  }

  @Composable
  private fun CalendarDay(calendarApi: CalendarApi, day: DayCalendar) {
    Row(Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
      Box(
        Modifier
          .clip(CircleShape)
          .background(MaterialTheme.colors.secondary)
          .padding(8.dp)
      ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
          val calendar: Calendar = Calendar.getInstance()
          calendar.set(Calendar.MONTH, calendarApi.monthYear.month - 1)
          calendar.set(Calendar.YEAR, calendarApi.monthYear.year)
          calendar.set(Calendar.DATE, day.date)
          Text("${calendar.monthAbbreviation()} ${day.date}")
          Text(calendar.weekDayAbbreviation())
        }
      }
      Spacer(Modifier.width(8.dp))
      Column {
        day.events.forEach { Text(it) }
      }
    }
  }

}

data class PageData(val monthYear: MonthYear, val refreshCalendar: MutableState<Boolean>)