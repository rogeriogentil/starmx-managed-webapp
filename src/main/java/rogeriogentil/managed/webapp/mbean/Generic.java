package rogeriogentil.managed.webapp.mbean;

import org.apache.log4j.Logger;
import rogeriogentil.managed.webapp.log.LogUtil;

import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;

public class Generic extends NotificationBroadcasterSupport implements GenericMBean {

    private Logger logger = Logger.getLogger(Generic.class);

    private boolean notify = true;
    private long sequence = 0;

    @Override
    public void monitor() {
        if (notify) {
            Notification notification = new Notification("monitor.event", this, ++sequence);
            sendNotification(notification);
        }
    }

    @Override
    public void executor() {
        final String message = "Executing 'executor()' method after receive notification.";
        final String separator = LogUtil.separatorLogLineProduces(message);

        logger.info(separator);
        logger.info(message);
        logger.info(separator);
    }
}