package baseTestPackage;

import java.io.File;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseTest_TestNG {
	public static ExtentReports report;
	public static ExtentTest test;
	public static Properties globalProp;
	public static File file;

	@BeforeClass
	public void startTest() throws Exception {
		file = new File(".");
		globalProp = loadPropertyFile(file.getCanonicalPath() + "//GlobalProperties.properties");
		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_hh_mm_ss");
		String strDate = dateFormat.format(date);
		File reportFile = new File(file.getCanonicalPath() + "\\ExtentReport\\Report" + strDate + ".html");
		if (!reportFile.exists()) {
			reportFile.createNewFile();
		}
		report = new ExtentReports(file.getCanonicalPath() + "\\ExtentReport\\Report" + strDate + ".html", true);
	}
	@AfterClass
	public static void endTest() throws Exception {
		report.endTest(test);
		report.flush();
	}

	public static Properties loadPropertyFile(String strFilePath) throws Exception {
		FileReader reader = new FileReader(strFilePath);

		Properties prop = new Properties();
		prop.load(reader);
		return prop;
	}
}