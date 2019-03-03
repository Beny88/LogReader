package log;

import java.time.LocalDateTime;

public abstract class Builder {

    protected LocalDateTime dateTime;
    protected String thread;
    protected String user;
    protected LogType logType;

    public Builder setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
        return this;
    }

    public Builder setThread(String thread) {
        this.thread = thread;
        return this;
    }

    public Builder setUser(String user) {
        this.user = user;
        return this;
    }

    public Builder setLogType(LogType logType) {
        this.logType = logType;
        return this;
    }
}