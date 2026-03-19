package Lab12;

import javax.net.ssl.HttpsURLConnection;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Scanner;

public class Random {
    static String quote, author;
    static JPanel container;
    static CardLayout c;
    static JLabel timerDisplay;
    static JButton resetBtn;

    static void loadData() throws Exception{
        URL url = new URL("https://thequoteshub.com/api/");
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        StringBuilder res = new StringBuilder();
        Scanner sc = new Scanner(conn.getInputStream());

        while (sc.hasNext()){
            res.append(sc.nextLine());
        }

        quote = res.substring(res.indexOf("text")+7, res.indexOf("author")-3);
        author = res.substring(res.indexOf("author")+9, res.indexOf("tags")-3);
    }

    static ActionListener menuSwitch = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String menuStr = e.getActionCommand();
            c.show(container, menuStr);   // switch card
        }
    };

    static String formatTime(int ms) {
        int totalSeconds = ms / 1000;
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;
        int milliseconds = ms % 1000;

        return String.format("%02d:%02d:%02d", minutes, seconds, milliseconds);
    }

    static ActionListener timerAction = new ActionListener() {
        int sec = 0;
        Timer timer = new Timer(1, new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                timerDisplay.setText(formatTime(sec));
                sec++;
                formatTime(sec);
            }
        });
        public void actionPerformed(ActionEvent e) {
            String task = e.getActionCommand();
            if (task.equals("Start")){
               timer.start();
               resetBtn.setText("Stop");
            } else if (task.equals("Stop")){
                timer.stop();
                resetBtn.setText("Reset");
            } else{
                timer.stop();
                sec = 0;
                timerDisplay.setText("00:00:00");
            }
        }
    };

    public static void main(String[] args) throws Exception {
        loadData();   // fetch quote
        JFrame frame = new JFrame("Quotes");
        frame.setSize(1280,720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel menu = new JPanel(new FlowLayout());
        menu.setBackground(Color.DARK_GRAY);

        String[] mBtn = {"Quotes", "Timer"};

        for (int i = 0; i < mBtn.length; i++) {
            JButton menuBtn = new JButton(mBtn[i]);
            menuBtn.setActionCommand(mBtn[i]);
            menu.add(menuBtn);
            menuBtn.addActionListener(menuSwitch);
        }

        c = new CardLayout();
        container = new JPanel(c);

        JPanel timerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();
        timerPanel.setBackground(Color.BLACK);

        g.gridx = 0;
        g.gridy = 0;
        g.gridwidth = 2;   // timer spans both buttons
        g.anchor = GridBagConstraints.CENTER;
        g.insets = new Insets(5,5,5,5);

        timerDisplay = new JLabel("00:00:000");
        timerDisplay.setForeground(Color.WHITE);
        timerDisplay.setFont(new Font("Serif", Font.BOLD, 32));
        timerPanel.add(timerDisplay, g);

        JButton startBtn = new JButton("Start");
        resetBtn = new JButton("Reset");

        startBtn.addActionListener(timerAction);
        resetBtn.addActionListener(timerAction);

        g.gridwidth = 1;
        g.gridy = 1;

        g.gridx = 0;
        timerPanel.add(startBtn, g);

        g.gridx = 1;
        timerPanel.add(resetBtn, g);


        JPanel quotePanel = new JPanel(new BorderLayout());
        quotePanel.setBackground(Color.BLACK);
        JLabel label = new JLabel(
                "<html><div style='text-align:center; color:white; width:100%; margin:0px 80px'>"
                        + quote +
                        "<br><br>" + author +
                        "</div></html>"
        );
        quotePanel.add(label);
        label.setFont(new Font("Serif", Font.BOLD, 20));


        container.add(quotePanel, "Quotes");
        container.add(timerPanel, "Timer");


        frame.add(menu, BorderLayout.NORTH);
        frame.add(container, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}