package com.sudopk.vaishnavacalendar

import java.io.Serializable

data class VcConfig(val version: VcVersion = VcVersion(0, 0)) : Serializable

data class VcVersion(val soft: Int, val hard: Int) : Serializable

val defaultVcConfig = VcConfig()
