import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

for (def row = 1; row <= findTestData('New Test Data for Testcase').getRowNumbers(); row++) {


	Login(findTestData('New Test Data for Testcase').getValue('UserName', row),  findTestData('New Test Data for Testcase').getValue('Password', row))

    WebUI.click(findTestObject('Page_Execute Automation/input_Login'))

    WebUI.selectOptionByValue(findTestObject('Page_Execute Automation (1)/select_TitleId'), '1', true)

    CustomKeywords.'com.ea.utilities.CommonUtilities.CheckDropDownListElementExist'(findTestObject('Page_Execute Automation (1)/select_TitleId'), 
        'Ms.')

    WebUI.setText(findTestObject('Page_Execute Automation (1)/input_Initial'), findTestData('New Test Data for Testcase').getValue(
            'Initial', row))

    WebUI.setText(findTestObject('Page_Execute Automation (1)/input_FirstName'), findTestData('New Test Data for Testcase').getValue(
            'FirstName', row))

    WebUI.setText(findTestObject('Page_Execute Automation (1)/input_MiddleName'), findTestData('New Test Data for Testcase').getValue(
            'LastName', row))

    WebUI.click(findTestObject('Page_Execute Automation (1)/input_Hindi'))

    WebUI.click(findTestObject('Page_Execute Automation (1)/input_Save'))

    WebUI.click(findTestObject('Page_Execute Automation (1)/a_HtmlPopup'))

    //To switch to an popup window
    WebUI.switchToWindowIndex(1)

    WebUI.setText(findTestObject('Page_Popup Window/input_Initial'), 'Initial')

    WebUI.setText(findTestObject('Page_Popup Window/input_FirstName'), 'FirstName')

    WebUI.setText(findTestObject('Page_Popup Window/input_MiddleName'), 'MiddleName')

    WebUI.setText(findTestObject('Page_Popup Window/input_LastName'), 'LastName')

    WebUI.click(findTestObject('Page_Popup Window/input_Female'))

    //To switch to an original window
    WebUI.switchToWindowIndex(0)

    WebUI.click(findTestObject('Page_Execute Automation (1)/input_generate'))

}


def Login(def userName, def password){
	
	// Way 1
	//WebUI.setText(findTestObject('Page_Execute Automation/input_UserName',[("xpath"): "id('userName')/p[1]/input[1]"]),userName)

	//Way 2
//	myTestObject = new TestObject("customObject");
//	myTestObject.addProperty("xpath", ConditionType.EQUALS, "id('userName')/p[1]/input[1]");
//	WebUI.setText(myTestObject, "CustomUserName");
	
	//Way 3
	myTestObject = new TestObject("customObject");
	
	List<TestObjectProperty> properties = new ArrayList<TestObjectProperty>();
	properties.add(new TestObjectProperty("xpath", ConditionType.EQUALS, "id('userName')/p[1]/input[1]"));
	properties.add(new TestObjectProperty("name", ConditionType.EQUALS, "UserName"));
	
	//Set the object
	myTestObject.setProperties(properties);
	WebUI.setText(myTestObject, "FromPropertiesObject");
	
	//Get property of an UI Object
	activeProperties = myTestObject.getProperties();
	for (prop in activeProperties) {
		prop.name;
	}

	WebUI.setText(findTestObject('Page_Execute Automation/input_Password'),password)
}

