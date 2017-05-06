package in.sudopk.vaishnavacalendar;

import android.os.Parcel;
import android.os.Parcelable;

public class ButtonDescription implements Parcelable {
    public final String title;
    public final String id;

    public ButtonDescription(String title, String id) {
        this.title = title;
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(final Parcel dest, final int flags) {
        dest.writeString(title);
        dest.writeString(id);
    }

    public static final Parcelable.Creator<ButtonDescription> CREATOR
            = new Parcelable.Creator<ButtonDescription>() {
        public ButtonDescription createFromParcel(Parcel in) {
            return new ButtonDescription(in);
        }

        public ButtonDescription[] newArray(int size) {
            return new ButtonDescription[size];
        }
    };

    private ButtonDescription(Parcel in) {
        title = in.readString();
        id = in.readString();
    }
}
