package com.leo.gms.util

import java.text.DateFormat
import java.text.SimpleDateFormat


class DateUtil {
    private static final String LONG_DATE_FORMAT = "dd/MM/yyyy HH:mm:ss";
    private static final String REF_DATE_FORMAT = "yyyyMMdd";
    private static final String INPUT_DATE_FORMAT = "dd/MM/yyyy";
    private static final String JS_DATE_FORMAT = "yyyy-MM-dd";
    private static final String JS_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    static String getDateFormatDDMMYYYYHHMMSS(Date date){
        return formatDate(date, LONG_DATE_FORMAT)
    }

    static Integer formatRefDate(Date inputDate) {
        if (!inputDate)
            return null
        return Integer.parseInt(formatDate(inputDate, REF_DATE_FORMAT))
    }

    static String formatDateForInput(Date inputDate) {
        if (!inputDate)
            return null
        return formatDate(inputDate, INPUT_DATE_FORMAT)
    }

    static String formatDateForJS(Date inputDate) {
        if (!inputDate)
            return null
        return formatDate(inputDate, JS_DATE_FORMAT)
    }

    static String formatDate(Date inputDate, String format) {
        if (!inputDate)
            return ""

        DateFormat df = new SimpleDateFormat(format)
        return df.format(inputDate)
    }

    static Date parseStringToDateFromInput(String inputDate) {
        return parseStringToDate(inputDate, INPUT_DATE_FORMAT)
    }

    static Date parseStringToDateFromJS(String inputDate) {
        return parseStringToDate(inputDate, JS_DATE_FORMAT)
    }

    static Date parseStringToDateTimeFromJS(String inputDate) {
        return parseStringToDate(inputDate, JS_DATETIME_FORMAT)
    }

    static Date parseStringToEndOfDayDateFromJS(String inputDate) {
        return parseStringToDate(inputDate + ' 23:59:59', JS_DATETIME_FORMAT)
    }

    static Date parseStringToStartOfDayDateFromJS(String inputDate) {
        return parseStringToDate(inputDate + ' 00:00:00', JS_DATETIME_FORMAT)
    }

    static Date parseStringToDate(String inputDate, String format) {
        if(!inputDate || !format)
            return null

        Date formatedDate
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(format)
            formatedDate  = dateFormat.parse(inputDate)
        }
        catch (Exception pe) {
            return null
        }

        return formatedDate
    }
}
