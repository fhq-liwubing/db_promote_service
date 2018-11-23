package com.db.promote.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * 日志工具
 *
 * Created by weijianglong on 2017-06-05.
 */
public class LogUtil {

    public static void error(String msg) {
        log(Level.ERROR, msg);
    }

    public static void error(String msg, Exception e) {
        log(Level.ERROR, msg + ", " + e.getMessage());
    }

    public static void warn(String msg) {
        log(Level.WARN, msg);
    }

    public static void warn(String msg, Exception e) {
        log(Level.WARN, msg + ", " + e.getMessage());
    }

    public static void info(String msg) {
        log(Level.INFO, msg);
    }

    public static void info(String msg, Exception e) {
        log(Level.INFO, msg + ", " + e.getMessage());
    }

    public static void debug(String msg) {
        log(Level.DEBUG, msg);
    }

    public static void debug(String msg, Exception e) {
        log(Level.DEBUG, msg + ", " + e.getMessage());
    }

    private static void log(Level level, String msg) {
        ClassInfo classInfo = getClassInfo();

        Logger logger = LoggerFactory.getLogger(classInfo.className);

        String content = new LogMetaData.Builder()
                .setLevel(level)
                .setClassInfo(classInfo)
                .setMsg(msg)
                .build().toString();

        switch (level) {
            case ERROR:
                if (logger.isErrorEnabled()) {
                    logger.error(content);
                }

                break;
            case WARN:
                if (logger.isWarnEnabled()) {
                    logger.warn(content);
                }

                break;
            case INFO:
                if (logger.isInfoEnabled()) {
                    logger.info(content);
                }

                break;
            case DEBUG:
                if (logger.isDebugEnabled()) {
                    logger.debug(content);
                }

                break;
            default:
        }
    }


    /**
     * 获取类信息
     *
     * @return
     * @see ClassInfo
     */
    private static ClassInfo getClassInfo() {
        Throwable t = new Throwable();
        StackTraceElement[] e = t.getStackTrace();

        // 寻找调用的类所在的方法，需要向上回溯2层：
        // 第一层：LogUtil.getClassInfo
        // 第二层：LogUtil.log
        // 第三层：LogUtil.info/debug/warn/error
        int depth = 3;

        ClassInfo classInfo = new ClassInfo();
        classInfo.className = e[depth].getClassName();
        classInfo.lineNo = e[depth].getLineNumber();

        return classInfo;
    }


    private enum Level {
        ERROR,WARN,INFO,DEBUG
    }


    private static final class ClassInfo {

        public String className;
        public String methodName;
        public int lineNo;

        @Override
        public String toString() {
            if (null != methodName && methodName.length() > 0) {
                return className + "#" + methodName + ":" + lineNo;
            } else {
                return className + ":" + lineNo;
            }
        }
    }


    private static final class LogMetaData {

        /**
         * 日志级别
         */
        public Level level;

        /**
         * 被调函数信息
         */
        public ClassInfo classInfo;

        /**
         * 日志正文
         */
        public String msg;

        /**
         * 日志字段分隔符
         */
        public String split = "|";

        public String timeFormat = "yyyy-MM-dd HH:mm:ss:SSS";

        /**
         * 日志格式：时间|级别|线程id|类#方法:行号 -- 日志正文
         *
         * @return
         */
        public String formatLog() {
            return formatPrefix() + " -- " + msg;
        }

        /**
         * 格式化日志前缀
         *
         * @return
         */
        public String formatPrefix() {
            return DateUtil.format(timeFormat, new Date()) + split
                    + level + split
                    + Thread.currentThread().getId() + split
                    + classInfo;
        }

        @Override
        public String toString() {
            return formatLog();
        }

        public static class Builder {
            private LogMetaData logMetaData = new LogMetaData();

            public LogMetaData.Builder setLevel(Level level) {
                logMetaData.level = level;
                return this;
            }

            public LogMetaData.Builder setClassInfo(ClassInfo classInfo) {
                logMetaData.classInfo = classInfo;
                return this;
            }

            public LogMetaData.Builder setMsg(String msg) {
                logMetaData.msg = msg;
                return this;
            }

            public LogMetaData.Builder setTimeFormat(String format) {
                logMetaData.timeFormat = format;
                return this;
            }

            public LogMetaData build() {
                return logMetaData;
            }
        }

    }
}
