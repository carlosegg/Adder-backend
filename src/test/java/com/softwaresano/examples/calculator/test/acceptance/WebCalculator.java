package com.softwaresano.examples.calculator.test.acceptance;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.concordion.internal.ConcordionBuilder;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.softwaresano.examples.calculator.test.utils.WebDriverUtil;


public class WebCalculator {
	 /** Class logger */
    protected Log logger = LogFactory.getLog(this.getClass());
    
    /** WebDriver instance */
    protected static WebDriver driver = null;

    @BeforeClass
    public  static void setUpOnce() throws Throwable {
    	 // Initializing WebDriver instance
        driver = WebDriverUtil.getWebDriver();
    }
    
    @AfterClass
    public static void tearDownOnce() {
    	 driver.quit();
    }

    @Test
    public void test() throws IOException {
        new ConcordionBuilder().build().process(this).assertIsSatisfied();
    }
    public String add(String firstOperand, String secondOperand, String addResult){
	String urlServer=System.getProperty("urlServer");
        if (( urlServer == null) || ( urlServer.equals(""))){
           driver.get("http://localhost:8080/web-calculator/index.html");
	}  else {
	   driver.get(urlServer+"/index.html");
        }
    	driver.findElement(By.id("firstOperand")).sendKeys(firstOperand);
    	driver.findElement(By.id("secondOperand")).sendKeys(secondOperand);
    	driver.findElement(By.name("action")).click();
    	System.out.println(driver.findElement(By.id("result")).getText());
    	if (driver.findElement(By.id("result")).getText().equals(addResult)){
            return "OK";
        } else {
            return "ERROR";
        }

    }
}
