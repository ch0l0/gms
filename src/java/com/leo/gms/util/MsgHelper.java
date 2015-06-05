package com.leo.gms.util;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class MsgHelper {

    private static final Pattern keyPattern = Pattern.compile("\\$\\{([a-zA-Z][a-zA-Z0-9_]*(\\.[a-zA-Z][a-zA-Z0-9_]*)*)\\}");

    /**
	 * private static constructor.
	 */
	private MsgHelper() {
		
	}

	private static HashMap<String, MessageFormat> messageFormatMap = new HashMap<String, MessageFormat>();

	/**
	 * Formats message objcet,inserts the formatted strings into the pattern at
	 * the appropriate places.
	 * 
	 * @param message
	 *            format of the message object to log.
	 * @param args
	 *            array of message objects to log.
	 *            
	 * @return formatted string
	 */
	public static String format(String message, Object... args) {
		MessageFormat mf = messageFormatMap.get(message);
		if (mf == null) {
			mf = new MessageFormat(message);
			messageFormatMap.put(message, mf);
		}
		return mf.format(args);
	}

    public static String formatMsg(String message, Map<String, Object> argMap){
        Matcher m = keyPattern.matcher(message);
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            String k = m.group(1);
            Object vobj = argMap.get(k);
            String v = (vobj == null)? "": vobj.toString();
            m.appendReplacement(sb, Matcher.quoteReplacement(v));
        }
        m.appendTail(sb);
        return sb.toString();
    }

}
