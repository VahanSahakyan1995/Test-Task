package automated_tests.automated_tests_list.task;

import automated_tests.automated_tests_list.base.Base;
import automated_tests.pages.home.CraftBetHomePage;
import automated_tests.pages.registor_window.RegistrationWindow;
import automated_tests.utils.Listener;
import automated_tests.utils.RetryAnalyzer;
import org.junit.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Listener.class)
public class RegistrationTest extends Base {

    private CraftBetHomePage craftBetHomePage;
    private RegistrationWindow registrationWindow;

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void openRegistrationWindow() {
        craftBetHomePage = new CraftBetHomePage(getBrowser());
        registrationWindow = craftBetHomePage.openRegistrationWindow();
    }

    @Test(priority = 2, dependsOnMethods = "openRegistrationWindow")
    public void openFullRegistrationWindow() {
        registrationWindow.clickOnFullRegistrationButton();
        Assert.assertTrue(registrationWindow.checkIfFullRegistrationWindowDisplayed());
    }

    @Test(priority = 3, dependsOnMethods = "openFullRegistrationWindow")
    public void fillFirstStepOfFullRegistrationWindow() {
        registrationWindow.fillFullRegistrationStep1();
        registrationWindow.clickOnContinueButtonStep1();
        Assert.assertTrue(registrationWindow.checkIfStep2FullRegistrationWindowDisplayed());
    }

    @Test(priority = 4, dependsOnMethods = "fillFirstStepOfFullRegistrationWindow")
    public void fillSecondStepOfFullRegistrationWindow() {
        registrationWindow.fillFullRegistrationStep2();
        registrationWindow.clickOnContinueButtonStep2();
        Assert.assertTrue(registrationWindow.checkIfStep3FullRegistrationWindowDisplayed());
    }

    @Test(priority = 5, dependsOnMethods = "fillSecondStepOfFullRegistrationWindow")
    public void fillThirdStepOfFullRegistrationWindow() {
        registrationWindow.fillFullRegistrationStep3();
        registrationWindow.clickOnContinueButtonStep3();
        Assert.assertTrue(registrationWindow.checkIfStep4FullRegistrationWindowDisplayed());
    }
}
