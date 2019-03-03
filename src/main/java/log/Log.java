package log;


import java.time.LocalDateTime;

public abstract class Log {

    private final LocalDateTime dateTime;
    private final String thread;
    private final String user;
    private final LogType logType;

    Log(LocalDateTime dateTime, String thread, String user, LogType logType) {
        this.dateTime = dateTime;
        this.thread = thread;
        this.user = user;
        this.logType = logType;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getThread() {
        return thread;
    }

    public String getUser() {
        return user;
    }

    public LogType getLogType() {
        return logType;
    }

}