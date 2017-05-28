package `in`.sudopk.vaishnavacalendar.location

interface LocationContainer {
    fun onLocationSelected(location: Location)

    fun onLocationSelectCanceled()

    fun onLocationSelectFailed(error: String)
}
