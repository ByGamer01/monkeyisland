package com.example;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;

public class Main {
    public static void main(String args[]) {

        // Ponemos un grid 2x2 como dice el enunciado, debe de ser JFrame
        JFrame frame = new JFrame("PR0AC1"); // Le ponemos titulo: la actividad se llama asi
        frame.setLayout(new GridLayout(2,2)); // Establecemos el tamaño del grid del layout
        frame.setSize(1200, 800);
        

        JPanel mainPanel = new JPanel();


        // Panel Norte Primero | Azul | AHora son 4 paneles.
        JPanel panelNO = new JPanel();
        panelNO.setBackground(Color.BLUE);
        
        // Panel Norte Este | Rojo
        JPanel panelNE = new JPanel();
        panelNE.setBackground(Color.red);

        // Panel Sur Oeste | Amarillo 
        JPanel panelSO = new JPanel();
        panelSO.setBackground(Color.yellow);
        
        // Panel Sur Este | Verde
        JPanel panelSE = new JPanel();
        panelSE.setBackground(Color.green);



        frame.setVisible(true);
    }
}