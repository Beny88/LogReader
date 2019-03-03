import Report.Report;
import log.Log;
import log.LogType;

import java.util.List;

public class Main {
    public static void main (String[] args ){
        FileLoader fileLoader = FileLoader.getInstance();
        List<String> logi = fileLoader.loadLog();

        LogListCheck logListCheck = LogListCheck.getInstance();

        List<Log> listOfLogs = logListCheck.logSplit(logi);
        System.out.println(listOfLogs.size());
        Report report = Report.getInstance();
        System.out.println(report.reportOfTreadsByTypeFromAll(listOfLogs,LogType.CREATE_ORDER));
        System.out.println(report.reportOfTreadsInTimeByType(listOfLogs,LogType.CREATE_ORDER));
    }
}
//stworz 2 singletony z loglist check i report