package rogeriogentil.managed.webapp.mbean;

import org.apache.log4j.Logger;
import rogeriogentil.managed.webapp.log.LogUtil;

public class Hello implements HelloMBean {

    private Logger logger = Logger.getLogger(Hello.class);

    private boolean talked = false;

    @Override
    public String isTalk() {
        return Boolean.toString(talked);
    }

    @Override
    public void say() {
        this.talked = true;

        final String message = "Hello! The Autonomous Manager invoke this...";

        logger.info(LogUtil.separatorLogLineProduces(message));
        logger.info(message);
        logger.info(LogUtil.separatorLogLineProduces(message));
    }

    @Override
    public void restart() {
        final String message = "Restarting 'talked' attribute... OBS: The Autonomous Manager invoke this too!";
        final String separator = LogUtil.separatorLogLineProduces(message);

        logger.info(separator);
        logger.info(message);
        logger.info(separator);

        this.talked = false;
    }
}