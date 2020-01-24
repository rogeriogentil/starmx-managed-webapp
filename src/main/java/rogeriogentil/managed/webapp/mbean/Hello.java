package rogeriogentil.managed.webapp.mbean;

import org.apache.log4j.Logger;

public class Hello implements HelloMBean {

    private Logger logger = Logger.getLogger(Hello.class);
    private boolean talked = false;
    private StringBuilder logLine;

    @Override
    public String isTalk() {
        return Boolean.toString(talked);
    }

    @Override
    public void say() {
        this.talked = true;

        final String message = "Hello! The Autonomous Manager invoke this...";
        logLineProduces(message);

        logger.info(logLine.toString());
        logger.info(message);
        logger.info(logLine.toString());
    }

    @Override
    public void restart() {
        final String message = "Restarting 'talked' attribute... OBS: The Autonomous Manager invoke this too!";
        logLineProduces(message);

        logger.info(logLine.toString());
        logger.info(message);
        logger.info(logLine.toString());

        this.talked = false;
    }

    private void logLineProduces(final String message) {
        logLine = new StringBuilder(message.length());
        for (int i = 0; i < message.length(); i++) {
            logLine.append("-");
        }
    }
}