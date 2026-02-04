package com.example;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // 1. Crear la ventana
        JFrame ventana = new JFrame("Mirall de Text");

        // 2. Crear el panel con un layout vertical
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        // 3. Crear los componentes
        JTextField texto = new JTextField(20);
        JLabel label = new JLabel(""); // Empieza vacío, será el "espejo"

        // 4. Añadir componentes al panel
        panel.add(texto);
        panel.add(label);

        // 5. Crear y conectar el DocumentListener
        texto.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                label.setText(texto.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                label.setText(texto.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                label.setText(texto.getText());
            }
        });

        // 6. Añadir panel a la ventana
        ventana.add(panel);

        // 7. Configurar y mostrar la ventana
        ventana.setSize(400, 150);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }
}