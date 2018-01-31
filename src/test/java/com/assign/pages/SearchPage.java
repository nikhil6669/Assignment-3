package com.assign.pages;

import java.util.HashMap;
import java.util.List;

import org.mozilla.javascript.JavaScriptException;
import org.openqa.selenium.JavascriptExecutor;

import com.assign.beans.SearchBeans;
import com.assign.components.SearchComponent;
import com.assign.utilities.commomUtil;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

import joptsimple.ArgumentAcceptingOptionSpec;

public class SearchPage extends WebDriverBaseTestPage<WebDriverTestPage> 
{
	
	@FindBy(locator="searchResult")
	private List<SearchComponent> searchResult;
	
	@FindBy(locator="link.search.click")
	private QAFExtendedWebElement searchResultClick;
	
	public List<SearchComponent> getSearchResult()
	{
		return searchResult;
	}
	
	public void findName(int i) 
	{		
		getSearchResult().get(i).getSearchProductName().waitForPresent();
		System.out.println("#################"+getSearchResult().get(0).getSearchProductName().getText());
		String name = getSearchResult().get(0).getSearchProductName().getText();
	}

	public void findPrice(int i)
	{
		getSearchResult().get(i).getSearchProductPrice().waitForPresent();
		System.out.println("$$$$$$$$$$$$$$$$$$"+getSearchResult().get(0).getSearchProductPrice().getText());
		String amount = getSearchResult().get(0).getSearchProductPrice().getText();
	}
	
	public void clickOnSearch()
	{
		HashMap<String, SearchBeans> product = new HashMap<String, SearchBeans>();
		String name = getSearchResult().get(1).getSearchProductName().getText();
		String amount = getSearchResult().get(1).getSearchProductPrice().getText();
		System.out.println("NAME>>>> "+name+"AMT>>>> "+amount);
		//SearchBeans sb  = new SearchBeans(name, amount);
		SearchBeans sb  = new SearchBeans();
		sb.setResultName(name);
		sb.setAmount(amount);
			
		product.put(name, sb);
		
		getSearchResult().get(1).click();

		commomUtil.setProductItem(product);
		
	}

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub
	}
}
	
