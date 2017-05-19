package `in`.sudopk.vaishnavacalendar.calendar

import `in`.sudopk.vaishnavacalendar.location.Location

class Country(val name: String, val locations: List<Location>) : Comparable<Country> {

    override fun compareTo(other: Country): Int {
        return name.compareTo(other.name)
    }

    override fun equals(other: Any?): Boolean {
        return other is Country && compareTo(other) == 0
    }

    override fun hashCode(): Int {
        return name.hashCode();
    }
}
