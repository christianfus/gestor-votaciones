/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ch
 */
public class Enquesta {
    private String text;
    private Integer id;
    private Connection connexio;
    private Statement instruccions;
    private ResultSet resultats;

    public Enquesta(){
        this.text="";
        this.id=0;
    }
    
    public String getText() {
        return text;
    }

    public Integer getId() {
        return id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public boolean existeTot() {
         // esta linea és per si diu que no troba el driver de MySQL 
       boolean tornar;
        try {
        Class.forName("com.mysql.jdbc.Driver");
        // 1r Connectar a la BBDD
        connexio=DriverManager.getConnection("jdbc:mysql://localhost:3306/proves","root","");
        // 2n crear el manejador d'instruccions
        instruccions=connexio.createStatement();
        // 3r ara ja podem llançar totes les instruccions SQL que necessitem
        resultats=instruccions.executeQuery("select * from encuesta");
        if(resultats.next()) {
            
           Integer _id=resultats.getInt(1);
           String _text=resultats.getString(2);
           
           this.id=_id;
           this.text=_text;

           tornar=true;
           }
        else {
          tornar=false; 
        }
         connexio.close();
        }
        catch(SQLException e) {
               tornar=false;
                } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(Enquesta.class.getName()).log(Level.SEVERE, null, ex);
            tornar=false;
        }
        return tornar;
    }
    
    
}
