import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.lang.reflect.Array as Array
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
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import org.openqa.selenium.WebElement as WebElement


WebUI.click(findTestObject('WebUI/Homepage/lnk_Iframe'))
println(WebUI.getText(findTestObject('WebUI/General/lbl_Page_Header')))
WebUI.verifyElementText(findTestObject('WebUI/General/lbl_Page_Header'), 'An iFrame containing the TinyMCE WYSIWYG Editor')

WebUI.switchToFrame(findTestObject('WebUI/IframePage/frm_Iframe'), 30)
WebUI.verifyElementText(findTestObject('WebUI/IframePage/txt_htmlContent'), 'Your content goes here.')

WebUI.clearText(findTestObject('WebUI/IframePage/txt_htmlContent'))
WebElement element = WebUiCommonHelper.findWebElement(findTestObject('WebUI/IframePage/txt_htmlContent'),30)
WebUI.executeJavaScript('arguments[0].innerHTML = \'Hello, how are you?\'', Arrays.asList(element))

@SetUp
def setup() {
    WebUI.openBrowser(GlobalVariable.url)

    WebUI.maximizeWindow()
}

@TearDown
def tearDown() {
    WebUI.closeBrowser()
}