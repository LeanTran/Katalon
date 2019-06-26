import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.annotation.SetUp as SetUp
import com.kms.katalon.core.annotation.TearDown as TearDown

@SetUp
def setup() {
	WebUI.openBrowser(GlobalVariable.url)
	WebUI.maximizeWindow()
}

@TearDown
def tearDown() {
	WebUI.closeBrowser()
}


WebUI.click(findTestObject('Homepage/lnk_Checkboxes'))

println(WebUI.getText(findTestObject('General/lbl_Page_Header')))

WebUI.verifyElementText(findTestObject('General/lbl_Page_Header'), 'Checkboxes')

TestObject chk_checkbox1 = findTestObject('CheckboxPage/chk_Checkbox1')

WebUI.check(chk_checkbox1)

WebUI.verifyElementChecked(chk_checkbox1, 30)

TestObject chk_checkbox2 = findTestObject('CheckboxPage/chk_Checkbox2')

WebUI.uncheck(chk_checkbox2)

WebUI.verifyElementNotChecked(chk_checkbox2, 30)


