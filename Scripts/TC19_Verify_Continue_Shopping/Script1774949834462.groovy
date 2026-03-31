import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling

// 1. Gọi Pre-condition Login
WebUI.callTestCase(findTestCase('Test Cases/Login_Test'), [:], FailureHandling.STOP_ON_FAILURE)

// 2. Nhảy thẳng vào Giỏ hàng bằng lệnh JS
WebUI.executeJavaScript("document.querySelector('.shopping_cart_link').click()", null)

// 3. Đợi trang Giỏ hàng load xong và nút 'Continue Shopping' xuất hiện
WebUI.waitForElementVisible(findTestObject('Cart_Page/btn_continue_shopping'), 5)
WebUI.delay(1) 

// ==========================================
// 4. Bấm nút Continue Shopping bằng JS Click (Tuyệt chiêu tránh Dead Click đã fix lần trước)
WebUI.executeJavaScript("document.getElementById('continue-shopping').click()", null)
// ==========================================

// 5. Chờ Dropdown Sort xuất hiện để chắc chắn đã load xong trang chủ
WebUI.waitForElementVisible(findTestObject('HomePage/dropdown_sort'), 5)

// 6. Kiểm tra URL xem đã quay về đúng trang danh sách sản phẩm chưa
String currentUrl = WebUI.getUrl()
WebUI.verifyMatch(currentUrl, '.*inventory.html.*', true)
println("Tuyệt vời! Nút Continue Shopping hoạt động chính xác và đã quay về trang chủ.")

// 7. Đóng trình duyệt
WebUI.closeBrowser()