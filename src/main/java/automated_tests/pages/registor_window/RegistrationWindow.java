package automated_tests.pages.registor_window;

import automated_tests.browser.Browser;
import automated_tests.configuration.AppConfig;
import automated_tests.pages.base.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class RegistrationWindow extends BasePage {

    WebElement fullRegistrationButton = getBrowser().findElement(By.xpath("//*[@id=\"mat-mdc-dialog-0\"]/div/div/app-app-confirm/div/div[2]/div/app-registration/div/div/div[1]/button[2]/div"));

    public RegistrationWindow(Browser<WebDriver> browser) {
        super(browser, AppConfig.getInstance().getBaseUrl(), false);
        try {
            // Wait for the registration window to be displayed
            getBrowser().untilIsDisplayed(By.className("mat-mdc-dialog-component-host"));
        } catch (NoSuchElementException e) {
            // Throw the NoSuchElementException with a custom message
            throw new NoSuchElementException("Login window is not displayed: " + e.getMessage());
        }
    }

    public void clickOnFullRegistrationButton() {
        try {
            fullRegistrationButton.click();
        } catch (ElementNotInteractableException e) {
            throw new ElementNotInteractableException("Registration button is not clickable: ", e);
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Registration button is not exist: ", e);
        }
    }

    public void clickOnContinueButtonStep1() {
        try {
            WebElement continueButtonStep1 = getBrowser().findElement(By.xpath("//*[@id=\"mat-mdc-dialog-0\"]/div/div/app-app-confirm/div/div[2]/div/app-registration/div/div/div[2]/form/div/div[6]/button"));
            continueButtonStep1.click();
        } catch (ElementNotInteractableException e) {
            throw new ElementNotInteractableException("Continue button is not clickable: ", e);
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Continue button is not exist: ", e);
        }
    }

    public void clickOnContinueButtonStep2() {
        try {
            WebElement continueButtonStep2 = getBrowser().findElement(By.xpath("//*[@id=\"mat-mdc-dialog-0\"]/div/div/app-app-confirm/div/div[2]/div/app-registration/div/div/div[2]/form/div/div[6]/button"));
            continueButtonStep2.click();
        } catch (ElementNotInteractableException e) {
            throw new ElementNotInteractableException("Continue button is not clickable: ", e);
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Continue button is not exist: ", e);
        }
    }

    public void clickOnContinueButtonStep3() {
        try {
            WebElement continueButtonStep3 = getBrowser().findElement(By.xpath("//*[@id=\"mat-mdc-dialog-0\"]/div/div/app-app-confirm/div/div[2]/div/app-registration/div/div/div[2]/form/div/div[8]/button"));
            continueButtonStep3.click();
        } catch (ElementNotInteractableException e) {
            throw new ElementNotInteractableException("Continue button is not clickable: ", e);
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Continue button is not exist: ", e);
        }
    }

    public void clickOnCheckBox() {
        try {
            WebElement checkbox = getBrowser().findElement(By.xpath("//*[@id=\"mat-mdc-dialog-0\"]/div/div/app-app-confirm/div/div[2]/div/app-registration/div/div/div[2]/form/div/div[6]/div/div/div[1]/div/input"));
            checkbox.click();
        } catch (ElementNotInteractableException e) {
            throw new ElementNotInteractableException("Checkbox button is not clickable: ", e);
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Checkbox button is not exist: ", e);
        }
    }

    public boolean checkIfFullRegistrationWindowDisplayed() {
        return getBrowser().untilIsDisplayed(By.className("regSteps"));
    }

    public void fillFullRegistrationStep1() {
        WebElement dropdownGender = getBrowser().findElement(By.xpath("//*[@id=\"mat-mdc-dialog-0\"]/div/div/app-app-confirm/div/div[2]/div/app-registration/div/div/div[2]/form/div/div[2]/div/div/select"));
        WebElement dropdownYears = getBrowser().findElement(By.xpath("//*[@id=\"mat-mdc-dialog-0\"]/div/div/app-app-confirm/div/div[2]/div/app-registration/div/div/div[2]/form/div/div[5]/div/div/div/select[1]"));
        WebElement dropdownMonth = getBrowser().findElement(By.xpath("//*[@id=\"birth-month\"]"));
        WebElement dropdownDays = getBrowser().findElement(By.xpath("//*[@id=\"mat-mdc-dialog-0\"]/div/div/app-app-confirm/div/div[2]/div/app-registration/div/div/div[2]/form/div/div[5]/div/div/div/select[3]"));
        WebElement accountNameInputArea = getBrowser().findElement(By.xpath("//*[@id=\"mat-mdc-dialog-0\"]/div/div/app-app-confirm/div/div[2]/div/app-registration/div/div/div[2]/form/div/div[3]/div/div/input"));
        WebElement accountSurnameInputArea = getBrowser().findElement(By.xpath("//*[@id=\"mat-mdc-dialog-0\"]/div/div/app-app-confirm/div/div[2]/div/app-registration/div/div/div[2]/form/div/div[4]/div/div/input"));

        new Select(dropdownGender).selectByIndex(1);
        accountNameInputArea.sendKeys(AppConfig.getInstance().getName());
        accountSurnameInputArea.sendKeys(AppConfig.getInstance().getSurname());
        new Select(dropdownYears).selectByIndex(12);
        new Select(dropdownMonth).selectByIndex(3);
        new Select(dropdownDays).selectByIndex(16);
    }

    public boolean checkIfStep2FullRegistrationWindowDisplayed() {
        WebElement step = getBrowser().findElement(By.xpath("//*[@id=\"mat-mdc-dialog-0\"]/div/div/app-app-confirm/div/div[2]/div/app-registration/div/div/div[2]/div[2]/a[3]"));
        return step.isDisplayed()
                && "Step 2".equals(step.getText());
    }

    public void fillFullRegistrationStep2() {
        WebElement dropdownCountry = getBrowser().findElement(By.xpath("//*[@id=\"mat-mdc-dialog-0\"]/div/div/app-app-confirm/div/div[2]/div/app-registration/div/div/div[2]/form/div/div[2]/div/div/div/select[1]"));
        WebElement dropdownCity = getBrowser().findElement(By.xpath("//*[@id=\"mat-mdc-dialog-0\"]/div/div/app-app-confirm/div/div[2]/div/app-registration/div/div/div[2]/form/div/div[2]/div/div/div/select[2]"));
        WebElement accountAddressInputArea = getBrowser().findElement(By.xpath("//*[@id=\"mat-mdc-dialog-0\"]/div/div/app-app-confirm/div/div[2]/div/app-registration/div/div/div[2]/form/div/div[3]/div/div/input"));
        WebElement accountDocumentNumberInputArea = getBrowser().findElement(By.xpath("//*[@id=\"mat-mdc-dialog-0\"]/div/div/app-app-confirm/div/div[2]/div/app-registration/div/div/div[2]/form/div/div[4]/div/div/input"));
        WebElement accountPromoCodeInputArea = getBrowser().findElement(By.xpath("//*[@id=\"mat-mdc-dialog-0\"]/div/div/app-app-confirm/div/div[2]/div/app-registration/div/div/div[2]/form/div/div[5]/div/div/input"));

        new Select(dropdownCountry).selectByIndex(11);
        new Select(dropdownCity).selectByIndex(10);
        accountAddressInputArea.sendKeys(AppConfig.getInstance().getAddress());
        accountDocumentNumberInputArea.sendKeys(AppConfig.getInstance().getDocumentNumber());
        accountPromoCodeInputArea.sendKeys(AppConfig.getInstance().getPromoCode());
    }

    public boolean checkIfStep3FullRegistrationWindowDisplayed() {
        WebElement step = getBrowser().findElement(By.xpath("//*[@id=\"mat-mdc-dialog-0\"]/div/div/app-app-confirm/div/div[2]/div/app-registration/div/div/div[2]/div[2]/a[3]"));
        return step.isDisplayed()
                && "Step 3".equals(step.getText());
    }

    public void fillFullRegistrationStep3() {
        WebElement dropdownCurrency = getBrowser().findElement(By.xpath("//*[@id=\"mat-mdc-dialog-0\"]/div/div/app-app-confirm/div/div[2]/div/app-registration/div/div/div[2]/form/div/div[4]/div/div/select"));
        WebElement accountEntryNameInputArea = getBrowser().findElement(By.xpath("//*[@id=\"mat-mdc-dialog-0\"]/div/div/app-app-confirm/div/div[2]/div/app-registration/div/div/div[2]/form/div/div[2]/div/div/input"));
        WebElement accountEmailInputArea = getBrowser().findElement(By.xpath("//*[@id=\"mat-mdc-dialog-0\"]/div/div/app-app-confirm/div/div[2]/div/app-registration/div/div/div[2]/form/div/div[3]/div/div/input"));
        WebElement accountPasswordInputArea = getBrowser().findElement(By.xpath("//*[@id=\"mat-mdc-dialog-0\"]/div/div/app-app-confirm/div/div[2]/div/app-registration/div/div/div[2]/form/div/div[5]/div/div/div[1]/div[1]/div/input"));
        WebElement accountConfirmPasswordInputArea = getBrowser().findElement(By.xpath("//*[@id=\"mat-mdc-dialog-0\"]/div/div/app-app-confirm/div/div[2]/div/app-registration/div/div/div[2]/form/div/div[5]/div/div/div[2]/input"));

        accountEntryNameInputArea.sendKeys(AppConfig.getInstance().getName());
        accountEmailInputArea.sendKeys(AppConfig.getInstance().getEmail());
        new Select(dropdownCurrency).selectByIndex(9);
        accountPasswordInputArea.sendKeys(AppConfig.getInstance().getPassword());
        accountConfirmPasswordInputArea.sendKeys(AppConfig.getInstance().getPassword());
        clickOnCheckBox();
    }

    public boolean checkIfStep4FullRegistrationWindowDisplayed() {
        WebElement step = getBrowser().findElement(By.xpath("//*[@id=\"mat-mdc-dialog-0\"]/div/div/app-app-confirm/div/div[2]/div/app-registration/div/div/div[2]/div[2]/a[3]"));
        return step.isDisplayed()
                && "Step 4".equals(step.getText());
    }
}
