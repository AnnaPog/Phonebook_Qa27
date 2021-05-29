import application.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class TestBase {


    ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod
    public void startLogger(Method m){
        logger.info(("start test "+m.getName()));

    }

    @AfterMethod(alwaysRun = true)
    public void endLogger(Method m){
        logger.info("End of test "+m.getName());
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        app.start();
    }

    @AfterMethod (alwaysRun = true)
    public void tearDown() {
        app.stop();
    }

}
