package Lab10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class calc {
    public static void main(String[] args){
        JFrame frame = new JFrame("Calculator");
        frame.setLayout(new BorderLayout());

        JLabel title = new JLabel("Calculator", JLabel.CENTER);
        frame.add(title, BorderLayout.NORTH);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(15,20,15,20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.anchor = GridBagConstraints.WEST;

        // ---- First Number ----
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("Enter the First Number: "), gbc);

        gbc.gridx = 1;
        JTextField num1 = new JTextField(8);
        panel.add(num1, gbc);

        // ---- Second Number ----
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(new JLabel("Enter the Second Number: "), gbc);

        gbc.gridx = 1;
        JTextField num2 = new JTextField(8);
        panel.add(num2, gbc);

        // ---- Buttons (Top Row) ----
        JButton add = new JButton("Add");
        JButton sub = new JButton("subtract");
        JButton mul = new JButton("multiply");
        JButton reset = new JButton("reset");

        gbc.gridx = 2; gbc.gridy = 0;
        panel.add(add, gbc);

        gbc.gridx = 3; gbc.gridy = 0;
        panel.add(sub, gbc);

        gbc.gridx = 4; gbc.gridy = 0;
        panel.add(mul, gbc);

        // ---- Reset Button (Below subtract) ----
        gbc.gridx = 3; gbc.gridy = 1;
        panel.add(reset, gbc);

        // ---- Result Label + Field ----
        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(new JLabel("result: "), gbc);

        gbc.gridx = 1;
        JTextField ans = new JTextField(10);
        panel.add(ans, gbc);

        // ---- Action Listeners ----
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ans.setText("RESULT: "+(Integer.parseInt(num1.getText())+Integer.parseInt(num2.getText())));
            }
        });

        sub.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ans.setText("RESULT: "+(Integer.parseInt(num1.getText())-Integer.parseInt(num2.getText())));
            }
        });

        mul.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ans.setText("RESULT: "+(Integer.parseInt(num1.getText())*Integer.parseInt(num2.getText())));
            }
        });

        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                num1.setText("");
                num2.setText("");
                ans.setText("");
            }
        });

        frame.add(panel, BorderLayout.CENTER);
        frame.setSize(600,300);
        frame.setVisible(true);
    }
}