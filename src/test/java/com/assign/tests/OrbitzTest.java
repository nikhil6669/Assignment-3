package com.assign.tests;

import org.testng.annotations.Test;

import com.assign.pages.HomePage;
import com.assign.pages.ResultTestPage;
import com.assign.pages.SearchPage;
import com.assign.utilities.commomUtil;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;

public class OrbitzTest extends WebDriverTestCase
{
	@Test
	public void sampleTestCase()
	{
		HomePage home = new HomePage();
		home.launchPage(null);
		home.enterOrigin();
		home.enterDestination();
		home.selectDeptDate();
		home.selectReturningDate();
		home.selectDropdown(new QAFExtendedWebElement("dropdown.children.num.homepage"),"1");
		home.selectDropdown(new QAFExtendedWebElement("dropdown.children.age.homepage"), "3");
		//home.selectDropdown(new QAFExtendedWebElement("dropdown.advance.homepage"), "f");
		home.clickSeach();
		
		SearchPage search = new SearchPage();
		//commomUtil.checkPageIsReady();
		/*int i = 3;
		search.findName(i);
		
		search.findPrice(i);*/
		search.clickOnSearch();
		commomUtil.switchWindow();
		
		ResultTestPage result = new ResultTestPage();
		/*result.getTxtResultName();
		result.getTxtResultRate();*/
		result.verifyDetails();

	}
}
