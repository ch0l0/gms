package com.leo.gms.util;

import java.util.regex.Pattern;

public class HtmlUtil {
    private static final String SCRIPT_TAG_REGEX = "\\s*(?i)(?:<[ \n\r]*script[^>]*>)(.*?)(?:<[ \n\r]*/script[^>]*>)";

    private static Pattern patternScriptTag = Pattern.compile(SCRIPT_TAG_REGEX,Pattern.CASE_INSENSITIVE| Pattern.DOTALL);

    public static String strippedHtmlTags(String html){
        String ret = html.replaceAll("<(.|\n)*?>", "");
        return ret.replaceAll("&nbsp;", " ").trim();
    }

    public static String strippedHtmlAndReplaceBRs(String html){
        return  strippedHtmlTags(html.replaceAll("<[Bb][Rr](.|\n)*?>", " "));
    }

    public static boolean isContainScriptTag(String html){
        return patternScriptTag.matcher(html).find();
    }
}
