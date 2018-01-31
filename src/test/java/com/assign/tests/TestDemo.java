package com.assign.tests;

import com.assign.pages.HomePage;
import com.assign.pages.SearchPage;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;

/**
 * @author Nikhil.Bhalerao
 */
public class TestDemo {
	HomePage home = new HomePage();
	SearchPage search = new SearchPage();

	@QAFTestStep(description = "user opens Orbitz site")
	public void userOpensOrbitzSite() {
		home.launchPage(null);
	}

	@QAFTestStep(description = "user select {origin} and {destination}")
	public void userSelectAnd(String origin, String destination) {
		home.enterOrigin(origin);
		home.enterDestination(destination);
	}

	@QAFTestStep(description = "user select date for {departing} and {returning}")
	public void userSelectDateForAnd(int departing, int returning) {
		home.selectDeptDate(String.valueOf(departing));
		home.selectReturningDate(String.valueOf(returning));
	}

	@QAFTestStep(description = "user select number of {childrens} and their {age}")
	public void userSelectNumberOfAndTheir(String childrens, String age) {
		home.selectDropdown(new QAFExtendedWebElement("dropdown.children.num.homepage"),
				childrens);
		home.selectDropdown(new QAFExtendedWebElement("dropdown.children.age.homepage"),
				age);
	}

	@QAFTestStep(description = "click button is clicked")
	public void clickButtonIsClicked() {
		home.clickSeach();
	}

	@QAFTestStep(description = "user verifys search result")
	public void userVerifysSearchResult() 
	{
		int i = 3;
		search.findName(i);
		search.findPrice(i);
	}

}
