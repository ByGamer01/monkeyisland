package com.example;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JLabel label = new JLabel("Hola mundo");
        frame.getContentPane().add(label);
        frame.pack();
        frame.setLocationRelativeTo(label);
        frame.setVisible(true);

    }
}