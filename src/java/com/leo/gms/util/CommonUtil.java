package com.leo.gms.util;

import org.slf4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public final class CommonUtil {
    private static final Logger LOG = LoggingUtil.getLogger(CommonUtil.class);

    public static String reverseString(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }

        return sb.toString();
    }

    public static <T> List<T> mergeList(List<List<T>> list) {
        List<T> merged = new ArrayList<T>();
        for (List<T> part : list) {
            if (part != null) {
                merged.addAll(part);
            }
        }
        return merged;
    }

    public static <T> List<List<T>> splitList(List<T> list, int noOfMembers) {
        List<List<T>> parts = new ArrayList<List<T>>();
        final int N = list.size();
        for (int i = 0; i < N; i += noOfMembers) {
            parts.add(new ArrayList<T>(
                    list.subList(i, Math.min(N, i + noOfMembers))));
        }
        return parts;
    }

    public static int getRandomValue(int from, int to) {
        List<Integer> available = new ArrayList<Integer>();
        if (from <= to) {
            for (int i = from; i <= to; i++) {
                available.add(i);
            }
        } else {
            for (int i = to; i <= from; i++) {
                available.add(i);
            }
        }

        int randomIndex = (int) (Math.random() * available.size());
        return available.get(randomIndex);
    }

    public static int getRandomValueWithRange(int min, int max) {
        int range = Math.abs(max - min) + 1;
        return (int) (Math.random() * range) + (min <= max ? min : max);
    }

    public static String getClientIPFromRequest(final HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");

        if (ip == null) {
            ip = request.getRemoteAddr();
        } else {
            ip = ip.split(",")[0];
        }

        return ip;
    }

    public static String getClientCountryCodeFromRequest(final HttpServletRequest request) {
        String countryCode = request.getHeader("X-country");
        return countryCode == null || countryCode.isEmpty() ? "-" : countryCode;
    }
}
