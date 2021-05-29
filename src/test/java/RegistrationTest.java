
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {

    @Test
    public void registrationTest(){

        app.getUser().openLogRegForm();
        int i = (int) ((System.currentTimeMillis()/1000)%3600);
        String email= "Mon"+i+"@mail.com";
        String password="Mon12$"+i;
        System.out.println(email + " " + password);
        app.getUser().fillRegLogForm(new User().withEmail(email).withPassword(password));
        app.getUser().clickRegButton();
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//*[text()='Sign Out']")));


    }
}