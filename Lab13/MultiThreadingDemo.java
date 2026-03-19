package Lab13;

import javax.swing.*;
import java.awt.*;

public class MultiThreadingDemo {

    static JLabel imgLabel;
    static JLabel textLabel;

    static boolean running = false;

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new GridLayout(3, 1));

        // IMAGE PANEL
        JPanel imgContainer = new JPanel(null);
        imgContainer.setBackground(Color.YELLOW);

        imgLabel = new JLabel(new ImageIcon("./Lab13/download.png"));
        imgLabel.setBounds(50, 50, 100, 100);
        imgContainer.add(imgLabel);

        // TEXT PANEL
        JPanel messageContainer = new JPanel(new BorderLayout());
        messageContainer.setBackground(Color.YELLOW);

        textLabel = new JLabel("Welcome", JLabel.CENTER);
        textLabel.setFont(new Font("Arial", Font.BOLD, 30));
        messageContainer.add(textLabel, BorderLayout.CENTER);

        // BUTTON PANEL
        JPanel buttonContainer = new JPanel();
        buttonContainer.setBackground(Color.YELLOW);
        JButton startBtn = new JButton("Start");
        JButton stopBtn = new JButton("Stop");

        buttonContainer.add(startBtn);
        buttonContainer.add(stopBtn);

        frame.add(imgContainer);
        frame.add(messageContainer);
        frame.add(buttonContainer);

        frame.setVisible(true);

        // BUTTON ACTIONS
        startBtn.addActionListener(e -> {
            running = true;
            startAnimation(imgContainer);
            startTextChange();
        });

        stopBtn.addActionListener(e -> running = false);
    }

    // IMAGE ANIMATION THREAD
    static void startAnimation(JPanel container) {

        new Thread(() -> {

            int x = 50, y = 50;
            int step = 5;

            while (running) {

                // RIGHT
                while (x < container.getWidth() - 120 && running) {
                    x += step;
                    updateImage(x, y);
                    sleep();
                }

                // DOWN
                while (y < container.getHeight() - 120 && running) {
                    y += step;
                    updateImage(x, y);
                    sleep();
                }

                // LEFT
                while (x > 0 && running) {
                    x -= step;
                    updateImage(x, y);
                    sleep();
                }

                // UP
                while (y > 0 && running) {
                    y -= step;
                    updateImage(x, y);
                    sleep();
                }
            }

        }).start();
    }

    // TEXT THREAD
    static void startTextChange() {

        String[] msgs = {"Welcome", "Enjoy", "Thanks", "Visit Again"};

        new Thread(() -> {
            int i = 0;

            while (running) {
                int index = i;

                SwingUtilities.invokeLater(() ->
                        textLabel.setText(msgs[index])
                );

                i = (i + 1) % msgs.length;

                try {
                    Thread.sleep(1000); // change every 1 sec
                } catch (Exception e) {}
            }
        }).start();
    }

    // UPDATE IMAGE POSITION (SAFE UI UPDATE)
    static void updateImage(int x, int y) {
        SwingUtilities.invokeLater(() ->
                imgLabel.setBounds(x, y, 100, 100)
        );
    }

    static void sleep() {
        try {
            Thread.sleep(10); // 10 ms gap
        } catch (Exception e) {}
    }
}