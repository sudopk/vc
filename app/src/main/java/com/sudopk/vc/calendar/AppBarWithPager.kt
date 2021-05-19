package com.sudopk.vc.calendar

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Tab
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.EditLocation
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import com.sudopk.vc.R
import kotlinx.coroutines.launch

object AppBarWithPager {
  @Composable
  fun AppBarWithPager(calendarStore: CalendarStore) {
    Column {
      ShowAppBar(calendarStore)
      ShowComposePager()
    }
  }

  @Composable
  private fun ShowAppBar(calendarStore: CalendarStore) {
    TopAppBar(
      title = {
        Column {
          Text(stringResource(R.string.app_name))
          val location = calendarStore.location?.name ?: ""
          if (location.isNotBlank()) {
            Text(location, style = MaterialTheme.typography.subtitle1)
          }
        }
      },
      actions = {
        // RowScope here, so these icons will be placed horizontally
        IconButton(onClick = {}) {
          Icon(Icons.Filled.EditLocation, contentDescription = "Change location")
        }
        IconButton(onClick = {}) {
          Icon(Icons.Filled.Refresh, contentDescription = "Refresh")
        }
      }
    )
  }

  @OptIn(ExperimentalPagerApi::class)
  @Composable
  private fun ShowComposePager() {
    // Display 10 items
    val pagerState = rememberPagerState(pageCount = 10)
    val coroutine = rememberCoroutineScope()
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
        repeat(10) { index ->
          Tab(
            text = { Text("Title $index") },
            selected = pagerState.currentPage == index,
            onClick = { coroutine.launch { pagerState.scrollToPage(index) } },
          )
        }
      }

      HorizontalPager(state = pagerState) {
        Box(
          Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .fillMaxHeight()
        ) {
          Column {
            Text("Page: $it", style = MaterialTheme.typography.h6)
            Text("This is some long description of the page, which may span multiple lines. This is just the placeholder for the body of this page.")
          }
        }
      }
    }
  }
}