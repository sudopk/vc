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
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import com.sudopk.kandroid.parent
import com.sudopk.vc.R
import com.sudopk.vc.calendar.CalendarStore
import com.sudopk.vc.calendar.Country
import com.sudopk.vc.core.weak
import com.sudopk.vc.retrofit.VcService
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LocationFragment : AppCompatDialogFragment(), LocationContainer, LocationCallback {
  @Inject lateinit var mVcService: VcService
  @Inject lateinit var mLocationStore: LocationStore
  @Inject lateinit var mCalendarStore: CalendarStore

  private val countryData = MutableLiveData<List<Country>>(emptyList())
  private val filteredCountryData = MutableLiveData<List<Country>>(emptyList())

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    //setHasOptionsMenu(true);

    setStyle(DialogFragment.STYLE_NORMAL, R.style.Theme_AppCompat_Light_Dialog)
  }

  override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
    val dialog = super.onCreateDialog(savedInstanceState)
    dialog.setTitle(R.string.location_title)
    return dialog
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    countryData.observe(this) { filteredCountryData.value = it }

    return ComposeView(requireContext()).also { view ->
      view.setContent {
        ShowLocations(filteredCountryData) { search ->
          if (search.isEmpty()) {
            filteredCountryData.value = countryData.value
            return@ShowLocations
          }
          val partitions =
            countryData.value!!.partition { it.name.contains(search, ignoreCase = true) }
          val partialCountries = partitions.second.mapNotNull { country ->
            val locations = country.locations.filter { it.name.contains(search, ignoreCase = true) }
            if (locations.isEmpty()) null else Country(country.name, locations)
          }
          filteredCountryData.value = partitions.first + partialCountries
        }
      }
    }
  }

  @Preview
  @Composable
  fun LocationsPreview() {
    val countries = listOf(
      Country("Country 1", listOf(Location("Location 1", "id 1"))),
    )
    val countryData = MutableLiveData(countries)
    ShowLocations(countryData) {}
  }

  @Composable
  @OptIn(ExperimentalFoundationApi::class)
  fun ShowLocations(
    countryData: MutableLiveData<List<Country>>,
    onSearch: (search: String) -> Unit
  ) {
    val countries by countryData.observeAsState(emptyList())
    val search = remember { mutableStateOf("") }
    if (countries.isEmpty() && search.value.isEmpty()) {
      Box { LinearProgressIndicator(Modifier.fillMaxWidth()) }
      return
    }

    Column {
      TextField(search.value, onValueChange = {
        search.value = it
        onSearch(it)
      }, leadingIcon = {
        Icon(imageVector = Icons.Filled.Search, contentDescription = "Search")
      }, modifier = Modifier.fillMaxWidth())
      val listState = rememberLazyListState()
      LazyColumn(state = listState) {
        countries.forEach { country ->
          stickyHeader {
            Text(
              country.name,
              Modifier
                .background(MaterialTheme.colors.secondary)
                .padding(8.dp)
                .fillMaxWidth()
            )
            Divider()
          }
          items(country.locations) { loc ->
            var modifier =
              Modifier.clickable { onLocationSelected(loc) }
            if (loc == mCalendarStore.location) {
              modifier = modifier.background(Color.LightGray)
            }
            modifier = modifier
              .padding(8.dp)
              .fillMaxWidth()
            Text(loc.name, modifier)
            Divider()
          }
        }
      }
      LaunchedEffect("location") {
        var index = 0
        countries.forEach {
          it.locations.forEachIndexed { i, location ->
            if (location == mCalendarStore.location) {
              listState.animateScrollToItem(index + i)
              return@LaunchedEffect
            }
          }
          index += it.locations.size + 1
        }
      }
    }
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
      countryData.value = emptyList()
      if (mLocationStore.hasLocations()) {
        onLocationResponse(mLocationStore.locations)
      } else {
        val locationRequest = LocationRemoteRequest(this.weak)
        lifecycleScope.launch {
          locationRequest.makeRequest(mVcService)
        }
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
      countryData.value = response
    }
  }

  companion object {
    val TAG: String = LocationFragment::class.java.name

    fun newInstance(): DialogFragment {
      return LocationFragment()
    }
  }
}
