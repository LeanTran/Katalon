import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
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
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.By as By
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

WebUI.click(findTestObject('WebUI/Homepage/lnk_KeyPresses'))
println(WebUI.getText(findTestObject('WebUI/General/lbl_Page_Header')))
WebUI.verifyElementText(findTestObject('WebUI/General/lbl_Page_Header'), 'Key Presses')

WebUI.sendKeys(findTestObject('WebUI/KeyPressesPage/frm_input'), ((Keys.TAB) as String))
println(WebUI.getText(findTestObject('WebUI/KeyPressesPage/txt_Result')))
WebUI.verifyElementText(findTestObject('WebUI/KeyPressesPage/txt_Result'), 'You entered: TAB')

WebUI.clearText(findTestObject('WebUI/KeyPressesPage/frm_input'))
WebUI.sendKeys(findTestObject('WebUI/KeyPressesPage/frm_input'), Keys.chord(Keys.SHIFT, 'g'))
println(WebUI.getText(findTestObject('WebUI/KeyPressesPage/txt_Result')))
WebUI.verifyElementText(findTestObject('WebUI/KeyPressesPage/txt_Result'), 'You entered: G')

WebUI.clearText(findTestObject('WebUI/KeyPressesPage/frm_input'))
WebUI.sendKeys(findTestObject('WebUI/KeyPressesPage/frm_input'), ((Keys.ENTER) as String))
println(WebUI.getText(findTestObject('WebUI/KeyPressesPage/txt_Result')))
WebUI.verifyElementText(findTestObject('WebUI/KeyPressesPage/txt_Result'), 'You entered: ENTER')

@SetUp
def setup() {
    WebUI.openBrowser(GlobalVariable.url)

    WebUI.maximizeWindow()
}

@TearDown
def tearDown() {
    WebUI.closeBrowser()
}