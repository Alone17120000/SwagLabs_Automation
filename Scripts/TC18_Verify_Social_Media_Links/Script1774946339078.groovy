import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling

// 1. Login (Sử dụng lại kịch bản cũ)
WebUI.callTestCase(findTestCase('Test Cases/Login_Test'), [:], FailureHandling.STOP_ON_FAILURE)

// 2. Cuộn chuột xuống cuối trang
WebUI.scrollToPosition(0, 9999)

// 3. MẸO PRO: Lấy link ẩn trong nút Social mà không cần click
// Chúng ta truyền biến 'social_name' từ Excel vào Object Dynamic
String actualUrl = WebUI.getAttribute(findTestObject('Footer/link_social_dynamic', [('name') : social_name]), 'href')

println("Đang kiểm tra mạng xã hội: " + social_name)
println("Link thực tế: " + actualUrl)

// 4. KIỂM TRA: So sánh link thực tế với link mong đợi trong Excel
WebUI.verifyMatch(actualUrl, '.*' + expected_url + '.*', true)

// 5. Đóng trình duyệt để chuẩn bị cho dòng dữ liệu tiếp theo
WebUI.closeBrowser()