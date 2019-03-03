package log;

import java.time.LocalDateTime;

public class LogCreateOrder extends Log {

    private final Long orderNumber;
    private final Integer itemAmount;
    private final Long value;

    private LogCreateOrder(LocalDateTime dateTime, String thread, String user, LogType logType,
            Long orderNumber, Integer itemAmount, Long value){

        super(dateTime, thread, user, logType);

        this.orderNumber = orderNumber;
        this.itemAmount = itemAmount;
        this.value = value;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public Integer getItemAmount() {
        return itemAmount;
    }

    public Long getValue() {
        return value;
    }

    public static class LogCreateOrderBuilder extends Builder {

        private Long orderNumber;
        private Integer itemAmount;
        private Long value;

        public LogCreateOrderBuilder setOrderNumber(Long orderNumber) {
            this.orderNumber = orderNumber;
            return this;
        }

        public LogCreateOrderBuilder setItemAmount(Integer itemAmount) {
            this.itemAmount = itemAmount;
            return this;
        }

        public LogCreateOrderBuilder setValue(Long value) {
            this.value = value;
            return this;
        }

        public LogCreateOrder build(){ return new LogCreateOrder(dateTime, thread, user, logType, orderNumber, itemAmount, value);}
    }
}
