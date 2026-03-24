package javabasics;

import java.awt.Image; // 1. Nhớ import thêm thư viện này
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ChoosingOption {
    public static void main(String[] args) {
    	ImageIcon originalIcon = new ImageIcon("src/javabasics/1354394.png");
        Image img = originalIcon.getImage();
        Image scaledImg = img.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
        ImageIcon customIcon = new ImageIcon(scaledImg);
        Object[] options = {"I do", "I don't"};

        int choosing = JOptionPane.showOptionDialog(null, 
                "Do you want to change to the first class ticket?", 
                "Confirmation", 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.QUESTION_MESSAGE, 
                customIcon, 
                options, 
                options[0]);

        JOptionPane.showMessageDialog(null, "You've chosen: " 
                + (choosing == JOptionPane.YES_OPTION ? "I do" : "I don't"));

        System.exit(0);
    }
}