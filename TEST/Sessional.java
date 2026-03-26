package TEST;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Sessional {
    static JTextField display, in1, in2;
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setSize(500, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();
        g.insets = new Insets(8, 8, 8, 8);
        g.fill = GridBagConstraints.HORIZONTAL;

        Font inputFont = new Font("Arial", Font.PLAIN, 20);
        Font btnFont = new Font("Arial", Font.BOLD, 18);
        Font labelFont = new Font("Arial", Font.BOLD, 20);

        display = new JTextField();
        display.setEditable(false);
        display.setFont(inputFont);
        display.setPreferredSize(new Dimension(400, 45));
        in1 = new JTextField();
        in1.setFont(inputFont);
        in1.setPreferredSize(new Dimension(300, 40));
        in2 = new JTextField();
        in2.setFont(inputFont);
        in2.setPreferredSize(new Dimension(300, 40));

        g.gridx = 0; g.gridy = 0; g.gridwidth = 2;
        frame.add(display, g);
        g.gridwidth = 1;

        JLabel l1 = new JLabel("X:");
        l1.setFont(labelFont);
        JLabel l2 = new JLabel("Y:");
        l2.setFont(labelFont);

        g.gridx = 0; g.gridy = 1;
        frame.add(l1, g);
        g.gridx = 1;
        frame.add(in1, g);
        g.gridx = 0; g.gridy = 2;
        frame.add(l2, g);
        g.gridx = 1;
        frame.add(in2, g);

        JLabel nameLabel = new JLabel("Name: Vivek  |  Roll: 123456");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        g.gridx = 0; g.gridy = 6; g.gridwidth = 2;
        frame.add(nameLabel, g);

        String[][] grid = {{"Square", "Square Root"}, {"Modulus", "Power"}};
        for (int row = 0; row < 2; row++) {
            for (int col = 0; col < 2; col++) {
                JButton btn = new JButton(grid[row][col]);
                btn.setFont(btnFont);
                btn.setPreferredSize(new Dimension(180, 50));
                g.gridx = col; g.gridy = 3 + row; g.gridwidth = 1;
                frame.add(btn, g);
                btn.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        calculate(e.getActionCommand());
                    }
                });
            }
        }

        JButton logBtn = new JButton("Log");
        logBtn.setFont(btnFont);
        logBtn.setPreferredSize(new Dimension(180, 50));
        g.gridx = 0; g.gridy = 5; g.gridwidth = 2;
        frame.add(logBtn, g);
        logBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculate("Log");
            }
        });

        frame.setVisible(true);
    }
    static void calculate(String operation) {
        display.setText("Processing...");
        Thread t = new Thread(new Runnable() {
            public void run() {
                try {
                    double x = Double.parseDouble(in1.getText());
                    double y;
                    if (in2.getText().isEmpty()) {
                        y = 0;
                    } else {
                        y = Double.parseDouble(in2.getText());
                    }
                    double result = 0;
                    Thread.sleep(1000);
                    switch (operation) {
                        case "Square":      result = x * x; break;
                        case "Square Root": result = Math.sqrt(x); break;
                        case "Modulus":     result = x % y; break;
                        case "Power":       result = Math.pow(x, y); break;
                        case "Log":         result = Math.log(x); break;
                    }
                    final double ans = result;
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            display.setText(String.valueOf(ans));
                        }
                    });
                } catch (Exception ex) {
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            display.setText("EXCEPTION OCCURRED");
                        }
                    });
                }
            }
        });
        t.start();
    }
}