package com.sudopk.vaishnavacalendar.location

class Location(val name: String, val id: String) : Comparable<Location> {

    override fun compareTo(other: Location): Int {
        return name.compareTo(other.name)
    }

    override fun equals(other: Any?): Boolean {
        return other is Location && compareTo((other)) == 0
    }

    override fun hashCode(): Int {
        return name.hashCode();
    }
}
