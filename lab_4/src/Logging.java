import java.io.*;
import java.time.*;
public class Logging {


    boolean isActive;
    String fname;
    FileOutputStream fos;
    ObjectOutputStream oos;

    Logging() {
        isActive = false;
    }
    Logging(boolean active, String file) {
        isActive = active;
        fname = file;
    }

    void write (String str)
    {
        if (!isActive)
            return;
        LocalTime time = LocalTime.now();
        LocalDate day = LocalDate.now();
        String s = String.format("%02d:%02d:%4d ", day.getDayOfMonth(), day.getMonthValue(), day.getYear());
        s += String.format("%02d:%02d:%02d ", time.getHour(), time.getMinute(), time.getSecond());
        try (FileWriter fw = new FileWriter(fname, true)) {
            if (isActive)
                fw.write(str + "\r\n");
        } catch (IOException ехс) {
            System.out.println("File error " + ехс);
        }
    }
}
