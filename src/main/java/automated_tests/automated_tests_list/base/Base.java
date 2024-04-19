package automated_tests.automated_tests_list.base;

import automated_tests.browser.Browser;
import automated_tests.configuration.DriverFactory;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.Random;

@Log4j2
public class Base {

    private Browser<WebDriver> browser;

    @BeforeTest
    @Parameters(value = {"browser"})
    public void initDriver(@Optional String brow) {
        DriverFactory.getInstance().setDriver(brow);
    }

    @AfterTest
    public static void closeDriver() {
        DriverFactory.getInstance().close();
    }

    public void browserNavigation(String url) {
        browser = getBrowser();
        browser.driver().navigate().to(url);
    }

    public Browser<WebDriver> getBrowser() {
        return DriverFactory.getInstance().getBrowser();
    }

    public String collectRandomSmallLetters() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 5;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();
        return generatedString;
    }

}