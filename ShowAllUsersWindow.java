import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ShowAllUsersWindow extends JFrame {
    private MainPage mainPage;
    private JTable table;
    private JScrollPane scrollPane;
    public static int index = -1;

    public ShowAllUsersWindow(MainPage mainPage) {
        this.mainPage = mainPage;

        setTitle("All Users");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Create table with columns and data
        String[] columns = {"Username", "User Type", "Hours Played", "Payment"};
        List<User> userList = mainPage.getUserList();
        Object[][] data = new Object[userList.size()][4];
        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            data[i][0] = user.getUsername();
            data[i][1] = user.getType();
            data[i][2] = user.getHours();
            data[i][3] = user.getHours()*(user.getType().equals("Member") ? 15.0 : 20.0)+"฿";
        }

        // Create table model with data and columns
        DefaultTableModel model = new DefaultTableModel(data, columns);

        // Create table with model
        table = new JTable(model);

        // Create scroll pane with table
        scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(800, 600));
        add(scrollPane);

        setVisible(true);
    }
}
