package rogeriogentil.manager.process;

import org.starmx.core.AnchorObject;
import org.starmx.core.ExecutionContext;
import org.starmx.core.Process;
import org.starmx.core.ProcessConfig;
import rogeriogentil.managed.webapp.mbean.HelloMBean;

public class HelloProcess implements Process {

    @AnchorObject
    private HelloMBean helloMBean;

    @Override
    public void init(ProcessConfig processConfig) {
        // Alternativa a anotação @AnchorObject
//        try {
//            this.helloMBean = (HelloMBean) processConfig.getAnchorObject("rogeriogentil.managed.webapp.mbean.HelloMBean");
//        } catch (LookupException e) {
//            e.printStackTrace();
//        }

        System.out.println("Process " + processConfig.getProcessInfo().getId() + " was initialized.");
    }

    @Override
    public void execute(ExecutionContext executionContext) {
        if (helloMBean.isTalk().equals(Boolean.FALSE.toString())) {
            helloMBean.say();
        } else {
            helloMBean.restart();
        }
    }

    @Override
    public void destroy() {
    }
}
