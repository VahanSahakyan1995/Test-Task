package automated_tests.pages.home;

import automated_tests.browser.Browser;
import automated_tests.configuration.AppConfig;
import automated_tests.pages.base.BasePage;
import automated_tests.pages.login_window.LoginWindow;
import automated_tests.pages.registor_window.RegistrationWindow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CraftBetHomePage extends BasePage {

    public CraftBetHomePage(Browser<WebDriver> browser) {
        super(browser, AppConfig.getInstance().getBaseUrl(), true);
    }

    public LoginWindow openLoginWindow() {
        // Click on the element to open the login window
        click(getBrowser().untilElementToBeClickable(By.className("button-style2")));
        return new LoginWindow(getBrowser());
    }

    public RegistrationWindow openRegistrationWindow() {
        // Click on the element to open the Registration window
        click(getBrowser().untilElementToBeClickable(By.xpath("//*[@id=\"header-section\"]/div/div/div[1]/ul/div/li[4]/div/app-global-sign-up-btn/button")));
        return new RegistrationWindow(getBrowser());
    }

}
