//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//public class EditContactTest extends TestBase{
//
//    @BeforeMethod
//    public void preconditions() {
//        if (isElement(By.cssSelector("[href='/login']"))) {
//            login2("mon447233@mail.com", "Mon12$447233");
//        }
//    }
//
//    @Test
//    public void editTest(){
//        wd.findElement(By.xpath("//a[.='CONTACTS']")).click();
//        wd.findElement(By.xpath("//div[@class='contact-item_card__2SOIM']")).click();
//        wd.findElement(By.xpath("//button[text()='Edit']")).click();
//
//        WebElement name = wd.findElement(By.xpath("//input[@placeholder='Name']"));
//        String text2 = wd.findElement(By.xpath("//input[@placeholder='Name']")).getAttribute("value");
//        System.out.println(text2);
//        name.click();
//        name.sendKeys("*");
//        //fillByLocator(By.xpath("//input[@placeholder='Name']"), text2+"*");
//        WebElement lastName = wd.findElement(By.xpath("//input[@placeholder='Last Name']"));
//        edit(lastName);
//        WebElement phone = wd.findElement(By.xpath("//input[@placeholder='Phone']"));
//        edit(phone);
//        WebElement email = wd.findElement(By.xpath("//input[@placeholder='email']"));
//        edit(email);
//        WebElement address = wd.findElement(By.xpath("//input[@placeholder='Address']"));
//        edit(address);
//        WebElement desc = wd.findElement(By.xpath("//input[@placeholder='desc']"));
//        edit(desc);
//        wd.findElement(By.xpath("//button[text()='Save']")).click();
//    }
//
//    @Test
//    public void test(){
//        wd.findElement(By.xpath("//a[.='CONTACTS']")).click();
//        wd.findElement(By.xpath("//div[@class='contact-item_card__2SOIM']")).click();
//        wd.findElement(By.xpath("//button[text()='Edit']")).click();
//        wd.findElement(By.xpath("//input[@placeholder='Address']")).clear();
//        wd.findElement(By.xpath("//input[@placeholder='Address']")).sendKeys("*");
//        pause(6000);
//
//    }
//
//    public void edit(WebElement el){
//        el.click();
//        el.sendKeys("*");
//    }
//}
