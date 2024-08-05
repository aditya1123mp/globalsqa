import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import org.apache.commons.lang.RandomStringUtils as RandomStringUtils
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl('https://www.globalsqa.com/angularjs-protractor-practice-site/#google_vignette')

WebUI.waitForElementPresent(findTestObject('Object Repository/registration_login/registration_login_button'), 10)


// Wait for the page to load completely
WebUI.delay(3) // Adjust the delay as needed

// JavaScript code to hide the ad
String jsHideAd = '''
    // Identify the ad element by its class, id, or any other attribute
    var adElements = document.querySelectorAll('[class*="ad"], [id*="ad"], [data-ad]');

    // Iterate over the ad elements and hide them
    adElements.forEach(function(ad) {
        ad.style.display = 'none';
    });

    return adElements.length; // Return the number of ads hidden
'''

// Execute the JavaScript to hide the ad
int adsHidden = WebUI.executeJavaScript(jsHideAd, null)
println "Number of ads hidden: " + adsHidden

// Wait briefly to ensure the ad is hidden
WebUI.delay(2)

// JavaScript code to click the button
String jsClickButton = '''
    var button = document.evaluate("//a[contains(text(), 'RegistrationLogin')]", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;
    if (button) {
        button.click();
        return true;
    } else {
        return false;
    }
'''

// Execute the JavaScript to click the button
boolean buttonClicked = WebUI.executeJavaScript(jsClickButton, null)
if (buttonClicked) {
    println "Button clicked successfully"
} else {
    println "Button not found or not clicked"
}


//WebUI.click(findTestObject('Object Repository/registration_login/registration_login_button'))

WebUI.delay(3)

WebUI.click(findTestObject('Object Repository/registration_login/register_new_user'))

WebUI.click(findTestObject('Object Repository/registration_login/first_name_text_box'))

WebUI.setText(findTestObject('Object Repository/registration_login/first_name_text_box'), 'First_name_' + RandomStringUtils.randomAlphabetic(
        6))

WebUI.click(findTestObject('Object Repository/registration_login/last_name_text_box'))

WebUI.setText(findTestObject('Object Repository/registration_login/last_name_text_box'), 'Last_name_' + RandomStringUtils.randomAlphabetic(
        6))

WebUI.click(findTestObject('Object Repository/registration_login/username_text_box'))

WebUI.setText(findTestObject('Object Repository/registration_login/username_text_box'), ('Fiboo_' + RandomStringUtils.randomNumeric(
        6)) + '@@')

Password = WebUI.getAttribute(findTestObject('Object Repository/registration_login/username_text_box'), 'value')

System.out.println(Password)

WebUI.clearText(findTestObject('Object Repository/registration_login/username_text_box'))

WebUI.click(findTestObject('Object Repository/registration_login/username_text_box'))

WebUI.setText(findTestObject('Object Repository/registration_login/username_text_box'), (('user_name' + RandomStringUtils.randomNumeric(
        6)) + '@gmail') + '.com')

username = WebUI.getAttribute(findTestObject('Object Repository/registration_login/username_text_box'), 'value')

System.out.println(username)

WebUI.click(findTestObject('Object Repository/registration_login/password_text_box'))

WebUI.setText(findTestObject('Object Repository/registration_login/password_text_box'), Password)

WebUI.click(findTestObject('Object Repository/registration_login/register_button'))

sucessfull_message = WebUI.getText(findTestObject('Object Repository/registration_login/registration_successfull_message'))

System.out.println(sucessfull_message)

if (sucessfull_message == 'Registration successful') {
    KeywordUtil.markPassed('first name is same')
} else {
    KeywordUtil.markFailed('first name is not same')
}


WebUI.click(findTestObject('Object Repository/registration_login/username_for_login'))

WebUI.setText(findTestObject('Object Repository/registration_login/username_for_login'), username)


WebUI.click(findTestObject('Object Repository/registration_login/password_for_login'))

WebUI.setText(findTestObject('Object Repository/registration_login/password_for_login'), Password)

WebUI.click(findTestObject('Object Repository/registration_login/login_button_for_login'))

WebUI.click(findTestObject('Object Repository/registration_login/delete_option'))

WebUI.click(findTestObject('Object Repository/registration_login/logout_button'))

WebUI.click(findTestObject('Object Repository/registration_login/username_for_login'))

WebUI.setText(findTestObject('Object Repository/registration_login/username_for_login'), username)


WebUI.click(findTestObject('Object Repository/registration_login/password_for_login'))

WebUI.setText(findTestObject('Object Repository/registration_login/password_for_login'), Password)

WebUI.click(findTestObject('Object Repository/registration_login/login_button_for_login'))


message = WebUI.getText(findTestObject('Object Repository/registration_login/Username_or_password_is_incorrect'))

System.out.println(message)

if (message == 'Username or password is incorrect') {
	KeywordUtil.markPassed('first name is same')
} else {
	KeywordUtil.markFailed('first name is not same')
}

