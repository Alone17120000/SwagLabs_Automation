import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling

// 1. Gọi Pre-condition Login
WebUI.callTestCase(findTestCase('Test Cases/Login_Test'), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.delay(1)

// 2. Đi vào trang chi tiết của sản phẩm Balo
WebUI.scrollToElement(findTestObject('HomePage/img_backpack'), 3)
WebUI.executeJavaScript("document.getElementById('item_4_img_link').click()", null)

// 3. Chờ nút Back xuất hiện
WebUI.waitForElementVisible(findTestObject('Product_Detail_Page/btn_back_to_products'), 5)

// ==========================================
// 4. ĐIỂM SỬA LỖI: Dùng JS Click ép trình duyệt click thẳng vào ID của nút Back
WebUI.executeJavaScript("document.getElementById('back-to-products').click()", null)
// ==========================================

// 5. Chờ Dropdown Sort xuất hiện để chắc chắn trang chủ đã load xong
WebUI.waitForElementVisible(findTestObject('HomePage/dropdown_sort'), 5)

// 6. Lấy URL hiện tại và kiểm tra xem đã quay về đúng trang 'inventory.html' chưa
String currentUrl = WebUI.getUrl()
WebUI.verifyMatch(currentUrl, '.*inventory.html.*', true)

// 7. Đóng trình duyệt
WebUI.closeBrowser()