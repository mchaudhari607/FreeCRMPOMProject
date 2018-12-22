package com.crm.qa.util;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {

	 public static long Page_Load_Timeout = 50;
	 public static long Implicit_Wait= 10;
	 
	 public void switchToFrame() {
		 driver.switchTo().frame("mainpanel");
	 }
}
