import log.Log;
import log.LogType;

import java.util.ArrayList;
import java.util.List;

public class LogListCheck {

    public List logSplit(List<String> logList) {
        List<Log> listOfLogs = new ArrayList<>();

       logList.forEach(logLine -> {
           logLine = logLine.trim();

           String[] podzielonyLogLine = logLine.split(" ");

           String data = podzielonyLogLine[0];
           String time = podzielonyLogLine[1];
           String thread = podzielonyLogLine[2];
           String user = podzielonyLogLine[3];

           LogType logType;
            if (podzielonyLogLine[4].equalsIgnoreCase("SQL")) {
                logType = LogType.getLogTypeByName(String.format("%s %s", podzielonyLogLine[4], podzielonyLogLine[5]));
            } else {
                logType = LogType.getLogTypeByName(podzielonyLogLine[4]);
            }

            Log log = new Log();
            log.setDate(data);
            log.setTime(time);
            log.setThread(thread);
            log.setUser(user);
            log.setLogType(logType);

            listOfLogs.add(log);
       });
        return listOfLogs;
    }

}
