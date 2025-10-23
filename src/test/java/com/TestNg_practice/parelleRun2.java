package com.TestNg_practice;

import org.testng.annotations.Test;

public class parelleRun2 {
   
   @Test
  public void testMethod5(){
    System.out.println("TestMethod5 >> parelleRun2>>"+Thread.currentThread().getId());

  }
  @Test
public void testMethod6(){
    System.out.println("TestMethod6 >> parelleRun2>>"+Thread.currentThread().getId());

  }
  @Test
  public void testMethod7(){
    System.out.println("TestMethod7 >> parelleRun2>>"+Thread.currentThread().getId());

  }
  @Test
  public void testMethod8(){
    System.out.println("TestMethod8 >> parelleRun2>>"+Thread.currentThread().getId());

  }

}
