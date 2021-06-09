import org.testng.annotations.Test;

public class JScriptLoginTest extends TestBase{

    @Test
    public void executorTest(){
        app.executor().clickByLocator();
        app.executor().typeTextInTextBox();
        app.executor().clickByButton();
        app.getUser().pause(3000);
    }
}