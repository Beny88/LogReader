import log.Log;
import log.LogType;

import java.util.List;

public class Main {
    public static void main (String[] args ){
        FileLoader fileLoader = new FileLoader();
        List<String> logi = fileLoader.loadLog();

        LogListCheck logListCheck = new LogListCheck();
        List<Log> listOfLogs = logListCheck.logSplit(logi);
    System.out.println(listOfLogs.size());
    Report report = new Report();
    System.out.println(report.reportOfTreadsByTypeFromAll(listOfLogs,LogType.CREATE_ORDER));

    System.out.println(report.reportOfTreadsInTimeByType(listOfLogs,LogType.CREATE_ORDER));
    }
}
