package Lab10;

import javax.swing.*;
import java.awt.*;

public class colorList {
    public static void main(String[] args){
        JFrame frame = new JFrame("My Frame");
        frame.setSize(400,300);
        frame.setLayout(new GridLayout(1,1));

        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 40));

        JList<String> list = new JList<>(new String[]{"White", "Orange", "Red", "Blue"});
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setPreferredSize(new Dimension(100,100));

        JButton button = getJButton(list, centerPanel);

        centerPanel.add(scrollPane);
        centerPanel.add(button);

        frame.add(centerPanel);
        frame.setVisible(true);
    }

    private static JButton getJButton(JList<String> list, JPanel centerPanel) {
        JButton button = new JButton("Click");

        button.addActionListener(e->{
            if(list.getSelectedValue() == "White"){
                centerPanel.setBackground(Color.WHITE);
            } else if (list.getSelectedValue() == "Orange") {
                centerPanel.setBackground(Color.ORANGE);
            } else if (list.getSelectedValue() == "Red") {
                centerPanel.setBackground(Color.RED);
            } else if (list.getSelectedValue() == "Blue") {
                centerPanel.setBackground(Color.BLUE);
            } else {
                centerPanel.setBackground(Color.BLUE);
            }
        });
        return button;
    }
}
