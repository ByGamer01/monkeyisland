package com.example;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        // Crear la ventana principal
        JFrame ventana = new JFrame();
        ventana.setSize(200, 200);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(new BorderLayout()); // Layout que divide en zonas: NORTH, CENTER, SOUTH...

        // Panel superior que contendrá los tres botones de color
        JPanel panelBotones = new JPanel();
        ventana.add(panelBotones, BorderLayout.NORTH);

        // Crear los tres botones (sin texto, solo color de fondo)
        JButton botonAzul = new JButton();
        JButton botonRojo = new JButton();
        JButton botonVerde = new JButton();

        // Configurar el botón rojo: setOpaque permite que se vea el color de fondo
        botonRojo.setOpaque(true);
        botonRojo.setBackground(Color.RED);
        botonRojo.setBorderPainted(true);

        // Configurar el botón azul
        botonAzul.setOpaque(true);
        botonAzul.setBackground(Color.BLUE);
        botonAzul.setBorderPainted(true);

        // Configurar el botón verde
        botonVerde.setOpaque(true);
        botonVerde.setBackground(Color.GREEN);
        botonVerde.setBorderPainted(true);

        // Añadir los botones al panel superior
        panelBotones.add(botonAzul);
        panelBotones.add(botonRojo);
        panelBotones.add(botonVerde);

        // Panel central: este es el que cambiará de color al pulsar los botones
        JPanel panelColor = new JPanel();
        panelBotones.setBackground(Color.WHITE);

        // Colocar cada panel en su zona del BorderLayout
        ventana.add(panelBotones, BorderLayout.NORTH);
        ventana.add(panelColor, BorderLayout.CENTER);

        // Crear un único ActionListener compartido por los tres botones
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // e.getSource() devuelve el botón que se ha pulsado
                if (e.getSource() == botonRojo) {
                    panelColor.setBackground(Color.RED);
                } else if (e.getSource() == botonAzul) {
                    panelColor.setBackground(Color.BLUE);
                } else if (e.getSource() == botonVerde) {
                    panelColor.setBackground(Color.GREEN);
                }
            }
        };

        // Conectar el listener a cada botón para que reaccionen al clic
        botonRojo.addActionListener(actionListener);
        botonAzul.addActionListener(actionListener);
        botonVerde.addActionListener(actionListener);

        // Hacer visible la ventana (siempre al final, después de añadir todo)
        ventana.setVisible(true);
    }
}