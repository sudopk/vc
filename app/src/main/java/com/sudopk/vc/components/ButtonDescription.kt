package com.sudopk.vc.components

import android.os.Parcel
import android.os.Parcelable

class ButtonDescription(val id: String, val title: String) : Parcelable {
    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(id)
        dest.writeString(title)
    }

    private constructor(parcel: Parcel) :
            this(id = parcel.readString(),
                    title = parcel.readString())

    companion object {

        val CREATOR: Parcelable.Creator<ButtonDescription> = object : Parcelable.Creator<ButtonDescription> {
            override fun createFromParcel(parcel: Parcel): ButtonDescription {
                return ButtonDescription(parcel)
            }

            override fun newArray(size: Int): Array<ButtonDescription?> {
                return arrayOfNulls(size)
            }
        }
    }
}
