package com.leo.gms.util

import org.slf4j.Logger

import java.text.NumberFormat
import java.text.ParsePosition
import java.util.regex.Pattern

class ValidatorUtil {
    private static final Logger LOG = LoggingUtil.getLogger(ValidatorUtil.class)

    private static NumberFormat nf = NumberFormat.getNumberInstance(Locale.ENGLISH)
    private static Pattern patternEmail = Pattern.compile("^([\\w-]+(?:\\.[\\w-]+)*)@((?:[\\w-]+\\.)*\\w[\\w-]{0,66})\\.([a-z]{2,6}(?:\\.[a-z]{2})?)\$",Pattern.CASE_INSENSITIVE)
    private static Pattern numAndLettersPattern = Pattern.compile("^[a-zA-Z0-9]+\$")

    static boolean isValidEmail(String theText){
        if (!theText || theText.isAllWhitespace())
            return false
        else
            return patternEmail.matcher(theText).matches()
    }

    static boolean isNumeric(String theText){
        if (!theText || theText.isAllWhitespace())
            return false

        def formatter = nf
        def pos = [0] as ParsePosition
        formatter.parse(theText, pos)
        // if parse position index has moved to end of string
        // them the whole string was numeric
        return pos.index == theText.size()
    }

    static boolean isNegativeNum(String theText){
        if (isNumeric(theText)){
            return theText.replaceAll(",","").toBigDecimal().compareTo(BigDecimal.ZERO)<0
        } else {
            return false
        }
    }

    static boolean isNumAndLettersOnly(String theText){
        if (!theText || theText.isAllWhitespace())
            return false
        else{
            return numAndLettersPattern.matcher(theText).matches()
        }
    }
}
