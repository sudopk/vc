package com.sudopk.vc.retrofit

import com.sudopk.kandroid.StrFromRes

class MockStrFromRes : StrFromRes {
  override fun getString(resId: Int): String = "MockString"

  override fun getString(resId: Int, vararg formatArgs: Any): String {
    return "MockStringWithFormatArgs"
  }
}