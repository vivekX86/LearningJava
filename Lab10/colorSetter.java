package Lab10;

import javax.swing.*;
import java.awt.*;

public class colorSetter {
    public static void main(String[] args){
        JFrame frame = new JFrame("Color Selector");
        frame.setSize(400,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        SpinnerNumberModel rmodel = new SpinnerNumberModel(0, 0, 255, 1);
        SpinnerNumberModel gmodel = new SpinnerNumberModel(0, 0, 255, 1);
        SpinnerNumberModel bmodel = new SpinnerNumberModel(0, 0, 255, 1);

        JLabel r = new JLabel("Red"); r.setForeground(Color.RED);
        JSpinner redVal = new JSpinner(rmodel);
        JLabel g = new JLabel("Green"); g.setForeground(Color.GREEN);
        JSpinner greenVal = new JSpinner(gmodel);
        JLabel b = new JLabel("Blue"); b.setForeground(Color.BLUE);
        JSpinner blueVal = new JSpinner(bmodel);

        JButton show = new JButton("Show Output");

        frame.add(r);
        frame.add(redVal);
        frame.add(g);
        frame.add(greenVal);
        frame.add(b);
        frame.add(blueVal);
        frame.add(show);

        show.addActionListener(e->{
            int red = (int) redVal.getValue();
            int green = (int) greenVal.getValue();
            int blue = (int) blueVal.getValue();
            Color clr = new Color(red,green,blue);
            frame.getContentPane().setBackground(clr);
        });

        frame.setVisible(true);
    }
}
