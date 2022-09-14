package testScriptPackage;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import baseTestPackage.BaseTest_TestNG;
import reusableLibraryPackage.ReusableComponents;

public class WicketKeeperCountTest extends BaseTest_TestNG{
	ReusableComponents reusableComponents=new ReusableComponents();
	@Test()
	public void wicketKeeperCountTest() throws Exception {
		test = report.startTest("Wicket Keeper Test");
		test.log(LogStatus.INFO, "Load the following JSON File "+globalProp.getProperty("JSONFilePath"));
		JSONObject jsonObject = reusableComponents.loadJSONFile(file.getCanonicalPath()+globalProp.getProperty("JSONFilePath"));
		test.log(LogStatus.INFO, "Validation for Wicket Keeper count starts");
		reusableComponents.validateWKCountTest(jsonObject,test,"Wicket-keeper");
		test.log(LogStatus.INFO, "Validation for Wicket Keeper count ends");
	}
}
