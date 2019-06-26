import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import com.kms.katalon.core.annotation.SetUp as SetUp
import com.kms.katalon.core.annotation.TearDown as TearDown
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
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

WebUI.click(findTestObject('Homepage/lnk_JSAlerts'))
println(WebUI.getText(findTestObject('General/lbl_Page_Header')))
WebUI.verifyElementText(findTestObject('General/lbl_Page_Header'), 'JavaScript Alerts')

WebUI.click(findTestObject('JSAlertPage/btn_JSAlert'))
WebDriver driver = DriverFactory.getWebDriver()
String alertText = driver.switchTo().alert().getText()
WebUI.verifyEqual(alertText, 'I am a JS Alert')
WebUI.acceptAlert()
WebUI.verifyElementText(findTestObject('JSAlertPage/txt_Result'), 'You successfuly clicked an alert')

WebUI.click(findTestObject('JSAlertPage/btn_JSConfirm'))
WebUI.dismissAlert()
WebUI.verifyElementText(findTestObject('JSAlertPage/txt_Result'), 'You clicked: Cancel')

WebUI.click(findTestObject('JSAlertPage/btn_JSPrompt'))
driver.switchTo().alert().sendKeys('Hello')
WebUI.acceptAlert()
WebUI.verifyElementText(findTestObject('JSAlertPage/txt_Result'), 'You entered: Hello')

@SetUp
def setup() {
    WebUI.openBrowser(GlobalVariable.url)

    WebUI.maximizeWindow()
}

//@TearDown
//def tearDown() {
//    WebUI.closeBrowser()
//}

