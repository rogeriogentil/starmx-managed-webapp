package rogeriogentil.manager.process;

import org.starmx.core.AnchorObject;
import org.starmx.core.ExecutionContext;
import org.starmx.core.Process;
import org.starmx.core.ProcessConfig;
import rogeriogentil.managed.webapp.mbean.GenericMBean;

public class ExecutorProcess implements Process {

    @AnchorObject
    private GenericMBean genericMBean;

    @Override
    public void init(ProcessConfig processConfig) {
        System.out.println("Process " + processConfig.getProcessInfo().getId()  + " was initialized.");
    }

    @Override
    public void execute(ExecutionContext executionContext) {
        genericMBean.executor();
    }

    @Override
    public void destroy() {
    }
}
