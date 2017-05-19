package `in`.sudopk.vaishnavacalendar.location

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.DialogFragment
import android.support.v7.app.AppCompatDialogFragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.ProgressBar

import `in`.sudopk.coreandroid.Fm
import `in`.sudopk.coreandroid.Layout
import `in`.sudopk.vaishnavacalendar.R
import `in`.sudopk.vaishnavacalendar.VcApp
import `in`.sudopk.vaishnavacalendar.calendar.CalendarStore
import `in`.sudopk.vaishnavacalendar.calendar.Country
import `in`.sudopk.vaishnavacalendar.retrofit.VcService
import `in`.sudopk.vaishnavacalendar.vcApp
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LocationFragment : AppCompatDialogFragment(), LocationContainer {
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

    override fun onCreateView(inflater: LayoutInflater?,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.location, container, false)
        mProgressBar = Layout.findViewById<ProgressBar>(view, R.id.progressBar)
        mRecyclerView = Layout.findViewById<RecyclerView>(view, R.id.recyclerView)
        mRecyclerView.layoutManager = LinearLayoutManager(context)
        mAdapter = LocationAdapter(this, mCalendarStore.location)
        mRecyclerView.adapter = mAdapter
        return view
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater!!.inflate(R.menu.calendar, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item!!.itemId == R.id.refresh) {
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
        container.onLocationSelectCanceled()
    }

    override fun onLocationSelected(location: Location) {
        dismiss()
        container.onLocationSelected(location)
    }

    override fun onLocationSelectCanceled() {
        dismiss()
        container.onLocationSelectCanceled()
    }

    private val container: LocationContainer
        get() = Fm.container<LocationContainer>(this)

    private fun refresh() {
        if (isResumed) {
            mProgressBar.visibility = View.VISIBLE

            if (mLocationStore.hasLocations()) {
                onLocationResponse(mLocationStore.locations)
            } else {
                val locationsCall = mVcService.locations()
                locationsCall.enqueue(object : Callback<List<Country>> {
                    override fun onResponse(call: Call<List<Country>>, response: Response<List<Country>>) {
                        if (isResumed) {
                            if (response.body() != null) {
                                mLocationStore.saveLocations(response.body())
                                onLocationResponse(mLocationStore.locations)
                            } else {
                                failed()
                            }
                        }
                    }

                    override fun onFailure(call: Call<List<Country>>, t: Throwable) {
                        t.printStackTrace()
                        failed()
                    }
                })
            }
        }
    }

    private fun failed() {
        if (isResumed) {
            mProgressBar.visibility = View.GONE
            val v = view
            if (v != null) {
                Snackbar.make(v, R.string.locations_failure, Snackbar.LENGTH_SHORT).show()
            }
        }
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
