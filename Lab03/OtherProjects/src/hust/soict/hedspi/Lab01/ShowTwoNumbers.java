package Lab01;
import javax.swing.JOptionPane;
public class ShowTwoNumbers {
    public static void main(String[] args) {
        String strNum1,strNum2;
        String noti="You've just entered: ";
        strNum1=JOptionPane.showInputDialog(null,"Input the first number");
        strNum2=JOptionPane.showInputDialog(null,"Input the second number");
        noti=noti+strNum1+" and "+strNum2;
        JOptionPane.showMessageDialog(null,noti,"Show two numbers",JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
