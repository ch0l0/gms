package com.leo.gms.util;


import com.leo.gms.enumeration.LoggingSystemsEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Default implementation of LoggingService, which redirects all logging to
 * slf4j.
 *
 * This implementation does not set up appenders, etc. This has to be done in
 * the log4j configuration file.
 *
 * @author kumar.deena
 * 		Version : 1.0 Date(created) : 14-02-2012
 *
 */
public class LoggingUtil {

	private static String LOGGER_CONFIG_PREFIX = "";//TODO

	/**
	 * by default getLogger return console logger
	 *
	 * @return the console logger
	 */
	public static Logger getLogger() {
		return getConsoleLogger();
	}

	/**
	 *
	 * @param clazz
	 *
	 * @return the console logger
	 */
	public static Logger getLogger(Class<?> clazz) {
		return LoggerFactory.getLogger(clazz);
	}

	/**
	 *
	 * @param loggingSystem
	 *
	 * @return the interface logger
	 */
	public static Logger getInterfaceLogger(LoggingSystemsEnum loggingSystem) {
		return LoggerFactory.getLogger(LOGGER_CONFIG_PREFIX + loggingSystem);
	}

	/**
	 *
	 * @return the console logger
	 */
	public static Logger getConsoleLogger() {
		return LoggerFactory.getLogger(LOGGER_CONFIG_PREFIX
				+ LoggingSystemsEnum.CONSOLE);
	}

	/**
	 *
	 * @return the audit logger
	 */
	public static Logger getAuditLogger() {
		return LoggerFactory.getLogger(LOGGER_CONFIG_PREFIX
				+ LoggingSystemsEnum.AUDIT_LOG_FILE);
	}

	/**
	 *
	 * @return the mail logger
	 */
	public static Logger getMailLogger() {
		return LoggerFactory.getLogger(LOGGER_CONFIG_PREFIX
				+ LoggingSystemsEnum.MAIL);
	}

	/**
	 *
	 * @param logger
	 * @param arg0
	 * @param arg1
	 * @param args
	 */
	public static void debugFmt(Logger logger, Object arg0, Throwable arg1,
			Object... args) {
		logger.debug(MsgHelper.format(arg0.toString(), args), arg1);
	}

	/**
	 *
	 * @param logger
	 * @param arg0
	 * @param args
	 */
	public static void debugFmt(Logger logger, Object arg0, Object... args) {
		logger.debug(MsgHelper.format(arg0.toString(), args));
	}

	/**
	 *
	 * @param logger
	 * @param arg0
	 * @param args
	 */
	public static void infoFmt(Logger logger, Object arg0, Object... args) {
		logger.info(MsgHelper.format(arg0.toString(), args));
	}

	/**
	 * Formats message objcet,inserts the formatted strings into the pattern at
	 * the appropriate places and then logs a formatted message object with the
	 * INFO level including the stack trace of the Throwable t passed as
	 * parameter.
	 *
	 * @param arg0
	 *            format of the message object to log.
	 * @param arg1
	 *            the exception to log, including its stack trace.
	 * @param args
	 *            array of message objects to log.
	 */
	public static void infoFmt(Logger logger, Object arg0, Throwable arg1,
			Object... args) {
		logger.info(MsgHelper.format(arg0.toString(), args), arg1);
	}

	/**
	 * Formats message objcet,inserts the formatted strings into the pattern at
	 * the appropriate places and then logs a formatted message object with the
	 * ERROR level.
	 *
	 * @param arg0
	 *            format of the message object to log.
	 * @param args
	 *            array of message objects to log.
	 */
	public static void errorFmt(Logger logger, Object arg0, Object... args) {
		logger.error(MsgHelper.format(arg0.toString(), args));
	}

	/**
	 * Formats message objcet,inserts the formatted strings into the pattern at
	 * the appropriate places and then logs a formatted message object with the
	 * ERROR level including the stack trace of the Throwable t passed as
	 * parameter.
	 *
	 * @param arg0
	 *            format of the message object to log.
	 * @param arg1
	 *            the exception to log, including its stack trace.
	 * @param args
	 *            array of message objects to log.
	 */
	public static void errorFmt(Logger logger, Object arg0, Throwable arg1,
			Object... args) {
		logger.error(MsgHelper.format(arg0.toString(), args), arg1);
	}

	/**
	 * Formats message objcet,inserts the formatted strings into the pattern at
	 * the appropriate places and then logs a formatted message object with the
	 * WARN level.
	 *
	 * @param arg0
	 *            format of the message object to log.
	 * @param args
	 *            array of message objects to log.
	 */
	public static void warnFmt(Logger logger, Object arg0, Object... args) {
		logger.warn(MsgHelper.format(arg0.toString(), args));
	}

	/**
	 * Formats message objcet,inserts the formatted strings into the pattern at
	 * the appropriate places and then logs a formatted message object with the
	 * WARN level including the stack trace of the Throwable t passed as
	 * parameter.
	 *
	 * @param arg0
	 *            format of the message object to log.
	 * @param arg1
	 *            the exception to log, including its stack trace.
	 * @param args
	 *            array of message objects to log.
	 */
	public static void warnFmt(Logger logger, Object arg0, Throwable arg1,
			Object... args) {
		logger.warn(MsgHelper.format(arg0.toString(), args), arg1);
	}

	/**
	 * Formats message object,inserts the formatted strings into the pattern at
	 * the appropriate places and then logs a formatted message object with the
	 * Trace level.
	 *
	 * @param arg0
	 *            format of the message object to log.
	 * @param args
	 *            array of message objects to log.
	 */
	public static void traceFmt(Logger logger, Object arg0, Object... args) {
		logger.trace(MsgHelper.format(arg0.toString(), args));
	}
}