package com.automation;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ItestListenersClass extends BaseClass implements ITestListener {

    

    @Override
    public void onTestFailure(ITestResult result) {
        ScreenShot(result.getMethod().getMethodName()+ ".png");
    }
 
   

    
    
}
