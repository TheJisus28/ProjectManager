/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author JESUS DANIEL
 */
public class LogicUtilidades {
        /**
     * Convierte una cadena de fecha en formato "dd/mm/aaaa" a un objeto Date.
     * @param fechaStr La cadena de fecha en formato "dd/mm/aaaa"
     * @return Un objeto Date representando la fecha, o null si la cadena no es válida.
     */
    public static Date convertirStringADate(String fechaStr) {
        DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return formatoFecha.parse(fechaStr);
        } catch (ParseException e) {
            return null;
        }
    }
    
}
