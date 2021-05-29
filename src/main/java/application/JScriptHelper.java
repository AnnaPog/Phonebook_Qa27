package application;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JScriptHelper extends HelperBase{
    public JScriptHelper(WebDriver wd) {
        super(wd);
    }

    JavascriptExecutor js = (JavascriptExecutor) wd;

    public void clickByLocator() {
        js.executeScript("document.querySelector('a[href*=login]').click();");

    }

    public void typeTextInTextBox() {
        js.executeScript("document.querySelector('input[placeholder=\"Email\"]').value='Mon447233@mail.com';");
        js.executeScript("document.querySelector('input[placeholder=\"Password\"]').value='Mon12$447233';");

    }

    public void clickByButton(){
        js.executeScript("document.querySelector('button').click();");
    }
}
