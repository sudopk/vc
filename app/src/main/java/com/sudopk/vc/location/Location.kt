package com.sudopk.vc.location

data class Location(val name: String, val id: String) : Comparable<Location> {
  override fun compareTo(other: Location): Int {
    return name.compareTo(other.name)
  }
}
