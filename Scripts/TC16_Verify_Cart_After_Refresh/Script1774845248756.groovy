import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling

// 1. Gọi Pre-condition Login
WebUI.callTestCase(findTestCase('Test Cases/Login_Test'), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.delay(1)

// ==========================================
// 2. SỬA LỖI: Dùng Tuyệt chiêu JS Click để ép web phải nhận lệnh Add to Cart
WebUI.executeJavaScript("document.getElementById('add-to-cart-sauce-labs-backpack').click()", null)
// ==========================================

// 3. Kiểm tra xem icon giỏ hàng đã hiện số '1' chưa
WebUI.waitForElementVisible(findTestObject('HomePage/icon_cart_badge'), 5)
String cartCountBefore = WebUI.getText(findTestObject('HomePage/icon_cart_badge'))
WebUI.verifyMatch(cartCountBefore, '1', false)
println("Số lượng giỏ hàng TRƯỚC khi F5 là: " + cartCountBefore)

// 4. Lệnh F5 (Refresh) lại trình duyệt
WebUI.refresh()

// Thêm 1s nghỉ ngơi để trình duyệt load lại DOM sau khi F5
WebUI.delay(1) 

// 5. Chờ trang load lại xong và kiểm tra số lượng giỏ hàng VẪN LÀ '1'
WebUI.waitForElementVisible(findTestObject('HomePage/icon_cart_badge'), 5)
String cartCountAfter = WebUI.getText(findTestObject('HomePage/icon_cart_badge'))
WebUI.verifyMatch(cartCountAfter, '1', false)
println("Số lượng giỏ hàng SAU khi F5 là: " + cartCountAfter)

// 6. Đóng trình duyệt
WebUI.closeBrowser()