package application;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    EventFiringWebDriver wd;

    UserHelper user;
    ContactHelper contact;
    String browser;
    JScriptHelper jsHelper;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public ContactHelper getContact() {
        return contact;
    }

    public UserHelper getUser() {
        return user;
    }

    public JScriptHelper executor() {
        return jsHelper;
    }

    public void start() {
        if(browser.equals(BrowserType.CHROME)){
            wd = new EventFiringWebDriver(new ChromeDriver());
        }else if(browser.equals(BrowserType.FIREFOX)){
            wd= new EventFiringWebDriver(new FirefoxDriver());
        }
        wd.register(new ListenerMy());

        wd.get("https://contacts-app.tobbymarshall815.vercel.app/");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        user= new UserHelper(wd);
        contact =new ContactHelper(wd);
        jsHelper = new JScriptHelper(wd);
    }

    public  void stop() {
        wd.quit();
    }
}
