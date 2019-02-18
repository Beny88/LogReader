import log.Log;
import log.LogType;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
public class Report {

    private static final String LOG_TIME_PATTERN = "dd/MM/yyyy HH:mm:ss";

    public List filterByLogType(List<Log> listOfLogs, LogType logType) {
        List<Log> listOfLogsByType = listOfLogs
                .stream()
                .filter(log -> log.getLogType().equals(logType))
                .collect(Collectors.toList());
        return listOfLogsByType;
    }

    public LocalDateTime createDateOfReport(){

        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(LOG_TIME_PATTERN, Locale.ENGLISH);
        System.out.println("Give Date and Time of report in format");
        System.out.println("Day/Month/Year Hour:Minutes:Seconds");
        System.out.println(LOG_TIME_PATTERN);

        String date = sc.nextLine();

        return LocalDateTime.parse(date, formatter);
    }

    public List listCreateOrder(List<Log> listOfLogs){
        return this.filterByLogType(listOfLogs, LogType.CREATE_ORDER);
    }

    public List listCancelOrder(List<Log> listOfLogs) {
        return this.filterByLogType(listOfLogs, LogType.CREATE_ORDER);
    }

    public List listOrderLine(List<Log> listOfLogs){
        return this.filterByLogType(listOfLogs, LogType.ORDER_LINE);
    }

    public List listSqlUpdate(List<Log> listOfLogs){
        return this.filterByLogType(listOfLogs, LogType.SQL_UPDATE);
    }

    public List listSqlSelect(List<Log> listOfLogs){
        return this.filterByLogType(listOfLogs, LogType.SQL_SELECT);
    }

    public List listSqlDelete(List<Log> listOfLogs){
        return this.filterByLogType(listOfLogs, LogType.SQL_DELETE);
    }

    public String reportOfTreadsByTypeFromAll(List<Log> listOfLogs, LogType logType){
        int sumOfAllLogs = listOfLogs.size();
        int logsOfType = filterByLogType(listOfLogs,logType).size();
        String reportOfTreadsByTypeFromAll = "We have " + logsOfType + " from " + sumOfAllLogs + " of " + logType;
       return reportOfTreadsByTypeFromAll;
    }

    public void reportOfCreateOrderFromAll (List<Log> listOfLogs){
        reportOfTreadsByTypeFromAll(listOfLogs,LogType.CREATE_ORDER);
    }

    public void reportOfTreadsByTypeInTime(List<Log> listOfLogs, LogType logType, Set<LocalDateTime> datesOfReport){
        int logsOfType = filterByLogType(listOfLogs,logType).size();

    }
}


