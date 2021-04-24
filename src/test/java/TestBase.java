import models.User;
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
import models.Contact;

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

    public void fillByLocator(By locator, String text){
        WebElement element = wd.findElement(locator);
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

    public boolean isElement(By locator){
        return wd.findElements(locator).size()>0;
    }

    public void login(String email, String pas){
        wd.findElement(By.linkText("LOGIN")).click();
        List<WebElement> inputs = wd.findElements(By.tagName("input"));
        fillByElement(inputs.get(0), email);
        fillByElement(inputs.get(1), pas);

        List<WebElement> buttons = wd.findElements(By.tagName("button"));
        buttons.get(0).click();

        pause(1000);
    }

    public void login2(String email, String password){
        wd.findElement(By.cssSelector("[href='/login']")).click();
        fillByLocator(By.cssSelector("input[placeholder='Email']"), email);
        fillByLocator(By.cssSelector("[placeholder='Password']"), password);
        wd.findElement(By.cssSelector("button:first-of-type")).click();

    }

    public void  openLogRegForm(){
        wd.findElement(By.xpath("//a[.='LOGIN']")).click();
    }

    public void clickLoginButton(){
        wd.findElement(By.xpath("//button[.=' Login']")).click();
    }

    public void fillLogRegForm(User user){
        fillByLocator(By.xpath("//input[@placeholder='Email']"), user.getEmail());
        fillByLocator(By.xpath("//input[@placeholder='Password']"), user.getPassword());
    }
    public String takeText(By locator){
        return wd.findElement(locator).getText();
    }

    public String takeText(WebElement element){
        return element.getText();
    }

    public boolean isLogin(){
        return isElement(By.xpath("//button[.='Sign Out']"));
    }

    public void openContactForm(){
        wd.findElement(By.xpath("//a[@href='/add']")).click();
    }

    public void fillContactForm(Contact contact){
        fillByLocator(By.xpath("//input[@placeholder='Name']"), contact.getName());
        fillByLocator(By.xpath("//input[@placeholder='Last Name']"), contact.getLastName());
        fillByLocator(By.xpath("//div[@class='add_form__2rsm2']/input[3]"), contact.getPhone());
        fillByLocator(By.xpath("//input[@placeholder='email']"), contact.getEmail());
        fillByLocator(By.xpath("//input[@placeholder='Address']"), contact.getAddress());
        fillByLocator(By.xpath("//input[@placeholder='description']"), contact.getDescription());
    }

    public void saveNewContact(){
        wd.findElement(By.xpath("//button/b[.='Save']")).click();
    }

    public boolean isSaveButtonFromAdd() {
        return isElement(By.xpath("//button[.='Save']"));

    }
}
