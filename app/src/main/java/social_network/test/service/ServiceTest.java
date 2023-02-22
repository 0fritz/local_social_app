package social_network.test.service;

import social_network.domain.User;
import social_network.domain.Friendship;
import social_network.domain.Message;
import social_network.repo.Repo;
import social_network.repo.RepoMemory;
import social_network.service.Service;
import social_network.test.MyAssert;

public class ServiceTest {
    public static void test() {
        RepoMemory<Long, User> repoUser = new RepoMemory<>();
        RepoMemory<Long, Message> repoMessages = new RepoMemory<>();
        RepoMemory<Long, Friendship> repoFriendship = new RepoMemory<>();

        Service service = new Service(repoUser, repoFriendship, repoMessages);
        MyAssert.asserto(service.getAllUsers().iterator().hasNext() == false);
        
        service.addUser("SALUT","John","mrs.john@yahoo.com",8L,"123");
        MyAssert.asserto(service.getUser(8L) != null);
        service.deleteUser(8l);
        MyAssert.asserto(service.getUser(8L) == null);
        
        User a = new User("Salut","John","john@yahoo.com",0L,"123");
        User b = new User("Buna","John","12john@yahoo.com",1L,"123");
        
        // Friendship x = new Friendship(0L,1L);
        service.sendFriendRequest(0L,1L);
        service.acceptFriendRequest(1L,0L);
        MyAssert.asserto(service.getFriendshipBetween(0L,1L) != null);
        service.deleteFriendship(0L,1L);
        MyAssert.asserto(service.getFriendshipBetween(0L,1L) == null);
        
        System.out.println("Service tested succesfully");

    }
}
