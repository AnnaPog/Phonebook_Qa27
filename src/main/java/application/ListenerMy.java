package application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ListenerMy extends AbstractWebDriverEventListener {

    public ListenerMy() {
        super();
    }
    Logger logger = LoggerFactory.getLogger(ListenerMy.class);
    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {
        super.beforeNavigateTo(url, driver);
        logger.info("Start on -->" +url);
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        super.beforeFindBy(by, element, driver);
        logger.info("Start search -->" + by);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        super.afterFindBy(by, element, driver);
        logger.info("Found -->" +by);
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        super.beforeClickOn(element, driver);
        logger.info("Click on --> "+ element);
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        super.onException(throwable, driver);
        logger.info("We have a throwable --> " +throwable.getMessage());
        int i=(int) (System.currentTimeMillis()/1000)%3600;
        String screenshot="src/test/screenshots/screenshot-"+i +".png";
        HelperBase helperBase =new HelperBase(driver);
        helperBase.takeScreenshot(screenshot);
        logger.info("Screenshot with throwable -->" +screenshot);

    }



    @Override
    public void afterGetText(WebElement element, WebDriver driver, String text) {
        super.afterGetText(element, driver, text);
        logger.info("We take a text -->" +text);
    }
}
