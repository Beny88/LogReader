import log.Log;
import log.LogType;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class LogListCheck {

    private static final String CURRENT_YEAR = "2019";
    private static final String LOG_TIME_PATTERN = "dd/MM/yyyy HH:mm:ss";

    public List logSplit(List<String> logList) {
        List<Log> listOfLogs = new ArrayList<>();

       logList.forEach(logLine -> {
           logLine = logLine.trim();
           String[] splitedLogLine = logLine.split(" ");

           String data = splitedLogLine[0];
           String time = splitedLogLine[1];
           String dataTime = String.format("%s/%s %s", data, CURRENT_YEAR, time);
           DateTimeFormatter formatter = DateTimeFormatter.ofPattern(LOG_TIME_PATTERN, Locale.ENGLISH);
           LocalDateTime dateTime = LocalDateTime.parse(dataTime, formatter);
           String thread = splitedLogLine[2];
           String user = splitedLogLine[3];

           LogType logType;
            if (splitedLogLine[4].equalsIgnoreCase("SQL")) {
                logType = LogType.getLogTypeByName(String.format("%s %s", splitedLogLine[4], splitedLogLine[5]));
            } else {
                logType = LogType.getLogTypeByName(splitedLogLine[4]);
            }

            Log log = new Log();
            log.setDateTime(dateTime);
            log.setThread(thread);
            log.setUser(user);
            log.setLogType(logType);

            listOfLogs.add(log);
       });
        return listOfLogs;
    }

}
