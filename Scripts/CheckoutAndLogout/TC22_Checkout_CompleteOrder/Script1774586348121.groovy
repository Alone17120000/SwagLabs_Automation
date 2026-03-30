import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


WebUI.openBrowser('https://www.saucedemo.com/')
WebUI.setText(findTestObject('Object Repository/txt_Username'), 'standard_user')
WebUI.setText(findTestObject('Object Repository/txt_Password'), 'secret_sauce')
WebUI.click(findTestObject('Object Repository/btn_Login'))

WebUI.click(findTestObject('Object Repository/btn_AddToCart'))
WebUI.click(findTestObject('Object Repository/btn_Cart')) 
WebUI.click(findTestObject('Object Repository/btn_Checkout')) 

WebUI.setText(findTestObject('Object Repository/txt_FirstName'), 'Khoa')
WebUI.setText(findTestObject('Object Repository/txt_LastName'), 'Pham')
WebUI.setText(findTestObject('Object Repository/txt_ZipCode'), '700000')
WebUI.click(findTestObject('Object Repository/btn_Continue'))

WebUI.click(findTestObject('Object Repository/btn_Finish')) 

WebUI.verifyElementText(findTestObject('Object Repository/txt_CompleteHeader'), 'Thank you for your order!')

WebUI.closeBrowser()