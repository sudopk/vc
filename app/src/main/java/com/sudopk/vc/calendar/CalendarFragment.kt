package com.sudopk.vc.calendar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import com.sudopk.kandroid.parent
import com.sudopk.vc.R
import com.sudopk.vc.core.monthAbbreviation
import com.sudopk.vc.core.weekDayAbbreviation
import com.sudopk.vc.retrofit.VcService
import dagger.hilt.android.AndroidEntryPoint
import java.util.Calendar
import javax.inject.Inject
import kotlin.math.max
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CalendarFragment : Fragment() {
  @Inject lateinit var calendarStore: CalendarStore
  @Inject lateinit var vcService: VcService

  private lateinit var mCalendarApi: CalendarApi
  private lateinit var mMonthYear: MonthYear

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    return ComposeView(requireContext())
  }

  override fun onStart() {
    super.onStart()
    setHasOptionsMenu(true)

    mMonthYear = MonthYear(requireArguments().getInt(MONTH), requireArguments().getInt(YEAR))
    mCalendarApi = ViewModelProviders.of(this).get(CalendarApi::class.java)
    mCalendarApi.init(vcService, calendarStore, mMonthYear)

    (view as ComposeView).setContent { Calendar(mCalendarApi) }

    fetchCalendar()
  }

  override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
    inflater.inflate(R.menu.calendar, menu)
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    if (item.itemId == R.id.refresh) {
      onRefresh()
    } else if (item.itemId == R.id.location) {
      parent<Container>().onChangeLocationRequest()
    }
    return super.onOptionsItemSelected(item)
  }

  private fun onRefresh() {
    mCalendarApi.removeCalendar(mMonthYear)
    fetchCalendar()
  }

  private fun fetchCalendar() {
    lifecycleScope.launch {
      mCalendarApi.fetchCalendar()
    }
  }

  @Composable
  private fun Calendar(calendarApi: CalendarApi) {
    val statusDelegate by calendarApi.status.observeAsState()
    when (val status = statusDelegate!!) {
      is DataStatus.Failed -> Box(contentAlignment = Alignment.Center) {
        Text(
          getString(R.string.failed_to_get_calendar_data),
          style = MaterialTheme.typography.body1
        )
      }
      is DataStatus.NotReady -> {
        Box {
          LinearProgressIndicator(Modifier.fillMaxWidth(), color = MaterialTheme.colors.secondary)
        }
      }
      is DataStatus.Ready -> {
        val calendar = Calendar.getInstance()
        val currentMonth = mMonthYear.month == calendar.get(Calendar.MONTH) + 1 &&
          mMonthYear.year == calendar.get(Calendar.YEAR)
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
              CalendarDay(it)
              Divider()
            }
          }
        }
      }
    }
  }

  @Composable
  private fun CalendarDay(day: DayCalendar) {
    Row(Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
      Box(
        Modifier
          .clip(CircleShape)
          .background(MaterialTheme.colors.secondary)
          .padding(8.dp)
      ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
          val calendar: Calendar = Calendar.getInstance()
          calendar.set(Calendar.MONTH, mMonthYear.month - 1)
          calendar.set(Calendar.YEAR, mMonthYear.year)
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

  interface Container {
    fun onChangeLocationRequest()
  }

  companion object {
    private const val MONTH = "month"
    private const val YEAR = "year"

    /**
     * @param month 1 to 12
     * @param year  Full year e.g. 2016
     */
    fun newInstance(month: Int, year: Int): Fragment {
      return CalendarFragment().also {
        it.arguments = bundleOf(MONTH to month, YEAR to year)
      }
    }
  }
}
