package Listeners;

import java.io.IOException;

public class IExecutionListener implements org.testng.IExecutionListener {
    @Override
    public void onExecutionStart() {
        System.out.println("Execution starting");
        long startTime=System.currentTimeMillis();
        System.out.println("inform that all the suit have started execution at :"+startTime);
    }

    @Override
    public void onExecutionFinish() {
        System.out.println("Test Finished");
        long finishTime=System.currentTimeMillis();
        System.out.println("inform that all the suit have finished execution at :"+finishTime);
    }
}
