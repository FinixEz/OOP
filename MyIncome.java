import java.util.List;

public class MyIncome {
    // private static List<User> userList;

    public MyIncome(List<User> userList) {
        // this.userList = userList;
    }

    public static double calculateIncome() {
        double totalIncome = 0.0;

        for (User user : MainPage.userList) {
            double hourlyRate = user.getType().equals("Member") ? 15.0 : 20.0;
            totalIncome += user.getHours() * hourlyRate;
        }

        return totalIncome;
    }
}
