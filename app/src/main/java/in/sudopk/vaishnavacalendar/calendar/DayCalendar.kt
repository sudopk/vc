package `in`.sudopk.vaishnavacalendar.calendar

class DayCalendar(val date: Int, val events: List<String>) : Comparable<DayCalendar> {

    override fun compareTo(other: DayCalendar): Int {
        return date - other.date
    }

    override fun equals(other: Any?): Boolean {
        return other is DayCalendar && compareTo(other) == 0
    }

    override fun hashCode(): Int {
        return date;
    }
}
