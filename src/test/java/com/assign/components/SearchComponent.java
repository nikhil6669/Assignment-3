package com.assign.components;

import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class SearchComponent extends QAFWebComponent
{
	public SearchComponent(String locator) 
	{
		super(locator);
	}
	
	@FindBy(locator="searchName")
	private QAFWebElement searchName;
	
	@FindBy(locator="searchPrice")
	private QAFWebElement searchPrice;
	
	
	public QAFWebElement getSearchProductName()
	{
		return searchName;
	}
	
	public QAFWebElement getSearchProductPrice() 
	{
		return searchPrice;
	}
}
