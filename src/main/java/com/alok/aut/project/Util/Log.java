package com.alok.aut.project.Util;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.lang.invoke.MethodHandles;
public class Log {
    //Initialize Log4j instance
    private static final Logger Log =  LogManager.getLogger(MethodHandles.lookup().lookupClass().getSimpleName());;

    //Info Level Logs
    public static void info (String message) {

        Log.info(message);
    }

    //Warn Level Logs
    public static void warn (String message) {
        Log.warn(message);
    }

    //Error Level Logs
    public static void error (String message) {
        Log.error(message);
    }

    //Fatal Level Logs
    public static void fatal (String message) {
        Log.fatal(message);
    }

    //Debug Level Logs
    public static void debug (String message) {
        Log.debug(message);
    }
}
