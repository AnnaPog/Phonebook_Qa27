import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.nio.file.WatchEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver wd;

    @BeforeSuite
    public void init(){
        wd= new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/");
    }

    @AfterSuite
    public void tearDown(){
        wd.quit();
    }

    public void fillByElement(WebElement element, String text){
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    public void pause (int millis){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public void login(String email, String pas){
        wd.findElement(By.linkText("LOGIN")).click();
        List<WebElement> inputs = wd.findElements(By.tagName("input"));
        fillByElement(inputs.get(0), email);
        fillByElement(inputs.get(1), pas);

        List<WebElement> buttons = wd.findElements(By.tagName("button"));
        buttons.get(0).click();

        pause(1000);
        String text = wd.findElement(By.tagName("button")).getText();
        Assert.assertEquals(text, "Sign Out");
    }
}
