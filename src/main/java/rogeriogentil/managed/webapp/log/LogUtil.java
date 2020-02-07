package rogeriogentil.managed.webapp.log;

public class LogUtil {

    public static String separatorLogLineProduces(final String message) {
        StringBuilder logLine = new StringBuilder(message.length());
        for (int i = 0; i < message.length(); i++) {
            logLine.append("-");
        }

        return logLine.toString();
    }
}
