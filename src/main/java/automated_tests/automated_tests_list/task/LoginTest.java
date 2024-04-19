package automated_tests.automated_tests_list.task;

import automated_tests.automated_tests_list.base.Base;
import automated_tests.pages.home.CraftBetHomePage;
import automated_tests.pages.login_window.LoginWindow;
import automated_tests.pages.registor_window.RegistrationWindow;
import automated_tests.utils.Listener;
import automated_tests.utils.RetryAnalyzer;
import org.junit.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Listener.class)
public class LoginTest extends Base {

    private LoginWindow loginWindow;
    private CraftBetHomePage craftBetHomePage;
    private RegistrationWindow registrationWindow;

    //Precondition
    //User should be logged out

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void openLoginWindow() {
        craftBetHomePage = new CraftBetHomePage(getBrowser());
        loginWindow = craftBetHomePage.openLoginWindow();
    }

    @Test(priority = 2, dependsOnMethods = "openLoginWindow")
    public void checkEntryButtonClickable() {
        loginWindow.fillLoginWindow();
        Assert.assertTrue(loginWindow.isEntryButtonClickable());
    }

    @Test(priority = 3, dependsOnMethods = "checkEntryButtonClickable")
    public void checkForIncorrectInputParametersLogin() {
        loginWindow.clickOnEntryButton();
        Assert.assertEquals("Սխալ մուտքային տվյալներ",loginWindow.getErrorMessageText());
    }

    @Test(priority = 4, dependsOnMethods = "openLoginWindow")
    public void checkNavigateToRegistrationWindow() {
        registrationWindow = loginWindow.clickOnRegistrationButton();
    }
}
