package social_network.test.repo;

import social_network.repo.RepoDBUser;
import social_network.test.MyAssert;
import social_network.domain.User;

public class RepoDBUserTest {
    public static void test() {
        RepoDBUser repoUsers = new RepoDBUser("jdbc:postgresql://127.0.0.1:5432/social_network", "postgres",
                "123");

        User u = new User("SAlut","John","mr.john@yahoo.com",0L,"123");
        repoUsers.add(u);

        User found = null;
        for (User v : repoUsers.findAll()) {
            if (v.getEmail().equals(u.getEmail()))
                    found = v;
        }
        //MyAssert.asserto(found != null);

        repoUsers.delete(u.getId());

        User found2 = null;
        for (User v : repoUsers.findAll()) {
            if (v.getEmail().equals(u.getEmail()))
                    found2 = v;
        }
        //MyAssert.asserto(found2 == null);
    }
}
