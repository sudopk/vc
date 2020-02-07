package com.sudopk.vc.update

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sudopk.kandroid.isNotNull
import com.sudopk.vc.globals.Globals
import com.sudopk.vc.retrofit.VcConfigService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CheckUpdateApi : ViewModel() {
    private val vcConfig = MutableLiveData<VcConfig>()

    fun checkUpdate(): LiveData<VcConfig> {
        if (vcConfig.value.isNotNull()) {
            return vcConfig;
        }
        checkWithServer()
        return vcConfig;
    }

    private fun checkWithServer() {
        val configService = VcConfigService.newInstance(Globals.gson).config()
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