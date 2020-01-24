package rogeriogentil.managed.webapp.mbean;

import org.apache.log4j.Logger;

import javax.management.*;
import java.lang.management.ManagementFactory;

public class MBeansUtils {

    private static Logger logger = Logger.getLogger(MBeansUtils.class);

    private static final String HELLO_MBEAN_NAME = "rogeriogentil.managed.webapp.mbean:type=Hello";
    private static final String BYE_MBEAN_NAME = "managedWebappMB:type=Generic";
    private static MBeanServer mBeanServer;

    public static MBeanServer getPlatformMBeanServer() {
        return ManagementFactory.getPlatformMBeanServer();
    }

    public static void register() {
        mBeanServer = getPlatformMBeanServer();

        try {
            ObjectName helloObjectName = new ObjectName(HELLO_MBEAN_NAME);
            Hello helloMBean = new Hello();
            mBeanServer.registerMBean(helloMBean, helloObjectName);

            ObjectName byeObjectName = new ObjectName(BYE_MBEAN_NAME);
            Generic byeMBean = new Generic();
            mBeanServer.registerMBean(byeMBean, byeObjectName);
        } catch (MalformedObjectNameException | InstanceAlreadyExistsException | MBeanRegistrationException | NotCompliantMBeanException e) {
            logger.error("Error to register MBeans", e);
        }
    }

    public static void unregister() {
        mBeanServer = getPlatformMBeanServer();

        try {
            ObjectName helloObjectName = new ObjectName(HELLO_MBEAN_NAME);
            mBeanServer.unregisterMBean(helloObjectName);

            ObjectName byeObjectName = new ObjectName(BYE_MBEAN_NAME);
            mBeanServer.unregisterMBean(byeObjectName);
        } catch (MalformedObjectNameException | InstanceNotFoundException | MBeanRegistrationException e) {
            logger.error("Error to unregister MBeans", e);
        }
    }
}
