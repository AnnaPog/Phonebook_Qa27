import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogoutTest extends TestBase{

    @BeforeMethod
    public void preconditions(){
        String email = "mon447233@mail.com";
        String pas = "Mon12$447233";
        login(email, pas);
    }

    @Test
    public void ligoutTest(){
        wd.findElement(By.tagName("button")).click();
        pause(1000);

        String text = wd.findElement(By.linkText("LOGIN")).getText();
        Assert.assertEquals(text, "LOGIN");

    }
}
