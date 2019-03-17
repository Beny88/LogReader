package log;

import java.time.LocalDateTime;

public class LogSqlSelect extends Log {

    private final String duration;
    private final String rows;
    private final String commend;

    private LogSqlSelect(LocalDateTime dateTime, String thread, String user, LogType logType, String duration, String rows, String commend){

        super(dateTime, thread, user, logType);

        this.duration = duration;
        this.rows = rows;
        this.commend = commend;
    }

    public String getDuration() {
        return duration;
    }

    public String getRows() {
        return rows;
    }

    public String getCommend() {
        return commend;
    }

    public static class LogSqlSelectBuilder extends Builder {
        private String duration;
        private String rows;
        private String commend;

        public LogSqlSelectBuilder setDuration(String duration) {
            this.duration = duration;
            return this;
        }

        public LogSqlSelectBuilder setRows(String rows) {
            this.rows = rows;
            return this;
        }

        public LogSqlSelectBuilder setCommend(String commend) {
            this.commend = commend;
            return this;
        }

        public LogSqlSelect build(){ return new LogSqlSelect(dateTime, thread, user, logType, duration, rows, commend);
        }
    }
}
