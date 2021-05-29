import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTest extends TestBase {

    @BeforeMethod (alwaysRun = true)
    public void ensurePrecondition() {
        if (!app.getUser().isLogined()) {
            app.getUser().login(new User().withEmail("Mon447233@mail.com").withPassword("Mon12$447233"));
        }
    }




    @Test
    public void addContactTestRest() {
        app.getContact().clickContactButton();
        int contactSize = app.getContact().getContactSize();
        if(contactSize >= 2){
            app.getContact().clearContacts();

        }



        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String name = "Lola" + i;
        String lastName = "Doe" + i;
        String email = "lola" + i + "@mail.com";
        String phone = "9778111" + i;
        String address = "Tel Aviv"+i;
        String desc = "My new contact";

        Contact contact =Contact.builder()
                .name(name)
                .lastName(lastName)
                .email(email)
                .phone(phone)
                .address(address)
                .description(desc).build();

        app.getContact().clickAddButton();
//        app.getContact().fillContactForm(new Contact().withName(name).withLastName(lastName)
//         .withEmail(email).withPhone(phone).withAddress(address).withDescription(desc));
        app.getContact().clickSaveBatton();
        Assert.assertTrue(app.getContact().isNameExist(name));

    }

    @Test (groups = {"web","rest"},priority = 1)
    public void addContactTestWeb() throws InterruptedException {
        app.getContact().clickContactButton();
        int contactSize = app.getContact().getContactSize();
        if(contactSize >= 2){

            app.getContact().clearContactsWeb();
        }
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String name = "Lola" + i;
        String lastName = "Doe" + i;
        String email = "lola" + i + "@mail.com";
        String phone = "9778111" + i;
        String address = "Tel Aviv"+i;
        String desc = "My new contact";

        // Contact contact = new Contact().withEmail("jh").withPhone("9888").withAddress("uivuh");

        Contact contact =Contact.builder()
                .name(name)
                .lastName(lastName)
                .email(email)
                .phone(phone)
                .address(address)
                .description(desc).build();


        app.getContact().clickAddButton();
        app.getContact().fillContactForm(contact);
//                new Contact().withName(name).withLastName(lastName)
//                .withEmail(email).withPhone(phone).withAddress(address).withDescription(desc)





        app.getContact().clickSaveBatton();

        Assert.assertTrue(app.getContact().isNameExist(name));

    }


}