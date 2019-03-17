package log;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;



public class LogFactory {

    private static final int DATE = 0;
    private static final int TIME = 1;
    private static final int THREAD = 2;
    private static final int USER = 3;
    private static final int LOG_TYPE = 4;
    private static final int SQL_TYPE = 5;
    private static final int ORDER_NUMBER = 5;
    private static final int ITEM_AMOUNT = 6;
    private static final int VALUE = 7;
    private static final int DURATION = 6;
    private static final int ROWS = 7;
    private static final String CURRENT_YEAR = "2019";
    private static final String LOG_TIME_PATTERN = "dd/MM/yyyy HH:mm:ss";

    public static Log getLog(String logLine) {

        logLine = logLine.trim();
        String[] splitedLogLine = logLine.split(" ");

        String data = splitedLogLine[DATE];
        String time = splitedLogLine[TIME];
        String dataTime = String.format("%s/%s %s", data, CURRENT_YEAR, time);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(LOG_TIME_PATTERN, Locale.ENGLISH);
        LocalDateTime dateTime = LocalDateTime.parse(dataTime, formatter);
        String thread = splitedLogLine[THREAD];
        String user = splitedLogLine[USER];

        LogType logType;
        if (splitedLogLine[LOG_TYPE].equalsIgnoreCase("SQL")) {
            logType = LogType.getLogTypeByName(String.format("%s %s", splitedLogLine[LOG_TYPE], splitedLogLine[SQL_TYPE]));
        } else {
            logType = LogType.getLogTypeByName(splitedLogLine[LOG_TYPE]);
        }

        Long orderNumber;

        switch(logType) {
            case CREATE_ORDER:
                orderNumber = Long.parseLong(splitedLogLine[ORDER_NUMBER]);
                Integer itemAmount = Integer.parseInt(splitedLogLine[ITEM_AMOUNT].split("=")[1]);
                Double value = Double.parseDouble(splitedLogLine[VALUE].split("=")[1]);
                return createLogCreateOrder(dateTime, thread, user, logType, orderNumber, itemAmount, value);
            case CANCEL_ORDER:
                orderNumber = Long.parseLong(splitedLogLine[ORDER_NUMBER]);
                String reason = splitedLogLine[6];
                return createLogCancelOrder(dateTime, thread, user, logType, orderNumber, reason);
            case SQL_SELECT:
                String duration = splitedLogLine[DURATION];
                String rows = splitedLogLine[ROWS];
                String commend = splitedLogLine[8];
                return createLogSqlSelect(dateTime, thread, user, logType, duration, rows, commend);
            default:
                break;
        }

        return null;
    }

    private static LogCreateOrder createLogCreateOrder( LocalDateTime dateTime, String thread, String user, LogType logType, Long orderNumber, Integer itemAmount, Double value) {
        return (LogCreateOrder)new LogCreateOrder.LogCreateOrderBuilder()
                .setOrderNumber(orderNumber)
                .setItemAmount(itemAmount)
                .setValue(value)
                .setDateTime(dateTime)
                .setLogType(logType)
                .setThread(thread)
                .setUser(user)
                .build();
    }

    private static Log createLogCancelOrder(LocalDateTime dateTime, String thread, String user, LogType logType, Long orderNumber, String reason) {
        return (LogCancelOrder)new LogCancelOrder.LogCancelOrderBuilder()
                .setOrderNumber(orderNumber)
                .setReason(reason)
                .setDateTime(dateTime)
                .setLogType(logType)
                .setThread(thread)
                .setUser(user)
                .build();
    }

    private static LogSqlSelect createLogSqlSelect(LocalDateTime dateTime, String thread, String user, LogType logType, String duration, String rows, String commend) {
        return (LogSqlSelect)new LogSqlSelect.LogSqlSelectBuilder()
                .setDuration(duration)
                .setRows(rows)
                .setCommend(commend)
                .setDateTime(dateTime)
                .setLogType(logType)
                .setThread(thread)
                .setUser(user)
                .build();
    }
}
