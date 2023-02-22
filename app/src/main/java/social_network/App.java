package social_network;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import social_network.controllers.Controller;
import social_network.domain.Friendship;
import social_network.domain.Message;
import social_network.domain.User;
import social_network.repo.Repo;
import social_network.repo.RepoDBFriendship;
import social_network.repo.RepoDBMessages;
import social_network.repo.RepoDBUser;
import social_network.service.Service;
import social_network.test.domain.UserTest;
import social_network.test.repo.RepoDBUserTest;
import social_network.test.service.ServiceTest;
import social_network.test.domain.MessageTest;
import social_network.test.domain.FriendshipTest;

import java.io.IOException;

public class App extends Application {
    private static Scene scene = null;
    private static Service service = null;

    public static void main(String[] args) {
        UserTest.test();
        MessageTest.test();
        FriendshipTest.test();
        // RepoDBUserTest.test();
        ServiceTest.test();
        Repo<Long, User> repoUsers = new RepoDBUser("jdbc:postgresql://127.0.0.1:5432/social_network", "postgres",
                "123");
        Repo<Long, Friendship> repoFriendships = new RepoDBFriendship("jdbc:postgresql://127.0.0.1:5432/social_network",
                "postgres", "123");
        Repo<Long, Message> repoMessages = new RepoDBMessages("jdbc:postgresql://127.0.0.1:5432/social_network",
                "postgres", "123");

        App.service = new Service(repoUsers, repoFriendships, repoMessages);

        launch(args);
    }

    public static void setRoot(String fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getClassLoader().getResource(fxml + ".fxml"));

        Parent root = (Parent) loader.load();

        Controller controller = loader.getController();
        controller.setService(service);
        controller.update();

        if (scene == null) {
            scene = new Scene(root);
        } else {
            scene.setRoot(root);
        }

    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        App.setRoot("login");

        primaryStage.setTitle("Social App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
