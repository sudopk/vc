package com.sudopk.vaishnavacalendar.globals

import com.google.gson.GsonBuilder
import com.sudopk.vaishnavacalendar.gson.RemoveFieldNameStrategy

object Globals {
    val gson = GsonBuilder()
            .setFieldNamingStrategy(RemoveFieldNameStrategy())
            .create()

}