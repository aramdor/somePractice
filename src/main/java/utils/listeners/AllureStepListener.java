package utils.listeners;

import io.qameta.allure.listener.StepLifecycleListener;
import io.qameta.allure.model.StepResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ApplicationManager;
import utils.Attachments;

public class AllureStepListener implements StepLifecycleListener {

    private Logger getLogger() {
        return LoggerFactory.getLogger(AllureStepListener.class);
    }

    public void beforeStepStart(StepResult result) {
        getLogger().info("Step: '" + result.getName() + "' starts");
    }

    public void afterStepUpdate(StepResult result) {
        Attachments.getScreenshot(ApplicationManager.getDriverStatic(), result.getName());
    }

    public void afterStepStop(StepResult result) {

        getLogger().info("Step: '" + result.getName() + "' ends");
    }

    public void beforeStepStop(StepResult result) {

    }

    public void afterStepStart(StepResult result) {
    }

    public void beforeStepUpdate(StepResult result) {
    }


}
