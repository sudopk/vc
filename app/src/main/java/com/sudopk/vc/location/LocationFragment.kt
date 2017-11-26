package com.sudopk.vc.location

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.app.AppCompatDialogFragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.*
import android.widget.Button
import android.widget.ProgressBar
import com.mcxiaoke.koi.ext.find
import com.sudopk.kandroid.parent
import com.sudopk.vc.R
import com.sudopk.vc.calendar.CalendarStore
import com.sudopk.vc.calendar.Country
import com.sudopk.vc.core.vcApp
import com.sudopk.vc.core.weak
import com.sudopk.vc.retrofit.VcService

class LocationFragment : AppCompatDialogFragment(), LocationContainer, LocationCallback {
    private lateinit var mAdapter: LocationAdapter
    private lateinit var mProgressBar: ProgressBar
    private lateinit var mVcService: VcService
    private lateinit var mLocationStore: LocationStore
    private lateinit var mCalendarStore: CalendarStore
    private lateinit var mRecyclerView: RecyclerView

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
        val view = inflater.inflate(R.layout.location, container, false)
        mProgressBar = view.find(R.id.progressBar)
        mRecyclerView = view.find(R.id.recyclerView)
        mRecyclerView.layoutManager = LinearLayoutManager(context)
        mAdapter = LocationAdapter(this, mCalendarStore.location)
        mRecyclerView.adapter = mAdapter

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater) {
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

    override fun onCancel(dialog: DialogInterface?) {
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
            mProgressBar.visibility = View.VISIBLE

            if (mLocationStore.hasLocations()) {
                onLocationResponse(mLocationStore.locations)
            } else {
                val locationRequest = LocationRemoteRequest(this.weak)
                locationRequest.makeRequest(mVcService)
            }
        }
    }

    override fun onLocationsReceived(countries: List<Country>) {
        if (isResumed) {
            mLocationStore.saveLocations(countries)
            onLocationResponse(mLocationStore.locations)
        }
    }

    override fun onLocationRequestFailed() {
        onLocationSelectFailed(getString(R.string.locations_failure))
    }


    private fun onLocationResponse(response: List<Country>) {
        if (isResumed) {
            mProgressBar.visibility = View.GONE
            mAdapter.setData(response)

            var position = mAdapter.getPosition(mCalendarStore.location)
            if (position > 0) {
                // lets scroll to location one before the actual one, looks little better
                position--
            }
            mRecyclerView.layoutManager
                    .scrollToPosition(position)
        }
    }

    companion object {
        val TAG = LocationFragment::class.java.name

        fun newInstance(): DialogFragment {
            return LocationFragment()
        }
    }

}
