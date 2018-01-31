package com.assign.tests;

import java.util.Map;

import org.testng.annotations.Test;

import com.assign.pages.HomePage;
import com.assign.pages.SearchPage;
import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;

public class OrbtizTestCSV 
{
	HomePage home = new HomePage();
	SearchPage search = new SearchPage();

		
	@QAFDataProvider(dataFile="resources/Input.csv")
	@Test
	public void userSelectAnd(Map<String, String> data) 
	{
		home.launchPage(null);
		home.enterOrigin(data.get("origin"));
		home.enterDestination(data.get("dest"));
	}
}
