package `in`.sudopk.vaishnavacalendar

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

    private constructor(`in`: Parcel) :
            this(id = `in`.readString(),
                    title = `in`.readString())

    companion object {

        val CREATOR: Parcelable.Creator<ButtonDescription> = object : Parcelable.Creator<ButtonDescription> {
            override fun createFromParcel(`in`: Parcel): ButtonDescription {
                return ButtonDescription(`in`)
            }

            override fun newArray(size: Int): Array<ButtonDescription?> {
                return arrayOfNulls(size)
            }
        }
    }
}
