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

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/banking/bank_manager_login'))

WebUI.click(findTestObject('Object Repository/banking/add_customer_button'))

WebUI.click(findTestObject('Object Repository/banking/first_name'))

WebUI.setText(findTestObject('Object Repository/banking/first_name'), 'First_name_' + RandomStringUtils.randomAlphabetic(6))

WebUI.click(findTestObject('Object Repository/banking/Last_name'))

WebUI.setText(findTestObject('Object Repository/banking/Last_name'), 'Last_name_' + RandomStringUtils.randomAlphabetic(6))

WebUI.click(findTestObject('Object Repository/banking/pincode'))

WebUI.setText(findTestObject('Object Repository/banking/pincode'), RandomStringUtils.randomNumeric(6))

GlobalVariable.FirstName = WebUI.getAttribute(findTestObject('Object Repository/banking/first_name'),'value')

System.out.println(GlobalVariable.FirstName)


GlobalVariable.LastName = WebUI.getAttribute(findTestObject('Object Repository/banking/Last_name'),'value')

System.out.println(GlobalVariable.LastName)

WebUI.click(findTestObject('Object Repository/banking/add_button'))
