/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.lang.reflect.Method;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Charles
 */
public class Utils {

  
    public static Date convertDate(java.sql.Date date) {
        try {

            String dataString = date.toString();
            DateFormat df = DateFormat.getDateInstance(DateFormat.DEFAULT);
            Date data = df.parse(dataString);
            return data;
        } catch (Exception e) {
            return null;
        }
    }
}
