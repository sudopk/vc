package com.sudopk.vc.location

import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sudopk.vc.R
import kotlinx.android.extensions.LayoutContainer
import java.util.*
import kotlinx.android.synthetic.main.location_cell.textView as textViewCell
import kotlinx.android.synthetic.main.location_header_cell.textView as textViewHeader

class LocationAdapter(private val mContainer: LocationContainer, private val mSelectedLocation:
Location?) : RecyclerView.Adapter<LocationAdapter.VH>() {
    private val mLocations = ArrayList<Location>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(LayoutInflater.from(parent.context)
                .inflate(R.layout.location_cell, parent, false), mContainer)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.setLocation(mLocations.get(position), mSelectedLocation)
    }

    override fun getItemCount(): Int {
        return mLocations.size
    }

    fun setData(data: List<Location>) {
        mLocations.clear()
        mLocations.addAll(data)
        Collections.sort(mLocations)

        notifyDataSetChanged()
    }

    fun getPosition(location: Location?): Int {
        if (location == null) {
            return -1;
        }
        for (i in mLocations.size - 1 downTo 0) {
            if (mLocations[i] == location) {
                return i;
            }
        }
        return -1
    }

    class VH internal constructor(itemView: View, container: LocationContainer) : RecyclerView.ViewHolder(itemView), LayoutContainer {
        private lateinit var mLocation: Location

        init {
            itemView.setOnClickListener {
                container.onLocationSelected(mLocation)
            }
        }

        override val containerView: View?
            get() = itemView

        fun setLocation(location: Location, currentlySelectedLocation: Location?) {
            mLocation = location;
            if (location == currentlySelectedLocation) {
                textViewCell.setBackgroundColor(ContextCompat.getColor(textViewCell.context, R
                        .color.selectedCellColor))
            } else {
                textViewCell.setBackgroundColor(0xffffff)
            }
            textViewCell.text = location.name
        }
    }
}
