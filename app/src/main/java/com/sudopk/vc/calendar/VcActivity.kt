package com.sudopk.vc.calendar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.sudopk.kandroid.notFoundById
import com.sudopk.kandroid.notFoundByTag
import com.sudopk.kandroid.replace
import com.sudopk.vc.R
import com.sudopk.vc.components.ProgressFragment
import com.sudopk.vc.components.ToolbarFragment
import com.sudopk.vc.core.resumed
import com.sudopk.vc.databinding.ContainerBinding
import com.sudopk.vc.location.Location
import com.sudopk.vc.location.LocationContainer
import com.sudopk.vc.location.LocationFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class VcActivity : AppCompatActivity(),
                   CalendarPagerFragment.Container,
                   LocationContainer {
  @Inject lateinit var calendarStore: CalendarStore
  private lateinit var binding: ContainerBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    binding = ContainerBinding.inflate(layoutInflater)
    setContentView(binding.root)

    val location = calendarStore.location
    if (location == null) {
      onChangeLocationRequest()
    } else {
      launchCalendarPagerFragment()
    }
  }

  private fun launchCalendarPagerFragment() {
    supportFragmentManager.notFoundById<CalendarPagerFragment>(R.id.container) {
      supportFragmentManager.replace(it, CalendarPagerFragment())
    }
  }

  override fun onChangeLocationRequest() {
    supportFragmentManager.notFoundByTag(LocationFragment.TAG) {
      val fragment = LocationFragment.newInstance()
      fragment.show(supportFragmentManager, LocationFragment.TAG)
    }
  }

  override fun onLocationSelected(location: Location) {
    calendarStore.location = location
    supportFragmentManager.replace(R.id.container, ProgressFragment())
    launchCalendarPagerFragment()
  }

  override fun onLocationSelectCanceled() {
    if (calendarStore.location == null) {
      finish()
    }
  }

  override fun onLocationSelectFailed(error: String) {
    if (resumed) {
      supportFragmentManager.notFoundById<ToolbarFragment>(R.id.container) {
        supportFragmentManager.replace(it, ToolbarFragment())
      }

      val snackbar = Snackbar.make(binding.container, error, Snackbar.LENGTH_INDEFINITE)
      snackbar.setAction(R.string.retry) {
        snackbar.dismiss()
        onChangeLocationRequest()
      }
      snackbar.show()
    }
  }
}