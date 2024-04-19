package automated_tests.configuration;

import lombok.extern.log4j.Log4j2;

        import java.io.IOException;
        import java.io.InputStream;
        import java.util.Properties;

@Log4j2
public final class AppConfig {

    private String driverUrl;

    private String baseUrl;

    private String accountEmail;

    private String accountPassword;

    private String accountName;

    private String accountSurname;

    private String accountAddress;

    private String accountDocumentNumber;

    private String accountPromoCode;

    private boolean headless;

    private long implicitTime;

    private long explicitTime;

    private long pageLoadTime;

    private long scriptTime;

    private static AppConfig instance;

    public static synchronized AppConfig getInstance() {
        if (instance == null) {
            instance = new AppConfig();
        }
        return instance;
    }

    private AppConfig() {
        load();
    }

    private void load() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(getConfigName())) {
            Properties prop = new Properties();
            prop.load(input);
            this.accountEmail = prop.getProperty("account.email");
            this.accountPassword = prop.getProperty("account.password");
            this.accountName = prop.getProperty("account.name");
            this.accountSurname = prop.getProperty("account.surname");
            this.accountAddress = prop.getProperty("account.address");
            this.accountDocumentNumber = prop.getProperty("account.document.number");
            this.accountPromoCode = prop.getProperty("account.promo.code");
            this.driverUrl = prop.getProperty("webdriver.path");
            this.baseUrl = prop.getProperty("craftbet.base.url");
            this.headless = Boolean.parseBoolean(prop.getProperty("webdriver.headless"));
            this.implicitTime = Long.parseLong(prop.getProperty("implicit.wait.time"));
            this.explicitTime = Long.parseLong(prop.getProperty("explicit.wait.time"));
            this.pageLoadTime = Long.parseLong(prop.getProperty("page.load.time"));
            this.scriptTime = Long.parseLong(prop.getProperty("script.time"));
        } catch (IOException ex) {
            log.error("Can not load properties");
        }
    }

    private String getConfigName() {
        String activeProfile = System.getProperty("spring.profiles.active");
        String configName = "application";
        if (activeProfile != null) {
            configName += "-" + activeProfile;
        }
        return configName + ".properties";
    }

    public String getDriverUrl() {
        return driverUrl;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public boolean isHeadless() {
        return headless;
    }

    public String getEmail() {
        return accountEmail;
    }

    public String getPassword() {
        return accountPassword;
    }

    public String getName() {
        return accountName;
    }

    public String getSurname() {
        return accountSurname;
    }

    public String getAddress() {
        return accountAddress;
    }

    public String getDocumentNumber() {
        return accountDocumentNumber;
    }

    public String getPromoCode() {
        return accountPromoCode;
    }

    public long getImplicitTime() {
        return implicitTime;
    }

    public long getExplicitTime() { return explicitTime; }

    public long getPageLoadTime() {
        return pageLoadTime;
    }

    public long getScriptTime() {
        return scriptTime;
    }
}