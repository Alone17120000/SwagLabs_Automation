import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling

// 1. Gọi Pre-condition Login
WebUI.callTestCase(findTestCase('Test Cases/Login_Test'), [:], FailureHandling.STOP_ON_FAILURE)

// ==========================================
// 2. THÊM SẢN PHẨM 1: Balo (Sử dụng JS Click chống Dead Click)
WebUI.waitForElementVisible(findTestObject('HomePage/btn_add_backpack'), 5)
WebUI.executeJavaScript("document.getElementById('add-to-cart-sauce-labs-backpack').click()", null)

WebUI.waitForElementVisible(findTestObject('HomePage/icon_cart_badge'), 5)
String cartCount1 = WebUI.getText(findTestObject('HomePage/icon_cart_badge'))
WebUI.verifyMatch(cartCount1, '1', false)
println("Đã thêm 1 sản phẩm. Giỏ hàng hiện: " + cartCount1)

// ==========================================
// 3. THÊM SẢN PHẨM 2: Đèn xe đạp (Sử dụng JS Click)
WebUI.executeJavaScript("document.getElementById('add-to-cart-sauce-labs-bike-light').click()", null)

WebUI.delay(1) // Nghỉ 1 nhịp ngắn cho ReactJS kịp cộng dồn số trên giao diện
String cartCount2 = WebUI.getText(findTestObject('HomePage/icon_cart_badge'))
WebUI.verifyMatch(cartCount2, '2', false)
println("Đã thêm 2 sản phẩm. Giỏ hàng hiện: " + cartCount2)

// ==========================================
// 4. THÊM SẢN PHẨM 3: Áo thun (Sử dụng JS Click)
WebUI.executeJavaScript("document.getElementById('add-to-cart-sauce-labs-bolt-t-shirt').click()", null)

WebUI.delay(1)
String cartCount3 = WebUI.getText(findTestObject('HomePage/icon_cart_badge'))
WebUI.verifyMatch(cartCount3, '3', false)
println("Tuyệt vời! Đã thêm 3 sản phẩm. Giỏ hàng hiện chính xác: " + cartCount3)

// ==========================================
// 5. Đóng trình duyệt
WebUI.closeBrowser()