import java.util.ArrayList;
import java.util.List;

public class ChatMediatorImpl implements ChatMediator {
    private List<User> users;

    public ChatMediatorImpl() {
        this.users = new ArrayList<>();
    }

    @Override
    public void addUser(User user) {
        this.users.add(user);
    }

    @Override
    public void sendMessage(String msg, User user, String recipient) {
        for (User u : users) {
            if (u.getName().equals(recipient)) {
                u.receive(msg, user.getName());
            }
        }
    }

    public List<User> getUsers() {
        return users;
    }
}
