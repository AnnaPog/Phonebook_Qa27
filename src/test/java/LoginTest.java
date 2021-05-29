
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoginTest extends TestBase {

    @Test
    public void loginTest() {
        app.getUser().openLogRegForm();
        app.getUser().fillRegLogForm(new User().withEmail("Mon447233@mail.com").withPassword("Mon12$447233"));
        app.getUser().clickLoginButton();
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//*[text()='Sign Out']")));
    }

    @DataProvider
    public Iterator<Object[]> dataFile() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/data.csv")));
        String line = reader.readLine();

        while (line != null) {
            String[] split = line.split(";");
            list.add(new Object[]{new User().withEmail(split[0]).withPassword(split[1])});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @Test (dataProvider = "dataFile")
    public void loginTestFromFile(User user) {
        app.getUser().openLogRegForm();
        app.getUser().fillRegLogForm(user);
        app.getUser().clickLoginButton();
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//*[text()='Sign Out']")));
    }

    @AfterMethod
    public void postConditions(){
        app.getUser().isLogined();
    }


}