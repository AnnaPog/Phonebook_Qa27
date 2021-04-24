import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import models.Contact;

public class AddContactTest extends TestBase{

    @BeforeMethod
    public void preconditions(){
        if(isElement(By.cssSelector("[href='/login']"))){
            login2("mon447233@mail.com", "Mon12$447233");
            pause(1000);
        }
    }

    @Test(invocationCount = 3)
    public void addContact(){
        int index = (int)((System.currentTimeMillis()/1000)%3600);
        wd.findElement(By.cssSelector("[href='/add']")).click();
        fillByLocator(By.cssSelector("[placeholder='Name']"), "Lola"+index);
        fillByLocator(By.cssSelector("[placeholder='Last Name']"), "Now"+index);
        fillByLocator(By.cssSelector("[placeholder='Phone']"), "9876"+index);
        fillByLocator(By.cssSelector("[placeholder='email']"), "Lola"+index+"@mail.ru");
        fillByLocator(By.cssSelector("[placeholder='Address']"), "Haifa/"+index);
        fillByLocator(By.cssSelector("[placeholder='description']"), "university friend");

        wd.findElement(By.cssSelector(".add_form__2rsm2 button")).click();
        pause(1500);

    }

    @Test
    public void addContactByModel(){
        int index = (int)((System.currentTimeMillis()/1000)%3600);
        Contact contact = new Contact()
                .withName("Lola"+index)
                .withLastName("Now"+index)
                .withPhone("9876"+index)
                .withEmail("Lola"+index+"@mail.ru")
                .withAddress("Haifa")
                .withDescription("Friend");
        openContactForm();
        fillContactForm(contact);
        saveNewContact();
        pause(1000);

        //Assert.assertTrue(wd.findElement(By.xpath("//h2")).getText().contains(contact.getName()));
        Assert.assertTrue(wd.findElement(By.xpath("//a[@class='active']")).getText().contains("CONTACTS"));
        Assert.assertEquals(takeText(By.xpath("//a[@class='active']")), "CONTACTS");
        Assert.assertFalse(isSaveButtonFromAdd());
    }

    @AfterMethod
    public void postConditions(){
        wd.findElement(By.cssSelector("button")).click();

    }
}
