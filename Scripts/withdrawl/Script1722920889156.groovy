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

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/customer_login/withdrawl_button'))

WebUI.click(findTestObject('Object Repository/customer_login/amount_to_be_withdrawn'))

WebUI.setText(findTestObject('Object Repository/customer_login/amount_to_be_withdrawn'), '100')

WebUI.click(findTestObject('Object Repository/customer_login/withdraw_button'))

message = WebUI.getText(findTestObject('Object Repository/customer_login/trnaction_successfull'))

System.out.println(message)

if (message == 'Transaction successful') {
	KeywordUtil.markPassed('message is same')
} else {
	KeywordUtil.markFailed('message is not same')
}

WebUI.click(findTestObject('Object Repository/customer_login/transcation'))

credit_amount = WebUI.getText(findTestObject('Object Repository/customer_login/get_deposite_amount'))

System.out.println(credit_amount)

if (credit_amount == '1000') {
	KeywordUtil.markPassed('credit is same')
} else {
	KeywordUtil.markFailed('credit is not same')
}

debit_amount = WebUI.getText(findTestObject('Object Repository/customer_login/get_withdrawn_amount'))

System.out.println(debit_amount)

if (debit_amount == '100') {
	KeywordUtil.markPassed('debit is same')
} else {
	KeywordUtil.markFailed('debit is not same')
}
