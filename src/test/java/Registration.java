import org.testng.annotations.Test;

public class Registration extends TestBase{

    @Test
    public void registrationTest(){
        //email =""
        //pass=""
        int index = (int)((System.currentTimeMillis()/1000)%3600);
    String email = "Tom"+index+"@gmail.com";
    String password = "Tom$"+index;

    }
}
