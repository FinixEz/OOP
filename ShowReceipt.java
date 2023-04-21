import javax.swing.*;
import java.awt.*;


public class ShowReceipt extends JFrame {
    private User user;
    private double payment;

    public ShowReceipt() {
        user = MainPage.getInstance().getUserList().get(ShowAllUsersWindow.index);
          int temp=0;
        for (User dick : MainPage.getInstance().getUserList()) {
            
            if (ShowAllUsersWindow.index==temp) {
              user = dick;
            }
            temp++;
}
        setTitle("Receipt");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        JLabel nameLabel = new JLabel("Name: " + user.username);
        JLabel typeLabel = new JLabel("Type: " + user.type);
        JLabel hoursLabel = new JLabel("Hours: " + user.hours);

        if (user.getType().equals("Guest")) {
            payment = user.getHours() * 20;
        } else if (user.getType().equals("Member")) {
            payment = user.getHours() * 15;
        }

        JLabel paymentLabel = new JLabel("Payment: ฿ " + payment);

        JPanel panel = new JPanel(new GridLayout(4, 1));
        panel.add(nameLabel);
        panel.add(typeLabel);
        panel.add(hoursLabel);
        panel.add(paymentLabel);

        add(panel);
        setVisible(true);
    }
}
