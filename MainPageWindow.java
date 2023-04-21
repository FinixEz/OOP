import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPageWindow extends JFrame implements ActionListener {
    private MainPage mainPage;
    private JButton registerButton;
    private JButton checkButton;
    private JButton exitButton;

    private JMenuBar menuBar;
    private JMenu editMenu;
    private JMenuItem showAllUsersItem;
    private JMenuItem myincoMenuItem;

    

    public MainPageWindow() {
        this.mainPage = new MainPage();

        setTitle("Main Menu");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        registerButton = new JButton("Register User");
        checkButton = new JButton("Check User");
        exitButton = new JButton("Exit");

        registerButton.addActionListener(this);
        checkButton.addActionListener(this);
        exitButton.addActionListener(this);

        JPanel panel = new JPanel(new GridLayout(3, 1));
        JPanel registerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel checkPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel exitPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        menuBar = new JMenuBar();
        editMenu = new JMenu("Edit");
        showAllUsersItem = new JMenuItem("Show All Users");
        myincoMenuItem = new JMenuItem("MyIncome");
        myincoMenuItem.addActionListener(this);
        showAllUsersItem.addActionListener(this);

        editMenu.add(myincoMenuItem);
        editMenu.add(showAllUsersItem);
        menuBar.add(editMenu);
        setJMenuBar(menuBar);

        registerPanel.add(registerButton);
        checkPanel.add(checkButton);
        exitPanel.add(exitButton);

        panel.add(registerPanel);
        panel.add(checkPanel);
        panel.add(exitPanel);

        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerButton) {
            new RegisterWindow(mainPage);
        } else if (e.getSource() == checkButton) {
            new CheckIDWindow(mainPage);
        } else if (e.getSource() == exitButton) {
            dispose();
        } else if (e.getSource()== showAllUsersItem) {
            new ShowAllUsersWindow(mainPage);
        } else if (e.getSource()== myincoMenuItem) {
            new MyIncomeWindow();
        }
    }

    public static void main(String[] args) {
        new MainPageWindow();
    }
}
