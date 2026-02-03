package com.example;

import javax.swing.*;
import javax.swing.event.DocumentListener;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Mirall de Text");
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Escriu alguna cosa: ");
        panel.add(label);
        JTextField texto = new JTextField(20);
        ventana.add(panel.add(texto));
        texto.getDocument();
        DocumentListener document = new DocumentListener() {
            public String changedUpdate(DocumentEvent) {
                
            }
            public String insertUpdate(DocumentEvent) {

            }
            public String removeUpdate(DocumentEvent) {
                
            }
        };
        texto.add(document);

    }
}