import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('https://www.saucedemo.com/')

WebUI.setText(findTestObject('UCO1/txt_username'), 'standard_user')

WebUI.setText(findTestObject('UCO1/txt_password'), 'secret_sauce')

WebUI.click(findTestObject('UCO1/btn_login'))

WebUI.verifyElementPresent(findTestObject('UCO1/txt_products'), 5)

WebUI.selectOptionByValue(findTestObject('UCO1/select_sort'), 'az', false)

WebUI.selectOptionByValue(findTestObject('UCO1/select_sort'), 'za', false)

WebUI.selectOptionByValue(findTestObject('UCO1/select_sort'), 'lohi', false)

WebUI.selectOptionByValue(findTestObject('UCO1/select_sort'), 'hilo', false)

WebUI.click(findTestObject('UCO1/btn_menu'))

WebUI.click(findTestObject('UCO1/lnk_reset'))

WebUI.selectOptionByValue(findTestObject('UCO1/select_sort'), 'lohi', false)

WebUI.click(findTestObject('UCO1/lnk_backpack'))

WebUI.click(findTestObject('UCO1/btn_add_cart'))

WebUI.click(findTestObject('UCO1/btn_remove'))

WebUI.click(findTestObject('UCO1/btn_add_cart'))

WebUI.click(findTestObject('UCO1/icon_cart'))

WebUI.click(findTestObject('UCO1/btn_checkout'))

WebUI.setText(findTestObject('UCO1/txt_fname'), 'Hau')

WebUI.setText(findTestObject('UCO1/lname'), 'Nguyen')

WebUI.setText(findTestObject('UCO1/zip'), '70000')

WebUI.click(findTestObject('UCO1/btn_continue'))

WebUI.verifyElementPresent(findTestObject('UCO1/txt_overview_title'), 5)

WebUI.verifyElementPresent(findTestObject('UCO1/txt_total_price'), 0)

WebUI.click(findTestObject('UCO1/btn_finish'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('UCO1/btn_back_home'))

WebUI.click(findTestObject('UCO1/lnk_fb'))

WebUI.click(findTestObject('UCO1/btn_menu'))

WebUI.click(findTestObject('UCO1/lnk_logout'))

WebUI.closeBrowser()

