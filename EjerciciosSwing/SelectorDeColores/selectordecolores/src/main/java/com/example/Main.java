package com.example;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame ventana = new JFrame();
        ventana.setSize(200, 200);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panelBotones = new JPanel();
        JButton botonAzul = new JButton();
        JButton botonRojo = new JButton();
        JButton botonVerde = new JButton();

        JPanel panelColor = new JPanel();
        panelBotones.setBackground(Color.WHITE);


        ventana.add(panelBotones, BorderLayout.NORTH);
        ventana.add(panelColor, BorderLayout.CENTER);
        
        ventana.setVisible(true);
    }
}