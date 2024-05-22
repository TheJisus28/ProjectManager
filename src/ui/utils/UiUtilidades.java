/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.utils;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

/**
 *
 * @author JESUS DANIEL
 */
public class UiUtilidades {
    
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
    
        public static String getPasswordFromField(JPasswordField passwordField) {
        char[] passwordChars = passwordField.getPassword(); // Obtener el arreglo de caracteres
        String password = new String(passwordChars); // Convertir el arreglo de caracteres a una cadena de texto
        // Limpia la variable de caracteres después de usarla
        clearPasswordChars(passwordChars);
        return password;
    }
 
    /**
     * Obtiene el texto de un JPasswordField de manera segura.
     * @param passwordField El JPasswordField del que se desea obtener el texto.
     * @return La contraseña como una cadena de texto.
     */
    private static void clearPasswordChars(char[] passwordChars) {
            if (passwordChars != null) {
                for (int i = 0; i < passwordChars.length; i++) {
                    passwordChars[i] = ' ';
                }
            }
        }
}
