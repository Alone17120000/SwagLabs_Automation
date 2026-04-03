import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('https://www.saucedemo.com/')

WebUI.maximizeWindow()

WebUI.setText(findTestObject('Object Repository/txt_Username'), 'standard_user')

WebUI.setText(findTestObject('Object Repository/txt_Password'), 'secret_sauce')

WebUI.click(findTestObject('Object Repository/btn_Login'))

WebUI.waitForElementClickable(findTestObject('Object Repository/btn_AddToCart'), 5)

WebUI.click(findTestObject('Object Repository/btn_AddToCart'))

WebUI.click(findTestObject('Object Repository/btn_BurgerMenu'))

WebUI.waitForElementClickable(findTestObject('Object Repository/btn_ResetAppState'), 5)

WebUI.click(findTestObject('Object Repository/btn_ResetAppState'))

WebUI.refresh()

WebUI.delay(1)

WebUI.waitForElementPresent(findTestObject('Object Repository/btn_AddToCart'), 5)

WebUI.verifyElementPresent(findTestObject('Object Repository/btn_AddToCart'), 5)

WebUI.waitForElementClickable(findTestObject('Object Repository/item_FirstProduct'), 5)

WebUI.click(findTestObject('Object Repository/item_FirstProduct'))

WebUI.waitForElementClickable(findTestObject('Object Repository/btn_BackToProducts'), 5)

WebUI.click(findTestObject('Object Repository/btn_BackToProducts'))

WebUI.navigateToUrl('https://www.saucedemo.com/cart.html')

WebUI.waitForElementClickable(findTestObject('Object Repository/btn_BurgerMenu'), 5)

WebUI.click(findTestObject('Object Repository/btn_BurgerMenu'))

WebUI.waitForElementClickable(findTestObject('Object Repository/btn_AllItems'), 5)

WebUI.click(findTestObject('Object Repository/btn_AllItems'))

WebUI.verifyMatch(WebUI.getUrl(), '.*inventory.html.*', true)

WebUI.waitForElementClickable(findTestObject('Object Repository/btn_AddToCart'), 5)

WebUI.click(findTestObject('Object Repository/btn_AddToCart'))

WebUI.navigateToUrl('https://www.saucedemo.com/cart.html')

WebUI.waitForElementClickable(findTestObject('Object Repository/btn_RemoveInCart'), 5)

WebUI.click(findTestObject('Object Repository/btn_RemoveInCart'))

WebUI.verifyElementNotPresent(findTestObject('Object Repository/item_Cart_Product'), 3)

WebUI.navigateToUrl('https://www.saucedemo.com/inventory.html')

WebUI.waitForElementClickable(findTestObject('Object Repository/btn_AddToCart'), 5)

WebUI.click(findTestObject('Object Repository/btn_AddToCart'))

WebUI.navigateToUrl('https://www.saucedemo.com/cart.html')

WebUI.waitForElementClickable(findTestObject('Object Repository/btn_Checkout'), 5)

WebUI.click(findTestObject('Object Repository/btn_Checkout'))

WebUI.setText(findTestObject('Object Repository/txt_FirstName'), 'Khoa')

WebUI.setText(findTestObject('Object Repository/txt_LastName'), 'Pham')

WebUI.setText(findTestObject('Object Repository/txt_ZipCode'), '700000')

WebUI.click(findTestObject('Object Repository/btn_Continue'))

WebUI.waitForElementClickable(findTestObject('Object Repository/btn_CancelOverview'), 5)

WebUI.click(findTestObject('Object Repository/btn_CancelOverview'))

WebUI.navigateToUrl('https://www.saucedemo.com/cart.html')

WebUI.waitForElementClickable(findTestObject('Object Repository/btn_Checkout'), 5)

WebUI.click(findTestObject('Object Repository/btn_Checkout'))

WebUI.setText(findTestObject('Object Repository/txt_FirstName'), 'Khoa')

WebUI.setText(findTestObject('Object Repository/txt_LastName'), 'Pham')

WebUI.setText(findTestObject('Object Repository/txt_ZipCode'), '700000')

WebUI.click(findTestObject('Object Repository/btn_Continue'))

WebUI.verifyElementText(findTestObject('Object Repository/txt_ProductName_Overview'), 'Sauce Labs Backpack')

WebUI.click(findTestObject('Object Repository/btn_BurgerMenu'))

WebUI.waitForElementClickable(findTestObject('Object Repository/btn_ResetAppState'), 5)

WebUI.click(findTestObject('Object Repository/btn_ResetAppState'))

WebUI.refresh()

WebUI.delay(1)

WebUI.navigateToUrl('https://www.saucedemo.com/inventory.html')

WebUI.waitForElementClickable(findTestObject('Object Repository/btn_AddOnesie'), 5)

WebUI.click(findTestObject('Object Repository/btn_AddOnesie'))

WebUI.navigateToUrl('https://www.saucedemo.com/cart.html')

WebUI.waitForElementClickable(findTestObject('Object Repository/btn_Checkout'), 5)

WebUI.click(findTestObject('Object Repository/btn_Checkout'))

WebUI.setText(findTestObject('Object Repository/txt_FirstName'), 'Khoa')

WebUI.setText(findTestObject('Object Repository/txt_LastName'), 'Pham')

WebUI.setText(findTestObject('Object Repository/txt_ZipCode'), '700000')

WebUI.click(findTestObject('Object Repository/btn_Continue'))

WebUI.waitForElementPresent(findTestObject('txt_ItemTotal'), 5)

WebUI.verifyElementText(findTestObject('Object Repository/txt_Total'), 'Total: $41.02')

WebUI.waitForElementClickable(findTestObject('Object Repository/btn_Finish'), 5)

WebUI.click(findTestObject('Object Repository/btn_Finish'))

WebUI.verifyElementText(findTestObject('Object Repository/txt_CompleteHeader'), 'Thank you for your order!')

WebUI.waitForElementClickable(findTestObject('Object Repository/btn_BackHome'), 5)

WebUI.click(findTestObject('Object Repository/btn_BackHome'))

WebUI.click(findTestObject('Object Repository/btn_BurgerMenu'))

WebUI.waitForElementClickable(findTestObject('Object Repository/btn_ResetAppState'), 5)

WebUI.click(findTestObject('Object Repository/btn_ResetAppState'))

WebUI.refresh()

WebUI.navigateToUrl('https://www.saucedemo.com/inventory.html')
WebUI.waitForElementClickable(findTestObject('Object Repository/btn_AddToCart'), 5)
WebUI.click(findTestObject('Object Repository/btn_AddToCart'))

WebUI.click(findTestObject('Object Repository/btn_BurgerMenu'))
WebUI.waitForElementClickable(findTestObject('Object Repository/btn_Logout'), 5)
WebUI.click(findTestObject('Object Repository/btn_Logout'))

WebUI.waitForElementPresent(findTestObject('Object Repository/txt_Username'), 5)
WebUI.setText(findTestObject('Object Repository/txt_Username'), 'standard_user')
WebUI.setText(findTestObject('Object Repository/txt_Password'), 'secret_sauce')
WebUI.click(findTestObject('Object Repository/btn_Login'))

WebUI.waitForElementPresent(findTestObject('Object Repository/txt_CartBadge'), 5)
WebUI.verifyElementText(findTestObject('Object Repository/txt_CartBadge'), '1')

WebUI.takeScreenshot()
WebUI.closeBrowser()