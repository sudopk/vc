package com.sudopk.vaishnavacalendar.location

interface LocationContainer {
    fun onLocationSelected(location: Location)

    fun onLocationSelectCanceled()

    fun onLocationSelectFailed(error: String)

    fun onLocationSelectExit()
}
