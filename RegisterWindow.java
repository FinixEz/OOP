import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterWindow extends JFrame implements ActionListener {
    private MainPage mainPage;
    private JLabel usernameLabel;
    private JLabel userTypeLabel;
    private JLabel playTimeLabel;
    private JTextField usernameTextField;
    private JComboBox<String> userTypeComboBox;
    private JTextField playTimeTextField;
    private JButton registerButton;
    private JButton returnButton;

    public RegisterWindow(MainPage mainPage) {
        this.mainPage = mainPage;

        setTitle("Register User");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        usernameLabel = new JLabel("Username:");
        userTypeLabel = new JLabel("User Type:");
        playTimeLabel = new JLabel("Play Time (hours):");
        usernameTextField = new JTextField(10);
        userTypeComboBox = new JComboBox<>(new String[] {"Guest", "Member"});
        playTimeTextField = new JTextField(5);
        registerButton = new JButton("Register");
        returnButton = new JButton("Return to Main Menu");

        registerButton.addActionListener(this);
        returnButton.addActionListener(this);

        JPanel panel = new JPanel(new GridLayout(4, 1));
        JPanel usernamePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel userTypePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel playTimePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        usernamePanel.add(usernameLabel);
        usernamePanel.add(usernameTextField);

        userTypePanel.add(userTypeLabel);
        userTypePanel.add(userTypeComboBox);

        playTimePanel.add(playTimeLabel);
        playTimePanel.add(playTimeTextField);

        buttonPanel.add(registerButton);
        buttonPanel.add(returnButton);

        panel.add(usernamePanel);
        panel.add(userTypePanel);
        panel.add(playTimePanel);
        panel.add(buttonPanel);

        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerButton) {
            String username = usernameTextField.getText();
            String userType = (String) userTypeComboBox.getSelectedItem();
            Double getHours = Double.parseDouble(playTimeTextField.getText());

            User newUser = new User(username, userType, getHours);
            // MainPage.userList.add(newUser);
            boolean success = mainPage.registerUser(newUser);

            if (success) {
                JOptionPane.showMessageDialog(this, "User successfully registered.");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Username already exists. Please choose a different username.");
                usernameTextField.setText("");
                userTypeComboBox.setSelectedIndex(0);
                playTimeTextField.setText("");
            }

        } else if (e.getSource() == returnButton) {
            dispose();
            // new MainPageWindow();
        }
    }
    public static void main(String[] args) {
        new RegisterWindow(null);
    }
}
