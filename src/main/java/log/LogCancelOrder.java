package log;

import java.time.LocalDateTime;

public class LogCancelOrder extends Log {
    private final Long orderNumber;
    private final String reason;

    private LogCancelOrder (LocalDateTime dateTime, String thread, String user, LogType logType, Long orderNumber, String reason){

        super(dateTime, thread, user, logType);

        this.orderNumber = orderNumber;
        this.reason = reason;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public String getReason() {
        return reason;
    }

    public static class LogCancelOrderBuilder extends Builder {

        private  Long orderNumber;
        private  String reason;

        public LogCancelOrderBuilder setOrderNumber(Long orderNumber) {
            this.orderNumber = orderNumber;
            return this;
        }

        public LogCancelOrderBuilder setReason(String reason) {
            this.reason = reason;
            return this;
        }

        public LogCancelOrder build(){ return  new LogCancelOrder(dateTime, thread, user, logType, orderNumber, reason);}
    }
}
