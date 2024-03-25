package Listeners;

import AllureReport.AllureReportHelper;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.IOException;

public class TestNGListener implements org.testng.IExecutionListener , ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        AllureReportHelper.cleanAllureReport();
        Reporter.log("Method Name is :"+result.getName());
        System.out.println("Test Starting");
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
