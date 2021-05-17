package com.sudopk.vc.update

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.sudopk.vc.retrofit.VcConfigService
import javax.inject.Inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CheckUpdateApi @Inject constructor(private val gson: Gson) : ViewModel() {
  private val vcConfig = MutableLiveData<VcConfig>()

  fun checkUpdate(): LiveData<VcConfig> {
    if (vcConfig.value != null) {
      return vcConfig
    }
    checkWithServer()
    return vcConfig
  }

  private fun checkWithServer() {
    val configService = VcConfigService.newInstance(gson).config()
    configService.enqueue(object : Callback<VcConfig> {
      override fun onResponse(call: Call<VcConfig>, response: Response<VcConfig>) {
        if (response.isSuccessful && response.body() != null) {
          vcConfig.value = response.body()
        } else {
          vcConfig.value = defaultVcConfig
        }
      }

      override fun onFailure(call: Call<VcConfig>, t: Throwable) {
        vcConfig.value = defaultVcConfig
      }
    })
  }
}