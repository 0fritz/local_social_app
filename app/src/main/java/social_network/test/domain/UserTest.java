package social_network.test.domain;

import social_network.domain.User;
import social_network.test.MyAssert;

public class UserTest {
    public static void test() {
        User u = new User("SAlut","John","mr.john@yahoo.com",0L,"123");
        MyAssert.asserto(u.getFirstName().equals("SAlut"));
        MyAssert.asserto(u.getLastName().equals("John"));
        MyAssert.asserto(u.getEmail().equals("mr.john@yahoo.com"));
        MyAssert.asserto(u.getId().equals(0L));
        MyAssert.asserto(u.getPassword().equals("123"));
        u.setFirstName("SAlut2");
        MyAssert.asserto(u.getFirstName().equals("SAlut2"));
        u.setLastName("John2");
        MyAssert.asserto(u.getLastName().equals("John2"));
        u.setPassword("1234");
        MyAssert.asserto(u.getPassword().equals("1234"));
        u.setEmail("mr.john2@yahoo.com");
        MyAssert.asserto(u.getEmail().equals("mr.john2@yahoo.com"));


        //pt toti setteri
        System.out.println("User tested succesfully");
    }
}
