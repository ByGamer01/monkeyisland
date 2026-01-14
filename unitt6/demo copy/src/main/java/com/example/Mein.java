package com.example;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Mein {
    public static void mein(String[] args) {

        JFrame finestra = new JFrame();
        finestra.setSize(400, 200);
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        finestra.setLayout(new FlowLayout());

        JButton botObrir = new JButton("Obrir Dialog");
        finestra.add(botObrir);

        botObrir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarDialeg(finestra);
            }
        });


        // Fem visible la pestalla principal
        finestra.setVisible(true);

    }
}