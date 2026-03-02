package Lab10;

import javax.swing.*;
import java.awt.*;

public class regForm {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Registration Form");
        frame.setLayout(new BorderLayout());

        JLabel title = new JLabel("Registration Form", JLabel.CENTER);
//        title.setFont(new Font("",Font.BOLD, 24));
        frame.add(title, BorderLayout.NORTH);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(15,20,15,20)); // padding

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5); // space between components
        gbc.anchor = GridBagConstraints.CENTER;

        // ---- Name ----
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("Name:", JLabel.CENTER), gbc);

        gbc.gridx = 1;
        panel.add(new JTextField(12), gbc);

        // ---- Roll ----
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(new JLabel("Roll No:", JLabel.CENTER), gbc);

        gbc.gridx = 1;
        panel.add(new JTextField(12), gbc);

        // ---- Gender ----
        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(new JLabel("Gender:", JLabel.CENTER), gbc);

        gbc.gridx = 1;
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT,5,0));
        JRadioButton m = new JRadioButton("Male");
        JRadioButton f = new JRadioButton("Female");
        ButtonGroup bg = new ButtonGroup();
        bg.add(m); bg.add(f);
        genderPanel.add(m); genderPanel.add(f);
        panel.add(genderPanel, gbc);

        // ---- TextArea (NO stretching now) ----
        gbc.gridx = 0; gbc.gridy = 3;
        panel.add(new JLabel("Address:", JLabel.CENTER), gbc);

        gbc.gridx = 1;
        JTextArea area = new JTextArea(2,12);
        panel.add(area, gbc);

        // ---- Button ----
        gbc.gridx = 1; gbc.gridy = 4;
        panel.add(new JButton("Submit"), gbc);

        frame.add(panel, BorderLayout.CENTER);

        frame.setSize(350,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}