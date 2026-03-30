import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('https://www.saucedemo.com/')
WebUI.setText(findTestObject('Object Repository/txt_Username'), 'standard_user')
WebUI.setText(findTestObject('Object Repository/txt_Password'), 'secret_sauce')
WebUI.click(findTestObject('Object Repository/btn_Login'))

WebUI.click(findTestObject('Object Repository/item_FirstProduct'))
WebUI.delay(1) 


WebUI.click(findTestObject('Object Repository/btn_BackToProducts'))


def currentUrl = WebUI.getUrl()
WebUI.verifyMatch(currentUrl, '.*inventory.html.*', true)

WebUI.closeBrowser()