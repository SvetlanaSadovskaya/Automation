package BaseObjects;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.util.Properties;

import static BaseObjects.DriverCreation.closeDriver;
import static BaseObjects.DriverCreation.getDriver;
import static org.openqa.selenium.remote.BrowserType.CHROME;

public class BaseTest {
        protected WebDriver driver;
        protected ITestContext context;
        private String browserName;
        @BeforeTest
        public void precondition(ITestContext context) {
            BasicConfigurator.configure();
            String log4jConfPath = "src/main/resources/log4j.properties";
            PropertyConfigurator.configure(log4jConfPath);

            this.context = context;
            this.driver = getDriver(CHROME);
            this.browserName = context.getSuite().getParameter("browser") == null ? System.getProperty("browser") : context.getSuite().getParameter("browser");
            this.driver = getDriver(browserName == null ? "CHROME" : browserName);
        }
        @AfterTest
        public void postcondition() {
            closeDriver(CHROME);
            closeDriver(browserName == null ? "CHROME" : browserName);
        }
    }



