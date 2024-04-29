/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JOptionPane;

/**
 *
 * @author JESUS DANIEL
 */
public class Utilidades {
    
    public static void agregarPlaceholder(javax.swing.JTextField textField, String placeholder) {
        textField.setText(placeholder);
        textField.setForeground(Color.GRAY); // Color del placeholder
        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK); // Cambia el color al obtener el foco
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText(placeholder);
                    textField.setForeground(Color.GRAY); // Restaura el color si está vacío
                }
            }
        });
    }
    
    public static void mostrarVentana(String mensaje, String titulo) {
            JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
    }
    
    
        public static String obtenerTextoRadioButtonSeleccionado(ButtonGroup buttonGroup) {
            ButtonModel selectedButtonModel = buttonGroup.getSelection();
            if (selectedButtonModel != null) {
                return selectedButtonModel.getActionCommand();
            }
            return null;
    }
    
    
}
