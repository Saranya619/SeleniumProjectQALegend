package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtility {
	
	// Returns the current date
	public static String getCurrentDate(String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(new Date());
	}
	
	// Returns current time in "HH:mm:ss" format
    public static String getCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(new Date());
    }

    // Returns current date and time in "yyyy-MM-dd HH:mm:ss" format
    public static String getCurrentDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }

    // Formats a given Date object to a custom pattern
    public static String formatDate(Date date, String pattern) {
        if (date == null || pattern == null) return null;
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    // Parses a date string into a Date object
    public static Date parseDate(String dateString, String pattern) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            return sdf.parse(dateString);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Returns current timestamp in milliseconds
    public static long getCurrentTimestamp() {
        return System.currentTimeMillis();
    }
}
