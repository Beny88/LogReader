package log;

import java.util.Arrays;

public enum LogType {
    CREATE_ORDER("CreateOrder"),
    CANCEL_ORDER("CancelOrder"),
    ORDER_LINE("OrderLine"),
    SQL_SELECT("SQL SELECT"),
    SQL_UPDATE("SQL UPDATE"),
    SQL_DELETE("SQL DELETE");

    private String name;

    LogType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static LogType getLogTypeByName(String name) {
        return Arrays.asList(LogType.values())
                .stream()
                .filter(logType -> logType.getName().equalsIgnoreCase(name))
                .findAny()
                .orElseThrow(() -> new NullPointerException(String.format("niema takiego enuma dla  podanego name %s", name)));
    }
}
