package com.assign.pages;
import java.util.HashMap;

import org.testng.Assert;

import com.assign.beans.SearchBeans;
import com.assign.utilities.commomUtil;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class ResultTestPage extends WebDriverBaseTestPage<WebDriverTestPage> 
{
		
	@FindBy(locator = "txt.result.name")
	private QAFWebElement txtResultName;
	@FindBy(locator = "txt.result.rate")
	private QAFWebElement txtResultRate;
	@FindBy(locator = "loader")
	private QAFWebElement loader;

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public QAFWebElement getResultName()
	{
		return txtResultName;
	}
	
	public QAFWebElement getPrice()
	{
		return txtResultRate;
	}
	
	
	public void waitToDisapperLoader() 
	{
		loader.waitForDisabled();
		/*WebDriverWait wait = new WebDriverWait(new WebDriverTestBase().getDriver(), 30);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));*/
	}
	
	public void verifyDetails() 
	{
		try
		{
			HashMap<String, SearchBeans> product = commomUtil.getProductItem();
			for (String key : product.keySet()) 
			{
				SearchBeans sbInfo = product.get(key);
				/*System.out.println("NAME>>> "+getResultName().getText());
				System.out.println("SB NAME >>>> "+ sbInfo.getResultName());*/
				String name = getResultName().getText();
				String sbName = sbInfo.getResultName();
				/*System.out.println("Price>>> "+getPrice().getText());
				System.out.println("SB Price >>>> "+ sbInfo.getAmount());*/
				String price = getPrice().getText();
				String sbPrice = sbInfo.getAmount();
				Assert.assertEquals(name, sbName, "Pass");
				Assert.assertEquals(price,sbPrice, "Pass");
				
				/*Validator.verifyThat(getResultName().getText().trim(), Matchers.equalToIgnoringCase((sbInfo.getResultName())));
				Validator.verifyThat(getPrice().getText().trim(), Matchers.equalToIgnoringCase((sbInfo.getAmount())));*/
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}
