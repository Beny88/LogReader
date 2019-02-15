import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class FileLoader {

    public void loadLog() {
        try {
            FileInputStream log = new FileInputStream("C:\\Users\\tbana\\Documents\\LogReader\\src\\main\\java\\abc.log");
            BufferedReader br = new BufferedReader(new InputStreamReader(log));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                System.out.println(strLine);
            }
            log.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}