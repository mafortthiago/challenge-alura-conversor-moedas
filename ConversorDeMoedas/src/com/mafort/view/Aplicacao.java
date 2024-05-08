package com.mafort.view;

import javax.swing.*;

public class Aplicacao {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ConversorForm conversorForm = new ConversorForm();
            conversorForm.setVisible(true);
        });
    }
}
