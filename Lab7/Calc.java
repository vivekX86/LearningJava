package Lab10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calc {
    public static void main(String[] args){
        JFrame frame = new JFrame();
        frame.setTitle("Login");
        frame.setSize(600,400);
        frame.setLayout(new GridLayout(0,2));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(new JLabel("Enter the first Number:"));
        frame.add(new JTextField());

        frame.add(new JLabel("Enter the Second Number:"));
        frame.add(new JTextField());

        frame.add(new JLabel("Result:"));
        frame.add(new JLabel(""));

        frame.add(new JLabel());
        frame.add(new JButton("Add"));

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
