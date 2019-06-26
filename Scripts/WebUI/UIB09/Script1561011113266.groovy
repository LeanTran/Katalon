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
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.By as By
import org.openqa.selenium.interactions.Actions as Actions
import org.openqa.selenium.WebElement as WebElement

WebUI.click(findTestObject('Homepage/lnk_Slider'))
println(WebUI.getText(findTestObject('General/lbl_Page_Header')))
WebUI.verifyElementText(findTestObject('General/lbl_Page_Header'), 'Horizontal Slider')

WebUI.verifyElementPresent(findTestObject('HorizontalSliderPage/sld_SliderContainer'), 30)

WebDriver driver = DriverFactory.getWebDriver()
WebElement slider = driver.findElement(By.xpath('//input[@type=\'range\']'))
Actions action = new Actions(driver)
String xpath = '//div[contains(@id,\'content\')]/div/div/span'

action.clickAndHold(slider).moveByOffset(-56, 0).release().build().perform()
WebElement displayRange1 = driver.findElement(By.xpath(xpath))
String priceValue1 = displayRange1.getText()
println('Value_1: ' + priceValue1)
Thread.sleep(1000)
WebUI.verifyEqual('1', priceValue1)

action.clickAndHold(slider).moveByOffset(0, 0).release().build().perform()
WebElement displayRange2 = driver.findElement(By.xpath(xpath))
String priceValue2 = displayRange2.getText()
println('Value_2: ' + priceValue2)
Thread.sleep(1000)
WebUI.verifyEqual('2.5', priceValue2)

action.clickAndHold(slider).moveByOffset(70, 0).release().build().perform()
WebElement displayRange3 = driver.findElement(By.xpath(xpath))
String priceValue3 = displayRange3.getText()
println('Value_3: ' + priceValue3)
Thread.sleep(1000)
WebUI.verifyEqual('4.5', priceValue3)


@SetUp
def setup() {
    WebUI.openBrowser(GlobalVariable.url)

    WebUI.maximizeWindow()
}

@TearDown
def tearDown() {
    WebUI.closeBrowser()
}