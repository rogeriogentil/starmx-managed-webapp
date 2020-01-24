package rogeriogentil.managed.webapp.mbean;

import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;

public class Generic extends NotificationBroadcasterSupport implements GenericMBean {

    private boolean notificar = true;
    private long sequencia = 0;

    @Override
    public void monitor() {
        if (notificar) {
            Notification notification = new Notification("monitor.event", this, ++sequencia);
            sendNotification(notification);
        }
    }

    @Override
    public void executor() {
        System.out.println("Executando método JMX depois da notificação.");
    }
}