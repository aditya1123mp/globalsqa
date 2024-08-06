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

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl('https://www.globalsqa.com/angularjs-protractor-practice-site/#google_vignette')

WebUI.waitForElementPresent(findTestObject('Object Repository/registration_login/registration_login_button'), 10)

// Wait for the page to load completely
WebUI.delay(3 // Adjust the delay as needed
    )

// JavaScript code to hide the ad
String jsHideAd = '\n    // Identify the ad element by its class, id, or any other attribute\n    var adElements = document.querySelectorAll(\'[class*="ad"], [id*="ad"], [data-ad]\');\n\n    // Iterate over the ad elements and hide them\n    adElements.forEach(function(ad) {\n        ad.style.display = \'none\';\n    });\n\n    return adElements.length; // Return the number of ads hidden\n'

// Execute the JavaScript to hide the ad
int adsHidden = WebUI.executeJavaScript(jsHideAd, null)

println('Number of ads hidden: ' + adsHidden)

// Wait briefly to ensure the ad is hidden
WebUI.delay(2)

// JavaScript code to click the button
String jsClickButton = '\n    var button = document.evaluate("//a[contains(text(), \'Banking\')]", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;\n    if (button) {\n        button.click();\n        return true;\n    } else {\n        return false;\n    }\n'

// Execute the JavaScript to click the button
boolean buttonClicked = WebUI.executeJavaScript(jsClickButton, null)

if (buttonClicked) {
    println('Button clicked successfully')
} else {
    println('Button not found or not clicked')
}

WebUI.callTestCase(findTestCase('adding_new_customer'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('open_account'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('customers'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('customer_login'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('deposit'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('withdrawl'), [:], FailureHandling.STOP_ON_FAILURE)

