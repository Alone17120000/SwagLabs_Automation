import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling

// 1. Login
WebUI.callTestCase(findTestCase('Test Cases/Login_Test'), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.delay(1)

// 2. Thêm 1 sản phẩm vào giỏ và đi tới giỏ hàng (Dùng JS Click cho lẹ)
WebUI.executeJavaScript("document.getElementById('add-to-cart-sauce-labs-backpack').click()", null)
WebUI.click(findTestObject('Checkout_Page/icon_cart'))
WebUI.delay(1)

// 3. Bấm nút Checkout
WebUI.executeJavaScript("document.getElementById('checkout').click()", null)
WebUI.waitForElementVisible(findTestObject('Checkout_Page/input_firstname'), 5)

// 4. Điền Form bằng các biến truyền vào từ Excel
WebUI.setText(findTestObject('Checkout_Page/input_firstname'), first_name)
WebUI.setText(findTestObject('Checkout_Page/input_lastname'), last_name)
WebUI.setText(findTestObject('Checkout_Page/input_zipcode'), zip_code)

// 5. Bấm nút Continue
WebUI.click(findTestObject('Checkout_Page/btn_continue'))

// 6. Lấy text câu báo lỗi hiện ra và so sánh với Excel
WebUI.waitForElementVisible(findTestObject('Checkout_Page/txt_error_msg'), 5)
String actualError = WebUI.getText(findTestObject('Checkout_Page/txt_error_msg'))

println("Lỗi thực tế: " + actualError)
println("Lỗi mong đợi: " + expected_error)

WebUI.verifyMatch(actualError, expected_error, false)

// 7. Đóng trình duyệt
WebUI.closeBrowser()