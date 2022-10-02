package com.alok.aut.project.Util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
/***
 *
 *
 *
 * User: alok
 * Date: 02/10/22
 *
 */
public class LoadObject {
    public static Properties prob;
    public static String sutUrl = null;
    public static String Webform = null;
    public static String Navigation = null;
    public static String Mouseover = null;
    public static String Dropdownmenu = null;
    public static String Drawcanvas = null;
    public static String Loadingimages = null;
    public static String Slowcalculator = null;
    public static String myText = null;
    public static String passwordText = null;
    public static String mytextarea = null;
    public static String inputText = null;
    public static String CheckedRadio = null;
    public LoadObject () {
        String prop_path = "src/main/resources/object.properties";
        File file = new File (prop_path);
        FileInputStream fin = null;
        try {
            fin = new FileInputStream (file);
        } catch (FileNotFoundException e) {
            e.printStackTrace ();
        }
        prob = new Properties ();
        try {
            prob.load (fin);
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }
    public void readProperties () {
        sutUrl = prob.getProperty ("sutUrl");
        Webform = prob.getProperty ("Webform");
        Navigation = prob.getProperty ("Navigation");
        Mouseover = prob.getProperty ("Mouseover");
        Dropdownmenu = prob.getProperty ("Dropdownmenu");
        Drawcanvas = prob.getProperty ("Drawcanvas");
        Loadingimages = prob.getProperty ("Loadingimages");
        Slowcalculator = prob.getProperty ("Slowcalculator");
        myText = prob.getProperty ("myText");
        passwordText = prob.getProperty ("passwordText");
        mytextarea = prob.getProperty ("mytextarea");
        inputText = prob.getProperty ("inputText");
        CheckedRadio =prob.getProperty ("CheckedRadio");
    }

}
