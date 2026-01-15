package com.example;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        JFrame finestra = new JFrame("Exemple de LayaoutManager"); // La ventana principal
        finestra.setSize(500, 300);
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        finestra.setLayout(new BorderLayout());

        // Creamos un panel superior con FlowLayout
        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new FlowLayout()); // Organiza los elementos en linea
        panelSuperior.add(new JButton("Boto 1"));
        panelSuperior.add(new JButton("Boto 2"));
        panelSuperior.add(new JButton("Boto 3"));

        // Panel central GridLayout (Pone los componentes en filas y columnas)
        JPanel panelCentral = new JPanel(); 
        panelCentral.setLayout(new GridLayout(2, 2)); // 2 filas & 2 columnas
        panelCentral.add(new JLabel("Etiqueta 1")); // Etiqueta con JLabel
        panelCentral.add(new JTextField("Texto 1")); // Cuadricula de texto
        panelCentral.add(new JLabel("Etiqueta 2"));
        panelCentral.add(new JTextField("Texto 2"));

        // Agregamos los paneles a la "finestra" JFrame
        finestra.add(panelSuperior, BorderLayout.NORTH);
        finestra.add(panelCentral, BorderLayout.CENTER);


        try{
           UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Hacemos visible la pantalla
        finestra.setVisible(true);


    }
}