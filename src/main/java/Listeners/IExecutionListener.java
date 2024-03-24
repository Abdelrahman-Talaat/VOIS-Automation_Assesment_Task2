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
        try {
      Runtime.getRuntime().exec("generateAllureReport.bat");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        long endTime=System.currentTimeMillis();
        System.out.println("inform that all the suit have finished execution at :"+endTime);

    }
}
