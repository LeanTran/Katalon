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
import org.openqa.selenium.interactions.Actions as Actions
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

WebUI.click(findTestObject('WebUI/Homepage/lnk_Menu'))

println(WebUI.getText(findTestObject('WebUI/General/lbl_Page_Header')))

WebUI.verifyElementText(findTestObject('WebUI/General/lbl_Page_Header'), 'JQueryUI - Menu')

WebUI.click(findTestObject('WebUI/MenuPage/mnu_Enabled'))

WebUI.delay(1)

WebUI.click(findTestObject('WebUI/MenuPage/mnu_JQueryUI'))

WebUI.delay(1)

WebUI.verifyElementText(findTestObject('WebUI/MenuPage/lbl_JQueryUIHeader'), 'JQuery UI')

WebUI.click(findTestObject('WebUI/MenuPage/lnk_MenuLink'))

WebUI.delay(1)

WebUI.verifyElementText(findTestObject('WebUI/General/lbl_Page_Header'), 'JQueryUI - Menu')

WebUI.click(findTestObject('WebUI/MenuPage/mnu_Enabled'))

WebUI.delay(1)

WebUI.click(findTestObject('WebUI/MenuPage/mnu_Download'))

WebUI.delay(1)

WebUI.click(findTestObject('WebUI/MenuPage/mnu_CSV'))

WebUI.delay(5)

WebUI.delay(1)

String home = System.getProperty('user.home')

String userDownloads = new File(home + '/Downloads/')

CustomKeywords.'customKeywords.util.isFileDownloaded'(userDownloads, 'menu.csv')

@SetUp
def setup() {
    WebUI.openBrowser(GlobalVariable.url)

    WebUI.maximizeWindow()
}

@TearDown
def tearDown() {
    WebUI.closeBrowser()
}