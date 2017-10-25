package com.sudopk.vaishnavacalendar.retrofit

import com.sudopk.coreandroid.StrFromRes
import android.test.mock.MockContext


class MockStrFromRes: StrFromRes {
    override fun getString(resId: Int): String = "MockString"

    override fun getString(resId: Int, vararg formatArgs: Any): String {
        return "MockStringWithFormatArgs"
    }
}