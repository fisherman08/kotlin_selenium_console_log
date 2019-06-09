import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeDriverService
import org.openqa.selenium.chrome.ChromeOptions
import java.util.logging.Level
import org.openqa.selenium.remote.CapabilityType
import org.openqa.selenium.logging.LogType
import org.openqa.selenium.logging.LoggingPreferences
import org.openqa.selenium.remote.DesiredCapabilities


fun main(args: Array<String>) {
    val capabilities = DesiredCapabilities.chrome()
    val logPreference = LoggingPreferences()
    val options = ChromeOptions()

    // ログレベルを設定
    logPreference.enable(LogType.BROWSER, Level.ALL)
    capabilities.setCapability(CapabilityType.LOGGING_PREFS, logPreference)

    // ヘッドレスモード
    options.addArguments("--headless")
    capabilities.setCapability(ChromeOptions.CAPABILITY, options)

    val driver = ChromeDriver(capabilities)

    driver.get("https://***")

    driver.executeScript("console.log('hoge');")
    val logs = driver.manage().logs().get(LogType.BROWSER)

    logs.forEach { logEntry ->
        println(logEntry)
    }

    driver.quit()
}