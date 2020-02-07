package com.sudopk.vc.location

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.sudopk.kandroid.parent
import com.sudopk.vc.R
import com.sudopk.vc.calendar.CalendarStore
import com.sudopk.vc.core.vcApp
import com.sudopk.vc.core.weak
import com.sudopk.vc.retrofit.VcService
import kotlinx.android.synthetic.main.location.*

class LocationFragment : AppCompatDialogFragment(), LocationContainer, LocationCallback {
  private lateinit var mAdapter: LocationAdapter
  private lateinit var mVcService: VcService
  private lateinit var mLocationStore: LocationStore
  private lateinit var mCalendarStore: CalendarStore

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    //setHasOptionsMenu(true);

    mVcService = vcApp.vcService

    mLocationStore = vcApp.locationStore
    mCalendarStore = vcApp.calendarStore

    setStyle(DialogFragment.STYLE_NORMAL, R.style.Theme_AppCompat_Light_Dialog)

  }

  override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
    val dialog = super.onCreateDialog(savedInstanceState)
    dialog.setTitle(R.string.location_title)
    return dialog
  }

  override fun onCreateView(inflater: LayoutInflater,
                            container: ViewGroup?,
                            savedInstanceState: Bundle?): View? {
    return inflater.inflate(R.layout.location, container, false)
  }

  override fun onStart() {
    super.onStart()
    recyclerView.layoutManager = LinearLayoutManager(context)
    mAdapter = LocationAdapter(this, mCalendarStore.location)
    recyclerView.adapter = mAdapter
  }

  override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
    inflater.inflate(R.menu.calendar, menu)
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    if (item.itemId == R.id.refresh) {
      refresh()
    }
    return super.onOptionsItemSelected(item)
  }

  override fun onResume() {
    super.onResume()
    refresh()
  }

  override fun onCancel(dialog: DialogInterface) {
    super.onCancel(dialog)
    onLocationSelectCanceled()
  }

  override fun onLocationSelected(location: Location) {
    dismiss()
    container.onLocationSelected(location)
  }

  override fun onLocationSelectCanceled() {
    container.onLocationSelectCanceled()
  }

  override fun onLocationSelectFailed(error: String) {
    dismiss()
    container.onLocationSelectFailed(error)
  }

  private val container: LocationContainer
    get() = parent()

  private fun refresh() {
    if (isResumed) {
      progressBar.visibility = View.VISIBLE

      if (mLocationStore.hasLocations()) {
        onLocationResponse(mLocationStore.locations)
      } else {
        val locationRequest = LocationRemoteRequest(this.weak)
        locationRequest.makeRequest(mVcService)
      }
    }
  }

  override fun onLocationsReceived(locations: List<Location>) {
    if (isResumed) {
      mLocationStore.saveLocations(locations)
      onLocationResponse(mLocationStore.locations)
    }
  }

  override fun onLocationRequestFailed() {
    onLocationSelectFailed(getString(R.string.locations_failure))
  }


  private fun onLocationResponse(response: List<Location>) {
    if (isResumed) {
      progressBar.visibility = View.GONE
      mAdapter.setData(response)

      var position = mAdapter.getPosition(mCalendarStore.location)
      if (position < 0) {
        return
      }

      if (position > 0) {
        // lets scroll to location one before the actual one, looks little better
        position--
      }
      recyclerView.layoutManager?.scrollToPosition(position)
    }
  }

  companion object {
    val TAG = LocationFragment::class.java.name

    fun newInstance(): DialogFragment {
      return LocationFragment()
    }
  }

}
