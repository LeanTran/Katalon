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

WebUI.click(findTestObject('WebUI/Homepage/lnk_Dropdown'))

println(WebUI.getText(findTestObject('WebUI/General/lbl_Page_Header')))

WebUI.verifyElementText(findTestObject('WebUI/General/lbl_Page_Header'), 'Dropdown List')

WebUI.verifyOptionsPresent(findTestObject('WebUI/DropDownPage/drd_Please select an option'), ['Please select an option', 'Option 1'
        , 'Option 2'])

WebUI.selectOptionByLabel(findTestObject('WebUI/DropDownPage/drd_Please select an option'), 'Option 2', true)

WebUI.verifyOptionSelectedByLabel(findTestObject('WebUI/DropDownPage/drd_Please select an option'), 'Option 2', false, 0)

WebUI.selectOptionByIndex(findTestObject('WebUI/DropDownPage/drd_Please select an option'), '1', FailureHandling.STOP_ON_FAILURE)

WebUI.verifyOptionSelectedByIndex(findTestObject('WebUI/DropDownPage/drd_Please select an option'), '1', 0)

WebUI.selectOptionByValue(findTestObject('WebUI/DropDownPage/drd_Please select an option'), '2', true)

WebUI.verifyOptionSelectedByValue(findTestObject('WebUI/DropDownPage/drd_Please select an option'), '2', false, 0)

@SetUp
def setup() {
    WebUI.openBrowser(GlobalVariable.url)

    WebUI.maximizeWindow()
}

@TearDown
def tearDown() {
    WebUI.closeBrowser()
}

