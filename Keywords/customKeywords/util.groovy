package customKeywords

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.apache.http.util.Asserts
import org.openqa.selenium.By as By
import internal.GlobalVariable
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.Keys as Keys

public class util{

	@Keyword
	def isFileDownloaded(String downloadPath, String fileName) {
		boolean flag = false
		File dir = new File(downloadPath)
		File[] dirContents = dir.listFiles()

		for (int i = 0; i < dirContents.length; i++) {
			if (dirContents[i].getName().equals(fileName)) {
				dirContents[i].delete()
				return true
			}
		}

		return flag
	}

	@Keyword
	def getHeaderWithSpecCol(TestObject to, String col_Index) {
		WebElement webElement = WebUiCommonHelper.findWebElement(to,5)
		WebElement colElement = webElement.findElement(By.xpath(String.format('./thead/tr/th[%s]/span',col_Index)))
		String colHeader = colElement.getText()
		return colHeader
	}


	@Keyword
	def getCellValueWithSpecCol(TestObject to, String col_Index, String row_Index) {
		WebElement webElement = WebUiCommonHelper.findWebElement(to,5)
		WebElement cellElement = webElement.findElement(By.xpath(String.format('./tbody/tr[%s]/td[%s]',row_Index,col_Index)))
		String cellValue = cellElement.getText()
		return cellValue
	}

	@Keyword
	def clickSpecHeaderSpecTable(TestObject to, String col_Index) {
		WebElement webElement = WebUiCommonHelper.findWebElement(to,5)
		ArrayList<String> obtainedList = new ArrayList<String>()
		println("===========List of obtained email: ")
		for(int i=0; i<=3;i++) {
			WebElement emailElement = webElement.findElement(By.xpath(String.format("./tbody/tr[1+"+i+"]/td[%s]",col_Index )))
			obtainedList.add(emailElement.getText())
			println(emailElement.getText())
		}
		Collections.sort(obtainedList)

		WebElement emailHeaderCol2T2 = webElement.findElement(By.xpath(String.format("./thead/tr/th[%s]/span",col_Index)))
		emailHeaderCol2T2.click()

		sleep(1000)

		ArrayList<String> afterClickHeaderList = new ArrayList<String>()
		println("============List of sort email: ")
		for(int i=0; i<=3;i++) {
			WebElement emailElement1 = webElement.findElement(By.xpath(String.format("./tbody/tr[1+"+i+"]/td[%s]",col_Index)))
			afterClickHeaderList.add(emailElement1.getText())
			println("" + emailElement1.getText())
		}
		assert afterClickHeaderList.equals(obtainedList)
	}

}