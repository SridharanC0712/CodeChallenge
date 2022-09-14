package reusableLibraryPackage;

import java.io.FileReader;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReusableComponents {
	/**
	 * Method to load JSON file from given path
	 * @param strJSONFilePath
	 * @return JSONObject
	 * @throws Exception
	 **/
	public  JSONObject loadJSONFile(String strJSONFilePath) throws Exception{
		JSONParser parser = new JSONParser();
		 Object obj = parser.parse(new FileReader(strJSONFilePath));
         JSONObject jsonObject = (JSONObject)obj;
		return jsonObject;
	}
	/**
	 * Method to validate the count of players from a Country
	 * @param jsonObject
	 * @param test
	 * @param strCountryName
	 */
	public void validateCountryCountTest(JSONObject jsonObject,ExtentTest test,String strCountryName) {
		int count = iteratePlayerArrayForCountryCount(jsonObject,strCountryName);
         if(count==4){
        	 test.log(LogStatus.PASS, "There are 4 foreign players in the team" );
         }else{
        	 test.log(LogStatus.FAIL, "There are less than 4 foreign players in the team" );
         }
	}
	/**
	 * Method to validate the count of WicketKeeper
	 * @param jsonObject
	 * @param test
	 * @param strRoleValue
	 */
	public void validateWKCountTest(JSONObject jsonObject,ExtentTest test,String strRoleValue) {
		int count = iteratePlayerArrayForWKCount(jsonObject,strRoleValue);
         if(count>=1){
        	 test.log(LogStatus.PASS, "There are atleast one WK in the team" );
         }else{
        	 test.log(LogStatus.FAIL, "There are no WK in the team" );
         }
	}

	/**
	 * Method to iterate JSON Array get the count of players from a Country
	 * @param jsonObject
	 * @param strCountryName
	 * @return int
	 */
	public int iteratePlayerArrayForCountryCount(JSONObject jsonObject,String strCountryName) {
		JSONArray playerArray = (JSONArray)jsonObject.get("player");
         Iterator<?> iterator = playerArray.iterator();
         int count=0;String strCountry;
         while (iterator.hasNext()) {
           jsonObject=(JSONObject) iterator.next();
        	 strCountry=(String)jsonObject.get("country");
        	 if(!strCountry.equalsIgnoreCase(strCountryName)){
        		 count++; 
        	 }
         }
		return count;
	}
	/**
	 * Method to iterate JSON Array get the count of Wicket Keeper
	 * @param jsonObject
	 * @param strRoleValue
	 * @return int
	 */
	public int iteratePlayerArrayForWKCount(JSONObject jsonObject,String strRoleValue) {
		JSONArray playerArray = (JSONArray)jsonObject.get("player");
         Iterator<?> iterator = playerArray.iterator();
         int count=0;String strRole;
         while (iterator.hasNext()) {
           jsonObject=(JSONObject) iterator.next();
           strRole=(String)jsonObject.get("role");
        	 if(strRole.equalsIgnoreCase(strRoleValue)){
        		 count++; 
        	 }
         }
		return count;
	}
}
