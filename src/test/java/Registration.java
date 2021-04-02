import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Registration extends TestBase{

    @Test
    public void registrationTest(){
        int index = (int)((System.currentTimeMillis()/1000)%3600);
        String email = "Tom"+index+"@gmail.com";
        String password = "Tom$"+index;

        wd.findElement(By.linkText("LOGIN")).click();
        List<WebElement> inputs = wd.findElements(By.tagName("input"));
        fillByElement(inputs.get(0), email);
        fillByElement(inputs.get(1), password);

        List<WebElement> buttons = wd.findElements(By.tagName("button"));
        buttons.get(1).click();
        pause(1000);

        String text = wd.findElement(By.tagName("button")).getText();
        Assert.assertEquals(text, "Sign Out");

    }
}
