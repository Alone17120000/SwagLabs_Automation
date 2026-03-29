import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling

// 1. Gọi Pre-condition Login
WebUI.callTestCase(findTestCase('Test Cases/Login_Test'), [:], FailureHandling.STOP_ON_FAILURE)

// 2. Chờ 1 giây cho giao diện ổn định
WebUI.delay(1)

// 3. Cuộn chuột đến vị trí hình ảnh Balo
WebUI.scrollToElement(findTestObject('HomePage/img_backpack'), 3)

// 4. Tuyệt chiêu JS Click: Ép trình duyệt click thẳng vào ID của hình ảnh Balo
WebUI.executeJavaScript("document.getElementById('item_4_img_link').click()", null)

// 5. TÁI SỬ DỤNG OBJECT: Đợi nút Back xuất hiện (tối đa 5s)
WebUI.waitForElementVisible(findTestObject('Product_Detail_Page/btn_back_to_products'), 5)

// 6. Lấy URL hiện tại và verify xem có đúng là trang chi tiết không
String currentUrl = WebUI.getUrl()
WebUI.verifyMatch(currentUrl, '.*inventory-item.html.*', true)

// 7. TÁI SỬ DỤNG OBJECT: Kiểm tra tiêu đề sản phẩm trong trang chi tiết có đúng là cái Balo không
WebUI.verifyElementVisible(findTestObject('Product_Detail_Page/btn_back_to_products'))
String detailName = WebUI.getText(findTestObject('Product_Detail_Page/txt_detail_title'))
WebUI.verifyMatch(detailName, 'Sauce Labs Backpack', false)

// 8. Đóng trình duyệt
WebUI.closeBrowser()