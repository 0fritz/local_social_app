package social_network.test.domain;

import social_network.domain.Friendship;
import social_network.domain.User;
import social_network.test.MyAssert;
import java.time.LocalDateTime;

public class FriendshipTest {
    public static void test() {
        User a = new User("Salut","John","john@yahoo.com",0L,"123");
        User b = new User("Buna","John","12john@yahoo.com",1L,"123");
        Friendship x = new Friendship(0L,1L);

        MyAssert.asserto(x.getFriendsFrom() != null);
        MyAssert.asserto(x.getId1().equals(0L));
        MyAssert.asserto(x.getId2().equals(1L));
        MyAssert.asserto(x.getStatus() != null);

        LocalDateTime Y = LocalDateTime.now();
        x.setFriendsFrom(Y);
        x.setStatus("friends");
        MyAssert.asserto(x.getStatus().equals("friends"));
        MyAssert.asserto(x.getFriendsFrom().equals(Y));

        System.out.println("Friendship tested succesfully");
        
    }
}
