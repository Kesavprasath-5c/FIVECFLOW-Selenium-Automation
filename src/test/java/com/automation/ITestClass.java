package com.automation;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import org.testng.Assert;



@Listeners  ({ItestListenersClass.class})
public class ITestClass {

    @Test
    public void TestMethod1(){
    System.out.println("am insode the test Method1");
    System.out.println("mic check 123");
    }

    @Test
    public void TestMethod2(){
         System.out.println("am insode the test Method2");
         Assert.assertTrue(false);
    }

    @Test(timeOut = 1000)
     public void TestMethod3() throws Exception{
        Thread.sleep(2000);
         System.out.println("am insode the test Method3");
    }

    @Test(dependsOnMethods = "TestMethod3")
     public void TestMethod4(){
         System.out.println("am insode the test Method4");
    }

    }



