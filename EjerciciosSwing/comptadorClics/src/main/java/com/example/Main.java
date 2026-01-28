// Contador de Clics
package com.example;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;


public class Main {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Ventana");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(400, 400);
        JButton button = new JButton();
        button.setBackground(Color.RED);
        
        JPanel panel = new JPanel();
        JLabel texto = new JLabel("Tu boton es: ");
        panel.add(new JPanel().add(texto));
        panel.add(new JPanel().add(button));
        texto.setSize(40, 40);
        ventana.add(panel);

        JPanel panelLabel = new JPanel();
        panelLabel.add(new JLabel("Clicks: "));
        int[] contador = {0};  // Declarar antes del ActionListener
        
        ActionListener click = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contador[0]++;
                texto.setText("Clicks: " + contador[0]);
            }
        };
        button.addActionListener(click);
        ventana.setVisible(true);
    }
}