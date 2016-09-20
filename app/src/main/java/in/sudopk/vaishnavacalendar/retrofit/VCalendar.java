package in.sudopk.vaishnavacalendar.retrofit;

import java.util.List;
import java.util.Map;

public class VCalendar {
    public static class Request {
        private final int mLocationId;
        private final int mMonth;
        private final int mYear;

        public Request(final int locationId, final int month, final int year) {
            mLocationId = locationId;
            mMonth = month;
            mYear = year;
        }
    }
    public static class Response {
        private Map<Integer, List<String>> mCalendar;

        public Map<Integer, List<String>> getCalendar() {
            return mCalendar;
        }
    }
}
