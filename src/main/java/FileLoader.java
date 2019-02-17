import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileLoader {

    public List<String> loadLog() {
        List<String> logList = new ArrayList();

        try {
            FileInputStream log = new FileInputStream("C:\\Users\\tbana\\Documents\\LogReader\\src\\main\\java\\abc.log");
            BufferedReader br = new BufferedReader(new InputStreamReader(log));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                logList.add(strLine);
            }
            log.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        System.out.println(logList);
        return logList;
    }
}