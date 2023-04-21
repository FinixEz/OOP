import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyIncomeWindow extends JFrame {
    public MyIncome myIncome = new MyIncome(null);
    private JLabel totalIncomeLabel;

    public MyIncomeWindow() {
        // this.myIncome = myIncome;

        setTitle("My Income");
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel();
        totalIncomeLabel = new JLabel("Total Income: ฿" + MyIncome.calculateIncome());
        panel.add(totalIncomeLabel);

        add(panel);
        setVisible(true);
    }
    public static void main(String[] args) {
        new MyIncomeWindow();
    }
}
