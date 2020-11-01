package com.sudopk.vc.location

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.sudopk.vc.R
import com.sudopk.vc.calendar.Country
import java.util.Collections
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.location_cell.textView as textViewCell

class LocationAdapter(
  private val mContainer: LocationContainer, private val mSelectedLocation:
  Location?
) : RecyclerView.Adapter<LocationAdapter.VH>() {
  private val mCountries = ArrayList<Country>()
  private var mCountryIndex = IntArray(0)
  private var mCountryIndexCumulative = IntArray(0)

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
    if (viewType == HEADER_VIEW_TYPE) {
      return VH(
        LayoutInflater.from(parent.context)
          .inflate(R.layout.location_header_cell, parent, false), mContainer
      )
    } else {
      return VH(
        LayoutInflater.from(parent.context)
          .inflate(R.layout.location_cell, parent, false), mContainer
      )
    }
  }

  override fun onBindViewHolder(holder: VH, position: Int) {
    holder.setCountry(
      mCountries[mCountryIndex[position]],
      mCountryIndexCumulative[position], mSelectedLocation
    )
  }

  override fun getItemCount(): Int {
    return mCountryIndex.size
  }

  override fun getItemViewType(position: Int): Int {
    if (position == 0 || mCountryIndex[position] != mCountryIndex[position - 1]) {
      return HEADER_VIEW_TYPE
    } else {
      return CELL_VIEW_TYPE
    }
  }

  fun setData(data: List<Country>) {
    mCountries.clear()
    mCountries.addAll(data)
    Collections.sort(mCountries)

    updateCountryIndices(mCountries)

    notifyDataSetChanged()
  }

  private fun updateCountryIndices(countries: List<Country>) {
    var total = countries.size
    for (country in countries) {
      total += country.locations.size
    }
    mCountryIndex = IntArray(total)
    mCountryIndexCumulative = IntArray(total)
    var index = 0
    var cumulativeIndex = 0
    for (country in countries) {
      val nextCumulativeIndex = cumulativeIndex + country.locations.size + 1
      for (i in cumulativeIndex..nextCumulativeIndex - 1) {
        mCountryIndex[i] = index
        mCountryIndexCumulative[i] = cumulativeIndex
      }
      index++
      cumulativeIndex = nextCumulativeIndex
    }
  }

  fun getPosition(location: Location?): Int {
    var position = 0
    if (location != null) {
      for (country in mCountries) {
        position++
        for (l in country.locations) {
          if (l.id == location.id) {
            return position
          }
          position++
        }
      }
    }
    return 0
  }

  class VH internal constructor(itemView: View, container: LocationContainer) :
    RecyclerView.ViewHolder(itemView), LayoutContainer {
    private lateinit var mLocation: Location

    init {
      itemView.setOnClickListener {
        if (itemViewType != HEADER_VIEW_TYPE) {
          container.onLocationSelected(mLocation)
        }
      }
    }

    override val containerView: View?
      get() = itemView

    fun setCountry(country: Country, countryIndex: Int, selectedLocation: Location?) {
      if (itemViewType == HEADER_VIEW_TYPE) {
        textViewCell.text = country.name
      } else {
        mLocation = country.locations[adapterPosition - countryIndex - 1]
        if (mLocation == selectedLocation) {
          textViewCell.setBackgroundColor(
            ContextCompat.getColor(
              textViewCell.context, R
                .color.selectedCellColor
            )
          )
        } else {
          textViewCell.setBackgroundColor(0xffffff)
        }
        textViewCell.text = mLocation.name
      }
    }
  }

  companion object {
    private val TAG = "CalendarAdapter"
    private val HEADER_VIEW_TYPE = 0
    private val CELL_VIEW_TYPE = 1
  }
}
