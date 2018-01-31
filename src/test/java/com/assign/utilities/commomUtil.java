package com.assign.utilities;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.assign.beans.SearchBeans;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class commomUtil extends QAFExtendedWebDriver
{
	
	public static QAFExtendedWebDriver getDriver()
	{
		return new WebDriverTestBase().getDriver();
	}
	public static void checkPageIsReady() 
	{
		JavascriptExecutor js = (JavascriptExecutor) new WebDriverTestCase().getDriver();
		if (js.executeScript("return document.readyState").toString().equals("complete")) {
			System.out.println("Page Is loaded.");
		}
	}
	
	public static void waitForInvisable(QAFWebElement locater)
	{
		WebDriverWait wait = new WebDriverWait(new WebDriverTestBase().getDriver(),	30);
		wait.until(ExpectedConditions.invisibilityOfElementLocated((By) locater));
	}
	
	public static void switchWindow()
	{
		String window =  new WebDriverTestBase().getDriver().getWindowHandle();
		for (String winHandle  : new WebDriverTestBase().getDriver().getWindowHandles()) 
		{
			new WebDriverTestBase().getDriver().switchTo().window(winHandle);
		}
	}
	
	public static void setProductItem(HashMap<String,SearchBeans> productList)
	{		
    	ConfigurationManager.getBundle().addProperty("search.info", productList);
	}
	
	@SuppressWarnings("unchecked")
	public static HashMap<String,SearchBeans> getProductItem()
	{
		HashMap<String,SearchBeans> productList;
		if(ConfigurationManager.getBundle().containsKey("search.info"))
		{
			productList = (HashMap<String, SearchBeans>) ConfigurationManager.getBundle().getProperty("search.info");
		}
		else
		{
			productList = new HashMap<String,SearchBeans>();
			ConfigurationManager.getBundle().addProperty("search.info", productList);
		}
		return productList;
	}
	
}
