package com.sudopk.vc.retrofit


class MockStrFromRes : StrFromRes {
    override fun getString(resId: Int): String = "MockString"

    override fun getString(resId: Int, vararg formatArgs: Any): String {
        return "MockStringWithFormatArgs"
    }
}