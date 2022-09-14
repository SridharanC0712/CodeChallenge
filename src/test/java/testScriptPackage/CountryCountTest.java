package testScriptPackage;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import baseTestPackage.BaseTest_TestNG;
import reusableLibraryPackage.ReusableComponents;

public class CountryCountTest extends BaseTest_TestNG{
	ReusableComponents reusableComponents=new ReusableComponents();
	@Test()
	public void countryCountTest() throws Exception {
		test = report.startTest("Country count Test");
		test.log(LogStatus.INFO, "Load the following JSON File "+globalProp.getProperty("JSONFilePath"));
		JSONObject jsonObject = reusableComponents.loadJSONFile(file.getCanonicalPath()+globalProp.getProperty("JSONFilePath"));
		test.log(LogStatus.INFO, "Validation for International player count starts");
		reusableComponents.validateCountryCountTest(jsonObject,test,"India");
		test.log(LogStatus.INFO, "Validation for International player count ends");
	}

}
