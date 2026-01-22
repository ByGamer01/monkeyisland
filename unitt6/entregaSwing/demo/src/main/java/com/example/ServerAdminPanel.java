package com.example;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

// Clase principal que hereda de JFrame (ventana principal)
public class ServerAdminPanel extends JFrame {
    
    // Constructor de la clase
    public ServerAdminPanel() {
        // Llamamos al constructor padre con el título de la ventana
        super("Tauler d'Administració - David Java");
        
        // Configuración de la ventana principal
        setSize(800, 600);  // Tamaño: 800x600 px
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Cerrar aplicación al cerrar ventana
        setLocationRelativeTo(null);  // Centrar ventana en pantalla
        setLayout(new GridLayout(2, 2, 15, 15)); // Layout 2x2 con gaps de 15px
        
        // Añadir margen exterior de 15px a todos los lados
        getRootPane().setBorder(new EmptyBorder(15, 15, 15, 15));

        // PANEL ESTADO (Nord-Oeste / Arriba-Izquierda)
        JPanel pEstat = new JPanel(new GridLayout(2, 1));// Layout interno: 2 filas y 1 columna
        pEstat.setBorder(BorderFactory.createTitledBorder("Estat del Sistema")); // Borde con título
        pEstat.add(new JLabel("CPU: 15% Ús", SwingConstants.CENTER)); // Etiqueta CPU en el medio
        pEstat.add(new JLabel("RAM: 4GB / 16GB", SwingConstants.CENTER)); // Etiqueta RAM en el medio

        // PANEL CONTROL (Nord-Este / Arriba-Derecha)
        JPanel pControl = new JPanel(new GridLayout(3, 1, 0, 10));  // 3 filas, 1 columna, gap vertical 10px
        pControl.setBorder(BorderFactory.createTitledBorder("Accions Ràpides"));
        pControl.add(new JButton("Iniciar Servei"));// Botón iniciar
        pControl.add(new JButton("Aturar Servei")); // Botón detener
        pControl.add(new JButton("Reiniciar")); // Botón reiniciar

        // PANEL CONFIGURACIÓN (Sud-Oeste / Abajo-Izquierda)
        JPanel pConfig = new JPanel(new GridLayout(4, 1, 0, 5));  // 4 filas, 1 columna, gap 5px
        pConfig.setBorder(BorderFactory.createTitledBorder("Paràmetres de Càrrega"));
        
        // Crear slider horizontal: mínimo 0, máximo 500, valor inicial 250
        JSlider slider = new JSlider(0, 500, 250);
        slider.setPaintTicks(true); // Mostrar marcas
        slider.setPaintLabels(true); // Mostrar números
        slider.setMajorTickSpacing(100); // Marcas grandes cada 100
        slider.setMinorTickSpacing(25); // Marcas pequeñas cada 25
        
        pConfig.add(new JLabel("Límit de Connexions (0-500):")); // Etiqueta del slider
        pConfig.add(slider); // El slider
        pConfig.add(new JLabel("Timeout (segons):"));// Etiqueta del campo de texto
        pConfig.add(new JTextField("60")); // Campo de texto con valor por defecto

        // PANEL LOGS (Sud-Este / Abajo-Derecha)
        JPanel pLogs = new JPanel(new BorderLayout()); // BorderLayout para el scroll
        pLogs.setBorder(BorderFactory.createTitledBorder("Logs del Servidor en Viu"));
        
        // área de texto con logs de ejemplo (10-15 líneas)
        JTextArea logs = new JTextArea(
            "[Info] Servei iniciat...\n" +
            "[Warning] Connexió lenta IP 192.168.1.45\n" +
            "[Info] Base de dades connectada.\n" +
            "[Error] Fallada en el mòdul d'autenticació (intent 1).\n" +
            "[Info] Reintentant connexió...\n" +
            "[Info] Connexió restablerta.\n" +
            "[Warning] Ús de memòria elevat: 85%\n" +
            "[Info] Neteja de caché completada.\n" +
            "[Info] Nou usuari connectat: admin@server.local\n" +
            "[Warning] Certificat SSL expira en 15 dies.\n" +
            "[Info] Backup programat per a les 03:00.\n"
        );
        
        logs.setEditable(false);  // No editable por el usuario
        logs.setFont(new Font("Monospaced", Font.PLAIN, 12));  // Fuente monoespaciada
        
        // IMPORTANTE: Añadir el JTextArea dentro de un JScrollPane (no directamente)
        // El scroll aparece automáticamente cuando hay más texto del que cabe
        pLogs.add(new JScrollPane(logs), BorderLayout.CENTER);

        // ACOPLAMIENTO FINAL - Añadir paneles al JFrame
        // El orden importa en GridLayout
        // 1. Arriba-Izquierda, 2. Arriba-Derecha, 3. Abajo-Izquierda, 4. Abajo-Derecha
        add(pEstat); // Panel estado (Nord-Oeste)
        add(pControl); // Panel control (Nord-Este)
        add(pConfig); // Panel configuración (Sud-Oeste)
        add(pLogs); // Panel logs (Sud-Este)
        
        // Hacer visible la ventana
        setVisible(true);
    }
}

