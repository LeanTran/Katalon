import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.annotation.SetUp as SetUp
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
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

WebUI.click(findTestObject('WebUI/Homepage/lnk_Table'))

println(WebUI.getText(findTestObject('WebUI/General/lbl_Page_Header')))

WebUI.verifyElementText(findTestObject('WebUI/General/lbl_Page_Header'), 'Data Tables')

String colHeader = CustomKeywords.'customKeywords.util.getHeaderWithSpecCol'(findTestObject('WebUI/TablePage/tb_table1'), '3')

println('Column header: ' + colHeader)

String r3c2Element = CustomKeywords.'customKeywords.util.getCellValueWithSpecCol'(findTestObject('WebUI/TablePage/tb_table1'), 
    '2', '3')

println('cell value (row 3, column 2) on Table 1: ' + r3c2Element)

String r2c4Element = CustomKeywords.'customKeywords.util.getCellValueWithSpecCol'(findTestObject('WebUI/TablePage/tb_table1'), 
    '4', '2')

println(' cell value (row 2, column 4) on Table 1: ' + r2c4Element)

CustomKeywords.'customKeywords.util.clickSpecHeaderSpecTable'(findTestObject('WebUI/TablePage/tb_table2'), '3')

@SetUp
def setup() {
    WebUI.openBrowser(GlobalVariable.url)

    WebUI.maximizeWindow()
}

@TearDown
def tearDown() {
    WebUI.closeBrowser()
}