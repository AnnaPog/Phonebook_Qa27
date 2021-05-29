import models.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContact extends TestBase {
    @BeforeMethod
    public void preConditions() {
        if (!app.getUser().isLogined()) {
            app.getUser().login(new User().withEmail("Mon447233@mail.com").withPassword("Mon12$447233"));
        }

    }

    @Test
    public void removeAllContactTest() {
        app.getContact().openListContacts();
        app.getContact().removeAllContacts();
        app.getContact().pause(500);

    }
    @Test(enabled = false)
    public void removeAllContactTestNON() {
        app.getContact().openListContacts();
        app.getContact().removeVarNotWork();
    }


    @Test
    public void removeOneContactTest() {
        app.getContact().openListContacts();
        app.getContact().removeOneContact();

    }

}
