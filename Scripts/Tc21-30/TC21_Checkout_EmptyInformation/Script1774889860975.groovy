import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('https://www.saucedemo.com/')
WebUI.setText(findTestObject('Object Repository/txt_Username'), 'standard_user')
WebUI.setText(findTestObject('Object Repository/txt_Password'), 'secret_sauce')
WebUI.click(findTestObject('Object Repository/btn_Login'))

WebUI.click(findTestObject('Object Repository/btn_AddToCart'))

WebUI.click(findTestObject('Object Repository/btn_BurgerMenu'))

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/btn_ResetAppState'))

WebUI.verifyElementPresent(findTestObject('Object Repository/btn_AddToCart'), 5)

WebUI.takeScreenshot()
WebUI.closeBrowser()
