package com.vazhamarshal.yesnote.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by akaki on 05.12.16.
 */

public class DateUtils {

    private static final String PATTERN = "d MMMM yyyy - HH:mm";

    private static DateFormat sDateFormatter;

    static {
        sDateFormatter = new SimpleDateFormat(PATTERN, Locale.US);
    }

    public static String toDateString(long time) {
        return sDateFormatter.format(new Date(time));
    }
}
