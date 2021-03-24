import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class LoginTest extends TestBase {
    @Test
    public void loginTest(){
        wd.findElement(By.linkText("LOGIN")).click();
        List<WebElement> inputs= wd.findElements(By.tagName("input"));
        fillByElement(inputs.get(0), "mon447233@mail.com");
        fillByElement(inputs.get(1), "Mon12$447233");
        pause(7000);

        List<WebElement> buttons = wd.findElements(By.tagName("button"));
        buttons.get(0).click();
        pause(1000);

        String text = wd.findElement(By.tagName("button")).getText();
        Assert.assertEquals(text,"Sign Out");
    }
}
