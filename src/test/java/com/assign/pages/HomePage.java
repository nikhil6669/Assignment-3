package com.assign.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class HomePage extends WebDriverBaseTestPage<WebDriverTestPage> {
	@Override
	protected void openPage(PageLocator arg0, Object... arg1) {
		driver.get("/");
		driver.manage().window().maximize();
	}

	@FindBy(locator = "txtbox.origin.homepage")
	private QAFWebElement txtboxOrigin;

	@FindBy(locator = "input.origin.homepage")
	private QAFWebElement inputOrigin;

	@FindBy(locator = "txtbox.destination.homepage")
	private QAFWebElement txtboxDestination;

	@FindBy(locator = "input.destination.homepage")
	private QAFWebElement inputDestination;

	@FindBy(locator = "date.departing.homepage")
	private QAFWebElement dateDeparting;

	@FindBy(locator = "date.select.departing.homepage")
	private QAFWebElement selectDateDeparting;

	@FindBy(locator = "date.returning.homepage")
	private QAFWebElement dateReturning;

	@FindBy(locator = "date.select.returning.homepage")
	private QAFWebElement selectDateReturning;

	@FindBy(locator = "dropdown.children.num.homepage")
	private QAFWebElement numberOfChildrens;

	@FindBy(locator = "dropdown.children.age.homepage")
	private QAFWebElement childrenAge;

	@FindBy(locator = "dropdown.advance.homepage")
	private QAFWebElement advanceOption;

	@FindBy(locator = "button.search.homepage")
	private QAFWebElement serchButton;

	@FindBy(locator = "date.dym.departing.homepage")
	private QAFWebElement dateDymDeparture;

	@FindBy(locator = "date.dym.returning.homepage")
	private QAFWebElement dateDymReturning;

	public void enterOrigin() {
		txtboxOrigin.sendKeys(ConfigurationManager.getBundle().getString("origin"));
	}

	public void enterOrigin(String origin) {
		txtboxOrigin.sendKeys(origin);
	}

	public void enterDestination() {
		txtboxDestination
				.sendKeys(ConfigurationManager.getBundle().getString("destination"));
	}

	public void enterDestination(String destination) {
		txtboxDestination.sendKeys(destination);
	}

	public void selectDeptDate() {
		dateDeparting.click();
		selectDateDeparting.click();
	}

	public void selectReturningDate() {
		dateReturning.click();
		selectDateReturning.click();
	}

	public void selectDeptDate(String date) {
		dateDeparting.click();
		QAFExtendedWebElement DDD = new QAFExtendedWebElement(String.format(
				ConfigurationManager.getBundle().getString("date.dym.departing.homepage"),
				date));
		DDD.click();
	}

	public void selectReturningDate(String date) {
		dateReturning.click();
		QAFExtendedWebElement DRD = new QAFExtendedWebElement(String.format(
				ConfigurationManager.getBundle().getString("date.dym.returning.homepage"),
				date));
		DRD.click();
	}

	public void selectDropdown(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	public void selectDropdownDyn(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	public void clickSeach() {
		serchButton.click();
	}
}
