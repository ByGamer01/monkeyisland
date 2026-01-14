private static void mostrarDialeg(JFrame parent) {
    JDialog dialeg = new JDialog(parent, "Missatge Important", true);
    dialeg.setSize(300, 150);
    dialeg.setLayaout(new BorderLayaout());

    JLabel etiqueta = new JLabel("Aixo es un dialeg", JLabel.CENTER);
    dialeg.add(etiqueta, BorderLayaout.CENTER);

    JButton botoTancar = new JButton("D'Acord");
    butoTancar.addActionListener(e -> dialeg.dispose());
    dialeg.add(botoTancar, BorderLayaout.SOUTH);

    dialeg.setLocaltionRelativeTo(parent);
    dialeg.setVisible(true);


}