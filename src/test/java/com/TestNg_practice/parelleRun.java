package com.TestNg_practice;

import org.testng.annotations.Test;

public class parelleRun {
   
   @Test
  public void testMethod1(){
    System.out.println("TestMethod1 from parelleRun>>"+Thread.currentThread().getId());

  }
  @Test
public void testMethod2(){
    System.out.println("TestMethod2 from parelleRun>>"+Thread.currentThread().getId());

  }
  @Test
  public void testMethod3(){
    System.out.println("TestMethod3 from parelleRun>>"+Thread.currentThread().getId());

  }
  @Test
  public void testMethod4(){
    System.out.println("TestMethod4 from parelleRun>>"+Thread.currentThread().getId());

  }

}
