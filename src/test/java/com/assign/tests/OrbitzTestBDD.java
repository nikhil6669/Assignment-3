package com.assign.tests;

import org.junit.Test;

import com.assign.pages.HomePage;
import com.assign.pages.ResultTestPage;
import com.assign.pages.SearchPage;
import com.assign.utilities.commomUtil;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;

/**
 * @author Nikhil.Bhalerao
 */
public class OrbitzTestBDD {

	HomePage home = new HomePage();
	SearchPage search = new SearchPage();
/*
	@QAFTestStep(description = "user opens Orbitz sites")
	public void userOpensOrbitzSite() {
		home.launchPage(null);
		throw new NotYetImplementedException();
	}
	*/
	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	
	/*@QAFTestStep(description = "user opens Orbitz sites")
	@Test
	public void userOpensOrbitzSites() {
		home.launchPage(null);
		
	}*/

	@QAFTestStep(description = "user select origin and destination")
	public void userSelectAnd() {
		home.enterOrigin();
		home.enterDestination();
	}

	@QAFTestStep(description = "user select date for Departing and Returning")
	public void userSelectDateForDepartingAndReturning() {
		home.selectDeptDate();
		home.selectReturningDate();
	}

	@QAFTestStep(description = "user select number of childrens and their age")
	public void userSelectNumberOfChildrensAndTheirAge() {
		home.selectDropdown(new QAFExtendedWebElement("dropdown.children.num.homepage"),
				"1");
		home.selectDropdown(new QAFExtendedWebElement("dropdown.children.age.homepage"),
				"3");
	}

	@QAFTestStep(description = "user clicks on search button")
	public void userClicksOnSearchButton() {
		home.clickSeach();
	}

	@QAFTestStep(description = "user verify search result")
	public void userVerifySearchResult() {
		/*
		 * int i = 3;
		 * search.findName(i);
		 * search.findPrice(i);
		 */
		search.clickOnSearch();
		commomUtil.switchWindow();

		ResultTestPage result = new ResultTestPage();

		result.verifyDetails();
	}

	

}
