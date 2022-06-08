import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    private static Logger instance = null;

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

    private int numberMsg;
    private Logger() {
    }
    public static Logger getInstance() {
        if (instance == null)
            instance = new Logger();
        return instance;
    }

    void log(String msg) {
        numberMsg++;
        System.out.println("[" + LocalDateTime.now().format(formatter) + " " + numberMsg + "] " + msg);
    }

}
