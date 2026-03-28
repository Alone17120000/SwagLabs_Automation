import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling

// 1. Gọi Pre-condition Login
WebUI.callTestCase(findTestCase('Test Cases/Login_Test'), [:], FailureHandling.STOP_ON_FAILURE)

// 2. Chú ý đường dẫn bây giờ là 'HomePage/dropdown_sort'
WebUI.selectOptionByLabel(findTestObject('HomePage/dropdown_sort'), sort_option, false)

// 3. Chú ý đường dẫn bây giờ là 'HomePage/first_item_name'
String actual_item = WebUI.getText(findTestObject('HomePage/first_item_name'))

println("Option đã chọn: " + sort_option)
println("Sản phẩm hiện ra: " + actual_item)

// 5. So sánh tên sản phẩm thực tế với biến 'expected_item'
WebUI.verifyMatch(actual_item, expected_item, false)

// 6. Đóng trình duyệt để chuẩn bị cho vòng lặp tiếp theo
WebUI.closeBrowser()