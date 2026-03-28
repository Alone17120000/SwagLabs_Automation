import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling
import org.openqa.selenium.WebElement

// 1. Gọi Test Case Login (Pre-condition) để tự động đăng nhập
WebUI.callTestCase(findTestCase('Test Cases/Login_Test'), [:], FailureHandling.STOP_ON_FAILURE)

// 2. Tìm TẤT CẢ các sản phẩm trên trang (dùng findWebElements có chữ 's')
// Lưu ý: Đường dẫn 'Object Repository/item_product' phải khớp với tên bạn đã lưu ở Bước 2
List<WebElement> products = WebUI.findWebElements(findTestObject('Object Repository/HomePage/item_product'), 10)

// 3. In ra console số lượng tìm được để dễ debug
println("Số lượng sản phẩm tìm thấy trên trang là: " + products.size())

// 4. Verify số lượng sản phẩm bằng đúng 6
WebUI.verifyEqual(products.size(), 6, FailureHandling.STOP_ON_FAILURE)

// 5. Đóng trình duyệt sau khi test xong
WebUI.closeBrowser()