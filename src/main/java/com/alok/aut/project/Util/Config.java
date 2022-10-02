package com.alok.aut.project.Util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
public class MapUI {

	public static Properties prob;
	public static String BestExec = null;
	public static String BestExecFile = null;

    //--------------- mail configuration-------------------------------
    public static String smtpHost = null;
    public static String mailFrom = null;
    public static String smtp_enable = null;
    public static String smtp_port = null;
    public static String FromMailId = null;
    public static String ToMailId = null;
    public static String SubjectLine = null;

    public  static  String jsonDataFile = null;
    public static String target=null;
    public static String gridUrl=null;
    public static String girdPort=null;

    //--------------JDBC---------------------
    public static String JDBCIP;
    public static String JDBCUserName;
    public static String JDBCPasword;

    public MapUI () {
        String prop_path = "src/main/resources/config.properties";
        System.out.println (prop_path);
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
        //----------Mail Configurations---------
        FromMailId = prob.getProperty ("FromMailId");
        ToMailId = prob.getProperty ("ToMailId");
        SubjectLine = prob.getProperty ("SubjectLine");
        jsonDataFile= prob.getProperty ("jsonDataFile");
        target=prob.getProperty ("target");
        gridUrl=prob.getProperty ("gridUrl");
        girdPort=prob.getProperty ("girdPort");
    }
    public static void userInfoLoad () throws Exception {
        BestExecFile = System.getProperty ("user.dir") + "\\DataFile\\" + BestExec;
    }

}
