import java.util.ArrayList;

public class MainPage {
    private static MainPage instance;
    public static ArrayList<User> userList;

    public MainPage() {
        userList = new ArrayList<>();
        userList.add(new User("Test", "Guest", 2.0));
        userList.add(new User("Nix", "Member", 3.0));
        userList.add(new User("Rick", "Member", 9.0));
    }

    public static MainPage getInstance() {
        if (instance == null) {
            instance = new MainPage();
        }
        return instance;
    }

    public boolean registerUser(User user) {
        for (User u : userList) {
            if (u.getUsername().equals(user.getUsername())) {
                return false;
            }
        }
        userList.add(user);
        return true;
    }

    public String checkUser(String username) {
        for (User u : userList) {
            if (u.getUsername().equals(username)) {
                return String.format("Name: %s\nType: %s\nHours: %.2f", u.getUsername(), u.getType(), u.getHours());
            }
        }
        return "User not found.";
    }

    public ArrayList<User> getUserList() {
        return userList;
    }
}
