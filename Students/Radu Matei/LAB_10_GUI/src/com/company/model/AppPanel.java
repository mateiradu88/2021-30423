package com.company.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppPanel {

    public Integer count;

    public AppPanel() {
        this.count = 0;
    }

    private void updateCountLabel(JLabel counterLabel){
        counterLabel.setText(count.toString());
    }


    public void startApp(){
        JFrame frame = new JFrame ("Simple Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

        JLabel counterLabel = new JLabel(count.toString());
        counterLabel.setFont(new Font("Tahoma",Font.BOLD,50));
        panel1.add(counterLabel);
        panel1.setLayout(new FlowLayout());

        JButton subtractButton = new JButton("-");
        JButton resetButton = new JButton("0");
        JButton addButton = new JButton("+");

        panel2.add(subtractButton);
        panel2.add(resetButton);
        panel2.add(addButton);

        JPanel p = new JPanel();
        p.add(panel1);
        p.add(panel2);
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));

        frame.setContentPane(p);
        frame.setVisible(true);




        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ++count;
                updateCountLabel(counterLabel);
            }
        });

        subtractButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                --count;
                updateCountLabel(counterLabel);
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count = 0;
                updateCountLabel(counterLabel);
            }
        });




    }

}
