package com.sudopk.vc.globals

import com.google.gson.GsonBuilder
import com.sudopk.vc.gson.RemoveFieldNameStrategy

object Globals {
  val gson = GsonBuilder()
    .setFieldNamingStrategy(RemoveFieldNameStrategy())
    .create()

}