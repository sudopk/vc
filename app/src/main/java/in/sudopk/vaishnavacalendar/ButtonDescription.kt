package `in`.sudopk.vaishnavacalendar

import android.os.Parcel
import android.os.Parcelable

class ButtonDescription : Parcelable {
    val title: String
    val id: String

    constructor(title: String, id: String) {
        this.title = title
        this.id = id
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(title)
        dest.writeString(id)
    }

    private constructor(`in`: Parcel) {
        title = `in`.readString()
        id = `in`.readString()
    }

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
