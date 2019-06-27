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

WebUI.click(findTestObject('WebUI/Homepage/link_ChallengeDom'))

println(WebUI.getText(findTestObject('WebUI/General/lbl_Page_Header')))

WebUI.verifyElementText(findTestObject('WebUI/General/lbl_Page_Header'), 'Challenging DOM')

String fontsize = WebUI.getCSSValue(findTestObject('WebUI/ChallengeDomPage/btn_bar'), 'font-size')
println(fontsize)
WebUI.verifyEqual(fontsize, '16px')

String backgroundColor = WebUI.getCSSValue(findTestObject('WebUI/ChallengeDomPage/btn_qux'), 'background-color')
println(backgroundColor)
WebUI.verifyEqual(backgroundColor, 'rgb(198, 15, 19)')

String borderColor = WebUI.getCSSValue(findTestObject('WebUI/ChallengeDomPage/btn_baz'), 'border-color')
println(borderColor)
WebUI.verifyEqual(borderColor, 'rgb(69, 122, 26)')

@SetUp
def setup() {
    WebUI.openBrowser(GlobalVariable.url)

    WebUI.maximizeWindow()
}

@TearDown
def tearDown() {
    WebUI.closeBrowser()
}