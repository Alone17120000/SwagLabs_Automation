import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling

// 1. Gọi Pre-condition Login
WebUI.callTestCase(findTestCase('Test Cases/Login_Test'), [:], FailureHandling.STOP_ON_FAILURE)

// 2. Chuẩn bị dữ liệu: Thêm 1 Balo vào giỏ (Dùng JS Click chống lỗi)
WebUI.executeJavaScript("document.getElementById('add-to-cart-sauce-labs-backpack').click()", null)

// 3. Chuyển sang trang Giỏ hàng
WebUI.executeJavaScript("document.querySelector('.shopping_cart_link').click()", null)

// 4. Chờ trang Giỏ hàng load xong và Tên sản phẩm xuất hiện
WebUI.waitForElementVisible(findTestObject('Cart_Page/link_cart_item_name'), 5)
WebUI.delay(1)

// ==========================================
// 5. FIX LỖI DEAD CLICK: Dùng JS Click ép trình duyệt bấm thẳng vào thẻ <a> bọc ngoài tên Balo (ID = item_4_title_link)
WebUI.executeJavaScript("document.getElementById('item_4_title_link').click()", null)
// ==========================================

// 6. KIỂM TRA: Xác nhận hệ thống đã nhảy sang trang Chi tiết sản phẩm
// Tạm nghỉ 1 nhịp để trang chi tiết load
WebUI.delay(1) 
String currentUrl = WebUI.getUrl()
WebUI.verifyMatch(currentUrl, '.*inventory-item.html.*', true)
println("Tuyệt vời! Đã click vào tên sản phẩm trong giỏ và xem được chi tiết.")

// 7. Đóng trình duyệt
WebUI.closeBrowser()