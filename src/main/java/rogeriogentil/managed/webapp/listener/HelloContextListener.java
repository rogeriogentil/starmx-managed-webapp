package rogeriogentil.managed.webapp.listener;

import org.apache.log4j.Logger;
import org.starmx.StarMXException;
import org.starmx.StarMXFramework;
import rogeriogentil.managed.webapp.mbean.MBeansUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class HelloContextListener implements ServletContextListener {

    private Logger logger = Logger.getLogger(HelloContextListener.class);
    private StarMXFramework starMX;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try {
            MBeansUtils.register();
            starMX = StarMXFramework.createInstance();
        } catch (StarMXException e) {
            logger.error(e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        MBeansUtils.unregister();
        if (starMX != null) {
            try {
                starMX.shutdown();
            } catch (StarMXException e) {
                logger.error(e);
            }
        }

    }
}
