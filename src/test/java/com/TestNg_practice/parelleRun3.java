package com.TestNg_practice;

import org.testng.annotations.Test;

public class parelleRun3 {
    
      @Test
  public void testMethod9(){
    System.out.println("TestMethod9 >> parelleRun3>> "+Thread.currentThread().getId());

  }
  @Test
public void testMethod10(){
    System.out.println("TestMethod10 >> parelleRun3>> "+Thread.currentThread().getId());

  }
  @Test
  public void testMethod11(){
    System.out.println("TestMethod11 >> parelleRun3>> "+Thread.currentThread().getId());

  }
  @Test
  public void testMethod12(){
    System.out.println("TestMethod12 >> parelleRun3>> "+Thread.currentThread().getId());

  }
}
