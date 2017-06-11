package `in`.sudopk.vaishnavacalendar

class VcConfig(val version: VcVersion = VcVersion(0, 0))

data class VcVersion(val soft: Int, val hard: Int)
