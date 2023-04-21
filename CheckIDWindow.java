import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckIDWindow extends JFrame implements ActionListener {
    private MainPage mainPage;
    private JLabel checkLabel;
    private JTextField checkTextField;
    private JButton checkButton;
    private JButton returnButton;

    public CheckIDWindow(MainPage mainPage) {
        this.mainPage = mainPage;

        setTitle("Check User");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        checkLabel = new JLabel("Enter Username:");
        checkTextField = new JTextField(5);
        checkButton = new JButton("Check");
        returnButton = new JButton("Return to Main Menu");

        checkButton.addActionListener(this);
        returnButton.addActionListener(this);

        JPanel panel = new JPanel(new GridLayout(2, 1));
        JPanel checkPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel returnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        checkPanel.add(checkLabel);
        checkPanel.add(checkTextField);
        checkPanel.add(checkButton);

        returnPanel.add(returnButton);

        panel.add(checkPanel);
        panel.add(returnPanel);

        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == checkButton) {
            if (mainPage == null) {
                JOptionPane.showMessageDialog(this, "MainPage is null.");
                return;
            }

            String username = checkTextField.getText();
            String result = mainPage.checkUser(username);
            JOptionPane.showMessageDialog(this, result);
            checkTextField.setText("");
        } else if (e.getSource() == returnButton) {
            dispose();
            // new MainPageWindow(mainPage);
        }
    }

    public static void main(String[] args) {
        new CheckIDWindow(null);
    }
}
