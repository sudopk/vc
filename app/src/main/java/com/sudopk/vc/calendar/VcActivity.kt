package com.sudopk.vc.calendar

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import com.sudopk.kandroid.notFoundByTag
import com.sudopk.vc.R
import com.sudopk.vc.core.CalUtil
import com.sudopk.vc.location.Location
import com.sudopk.vc.location.LocationContainer
import com.sudopk.vc.location.LocationFragment
import dagger.hilt.android.AndroidEntryPoint
import java.util.Calendar
import javax.inject.Inject
import kotlinx.coroutines.launch

@AndroidEntryPoint
class VcActivity : AppCompatActivity(),
                   LocationContainer {
  @Inject lateinit var calendarStore: CalendarStore
  @Inject lateinit var calendarApiFactory: CalendarApiFactory
  private val refreshCalendar = mutableStateOf(false)
  private val pagesData = List(MONTHS_TO_STORE) {
    PageData(
      CalUtil.getCalendar(it - MONTHS_TO_STORE / 2).monthYear(),
      refreshCalendar = mutableStateOf(false)
    )
  }
  private val errorState = mutableStateOf("")

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    checkLocationIsSelected(promptForLocation = true)

    setContent {
      AppBarWithPager.ShowScaffold(
        Calendar.getInstance(),
        calendarStore.locationState,
        pagesData,
        errorState,
        { onChangeLocationRequest() },
        { refreshCalendar.value = true }) { calendar, pageData, currentPage ->
        val calendarApi =
          remember(pageData.monthYear) { calendarApiFactory.create(pageData.monthYear) }
        val coroutine = rememberCoroutineScope()
        LaunchedEffect(pageData.monthYear) {
          calendarApi.fetchCalendar()
        }
        if (pageData.refreshCalendar.value || (currentPage && refreshCalendar.value)) {
          LaunchedEffect(true) {
            coroutine.launch {
              calendarApi.removeCalendar()
              calendarApi.fetchCalendar()
            }
          }
          refreshCalendar.value = false
          pageData.refreshCalendar.value = false
        }
        AppBarWithPager.ShowCalendar(calendar, calendarApi)
      }
    }
  }

  private fun onChangeLocationRequest() {
    supportFragmentManager.notFoundByTag(LocationFragment.TAG) {
      val fragment = LocationFragment.newInstance()
      fragment.show(supportFragmentManager, LocationFragment.TAG)
    }
  }

  override fun onLocationSelected(location: Location) {
    calendarStore.location = location
    errorState.value = ""
    pagesData.forEach { it.refreshCalendar.value = true }
  }

  override fun onLocationSelectCanceled() {
    checkLocationIsSelected(promptForLocation = false)
  }

  private fun checkLocationIsSelected(promptForLocation: Boolean) {
    if (calendarStore.location == null) {
      errorState.value = getString(R.string.location_required)
      if (promptForLocation) {
        onChangeLocationRequest()
      }
    }
  }

  override fun onLocationSelectFailed(error: String) {
    errorState.value = error
  }
}