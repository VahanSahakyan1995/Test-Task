package automated_tests.pages.login_window;

import automated_tests.browser.Browser;
import automated_tests.configuration.AppConfig;
import automated_tests.pages.base.BasePage;
import automated_tests.pages.registor_window.RegistrationWindow;
import org.openqa.selenium.*;

public class LoginWindow extends BasePage {

    WebElement accountEmailInputArea = getBrowser().findElement(By.xpath("//*[@id=\"mat-mdc-dialog-0\"]/div/div/app-app-confirm/div/div[2]/div/app-login/div/div[2]/form/div[2]/input"));
    WebElement accountPasswordInputArea = getBrowser().findElement(By.xpath("//*[@id=\"mat-mdc-dialog-0\"]/div/div/app-app-confirm/div/div[2]/div/app-login/div/div[2]/form/div[3]/div/input"));

    WebElement entryButton = getBrowser().findElement(By.xpath("//*[@id=\"mat-mdc-dialog-0\"]/div/div/app-app-confirm/div/div[2]/div/app-login/div/div[2]/form/div[6]/button"));
    WebElement errorMessage = getBrowser().findElement(By.className("error_message"));
    WebElement registrationButton = getBrowser().findElement(By.xpath("//*[@id=\"mat-mdc-dialog-0\"]/div/div/app-app-confirm/div/div[2]/div/div/div/a"));


    public LoginWindow(Browser<WebDriver> browser) {
        super(browser, AppConfig.getInstance().getBaseUrl(), false);
        try {
            // Wait for the login window to be displayed
            getBrowser().untilIsDisplayed(By.className("mdc-dialog__container"));
        } catch (NoSuchElementException e) {
            // Throw the NoSuchElementException with a custom message
            throw new NoSuchElementException("Login window is not displayed: " + e.getMessage());
        }
    }

    public void fillLoginWindow() {
        accountEmailInputArea.sendKeys(AppConfig.getInstance().getEmail());
        accountPasswordInputArea.sendKeys(AppConfig.getInstance().getPassword());
    }

    public boolean isEntryButtonClickable() {
        return entryButton.isEnabled() && entryButton.isDisplayed();
    }

    public void clickOnEntryButton() {
        try {
            entryButton.click();
        } catch (ElementNotInteractableException e) {
            throw new ElementNotInteractableException("Entry button is not clickable: ", e);
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Entry button is not exist: ", e);
        }
    }

    public String getErrorMessageText(){
        int maxRetries = 5;
        int retryCount = 0;
        String errorMessageText = null;

        while (retryCount < maxRetries) {
            if (errorMessage.getText() != null && !errorMessage.getText().trim().isEmpty()) {
                errorMessageText = errorMessage.getText();
                break; // Exit the loop if the error message is not null or empty
            } else {
                // Sleep for 1 second before the next retry
                try {
                    sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                retryCount++;
            }
        }

        if (errorMessageText == null || errorMessageText.trim().isEmpty()) {
            throw new IllegalArgumentException("Error Message is null or empty after " + maxRetries + " retries");
        }

        return errorMessageText;
    }

    public RegistrationWindow clickOnRegistrationButton() {
        try {
            registrationButton.click();
            return new RegistrationWindow(getBrowser());
        } catch (ElementNotInteractableException e) {
            throw new ElementNotInteractableException("Entry button is not clickable", e);
        }
    }

}
