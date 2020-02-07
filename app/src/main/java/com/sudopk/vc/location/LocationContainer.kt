package com.sudopk.vc.location

interface LocationContainer {
  fun onLocationSelected(location: Location)

  fun onLocationSelectCanceled()

  fun onLocationSelectFailed(error: String)
}
