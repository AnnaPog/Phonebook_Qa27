import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class RemoveContact extends TestBase {

    @BeforeMethod
    public void preconditions() {
        if (isElement(By.cssSelector("[href='/login']"))) {
            login2("mon447233@mail.com", "Mon12$447233");
        }
        }

        @Test
        public void removeOneContact() {
            wd.findElement(By.cssSelector("[href='/contacts']")).click();
            WebElement contact = wd.findElement(By.cssSelector(".contact-item_card__2SOIM"));
            contact.click();
            WebElement removeBtn = wd.findElement(By.cssSelector(".contact-item-detailed_card__50dTS button:last-of-type"));
            removeBtn.click();

        }

        @Test
        public void removeAllContact() {
        wd.findElement(By.cssSelector("[href='/login']")).click();
            List<WebElement> contacts = wd.findElements(By.cssSelector(".contact-item_card__2SOIM"));
           // WebElement removeBtn = wd.findElement(By.cssSelector(".contact-item-detailed_card__50dTS button:last-of-type"));

            for (int i = 0; i<contacts.size(); i++){
                wd.findElement(By.cssSelector(".contact-item_card__2SOIM")).click();
                wd.findElement(By.cssSelector(".contact-item-detailed_card__50dTS button:last-of-type")).click();
                pause(1000);
            }
//            for (WebElement el: contacts){
//                el.click();
//                pause(3000);
//                removeBtn.click();
//                pause(3000);
//            }


        }

        @AfterMethod
        public void postConditions() {
        wd.findElement(By.cssSelector(".navbar-logged_nav__2Hx7M button")).click();

        }
    }
