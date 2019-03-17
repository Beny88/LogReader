import log.Log;
import log.LogFactory;
import log.LogType;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class LogListCheck {

    private static final String CURRENT_YEAR = "2019";
    private static final String LOG_TIME_PATTERN = "dd/MM/yyyy HH:mm:ss";

    private static LogListCheck logListCheck;

    private LogListCheck(){}
    public static LogListCheck getInstance(){
        if (logListCheck==null){
            logListCheck = new LogListCheck();
        }
            return logListCheck;
    }

    public List<Log> logSplit(final List<String> lineList) {
        List<Log> listOfLogs = new ArrayList<>();

        lineList.forEach((String logLine) -> {
            listOfLogs.add(LogFactory.getLog(logLine));
        });

        return listOfLogs;
    }

}
