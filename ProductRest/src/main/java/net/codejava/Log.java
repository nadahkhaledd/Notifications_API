package net.codejava;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.FileAppender;

public class Log {
	
	public static void logging() {
		FileAppender<ILoggingEvent> myAppender = new FileAppender<ILoggingEvent>();
		LoggerContext loggerContext=(LoggerContext)LoggerFactory.getILoggerFactory();
		loggerContext.reset();
		PatternLayoutEncoder layout=new PatternLayoutEncoder();
		layout.setContext(loggerContext);
		layout.setPattern("%X{first} %X{last} - %m%n");
		layout.start();
		myAppender.setAppend(true);
		myAppender.setFile("logs/testFile1.log");
	    myAppender.setName("File1");
	    myAppender.setEncoder(layout);
		myAppender.setContext(loggerContext);
		myAppender.start();
		ch.qos.logback.classic.Logger logbackLogger = loggerContext.getLogger("Main");
		logbackLogger.addAppender(myAppender);
		logbackLogger.setLevel(Level.DEBUG);
		logbackLogger.setAdditive(true);
	}
}
