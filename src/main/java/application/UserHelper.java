package application;

import application.HelperBase;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends HelperBase {


    public UserHelper(WebDriver wd) {
        super(wd);

    }

    public boolean isLogInPresent(){
        return isElementPresent(By.cssSelector("[href='/login']"));
    }

    public void openLogRegForm(){
        click(By.cssSelector("[href='/login']"));
    }

    public void fillRegLogForm(User user){
        type(By.xpath("//input[1]"), user.getEmail());
        type(By.xpath("//input[2]"), user.getPassword());

    }
    public void clickRegButton(){
        click(By.xpath("//*[text()=' Registration']"));
    }

    public void clickLoginButton() {
        click(By.xpath("//button[.=' Login']"));
    }

    public void login(User user) {
        openLogRegForm();
        fillRegLogForm(new User().withEmail("Mon447233@mail.com").withPassword("Mon12$447233"));
        clickLoginButton();
    }

    public boolean isLogined() {
        return isElementPresent((By.xpath("//*[text()='Sign Out']")));

    }
    public void clickOnSingOutButton() {
        click(By.xpath("//*[.='Sign Out']"));
    }
    public boolean isLoginButtonPresent() {
        return isElementPresent(By.xpath("//*[.=' Login']"));
    }
}
