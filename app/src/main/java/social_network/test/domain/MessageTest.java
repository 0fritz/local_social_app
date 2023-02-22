package social_network.test.domain;

import social_network.domain.Message;
import social_network.domain.User;
import social_network.test.MyAssert;
import java.time.LocalDateTime;

public class MessageTest {
    public static void test() {
        LocalDateTime x = LocalDateTime.now();
        User a = new User("Salut","John","john@yahoo.com",0L,"123");
        User b = new User("Buna","John","12john@yahoo.com",1L,"123");
        Message u = new Message(0L,1L,x,"test");
        MyAssert.asserto(u.getId1().equals(0L));
        MyAssert.asserto(u.getId2().equals(1L));
        MyAssert.asserto(u.getSent_at().equals(x));
        MyAssert.asserto(u.getContent().equals("test"));
        u.setContent("new-test");
        MyAssert.asserto(u.getContent().equals("new-test"));
        System.out.println("Message tested succesfully");
    }
}
