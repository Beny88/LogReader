import log.Log;
import log.LogType;
import java.util.List;
import java.util.stream.Collectors;

public class Report {

    public List filterByLogType(List<Log> listOfLogs, LogType logType) {
        List<Log> listOfLogsByType = listOfLogs
                .stream()
                .filter(log -> log.getLogType().equals(logType))
                .collect(Collectors.toList());
        return listOfLogsByType;
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

    public void reportOfTreadsByTypeFromAll(List<Log> listOfLogs, LogType logType){
        int sumOfAllLogs = listOfLogs.size();
        int logsOfType = filterByLogType(listOfLogs,logType).size();
        System.out.println("We have " + logsOfType + "from" + sumOfAllLogs + "of" + logType);
    }

    public void reportOfCreateOrderFromAll (List<Log> listOfLogs){
        reportOfTreadsByTypeFromAll(listOfLogs,LogType.CREATE_ORDER);
    }

    public void reportOfTreadsByTypeFromAll(List<Log> listOfLogs, LogType logType, Log date){

    }
}


