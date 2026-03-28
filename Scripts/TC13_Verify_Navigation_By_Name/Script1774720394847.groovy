import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling

// 1. Gọi Pre-condition Login
WebUI.callTestCase(findTestCase('Test Cases/Login_Test'), [:], FailureHandling.STOP_ON_FAILURE)

// 2. Chờ 1 giây cho giao diện ổn định
WebUI.delay(1)

// ==========================================
// ĐIỂM SỬA LỖI TỐI THƯỢNG: Ép trình duyệt click thẳng vào ID của sản phẩm bằng Javascript
WebUI.executeJavaScript("document.getElementById('item_0_title_link').click()", null)
// ==========================================

// 3. Đợi nút Back xuất hiện (tối đa 5s)
WebUI.waitForElementVisible(findTestObject('Product_Detail_Page/btn_back_to_products'), 5)

// 4. Lấy URL hiện tại và verify
String currentUrl = WebUI.getUrl()
WebUI.verifyMatch(currentUrl, '.*inventory-item.html.*', true)

// 5. Verify chi tiết sản phẩm
WebUI.verifyElementVisible(findTestObject('Product_Detail_Page/btn_back_to_products'))
String detailName = WebUI.getText(findTestObject('Product_Detail_Page/txt_detail_title'))
WebUI.verifyMatch(detailName, 'Sauce Labs Bike Light', false)

// 6. Đóng trình duyệt
WebUI.closeBrowser()