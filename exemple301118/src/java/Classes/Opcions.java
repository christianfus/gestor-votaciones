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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ch
 */
public class Opcions {
    
    Integer idEnquesta, havotat, idOpcio;
    String text;
    private Connection connexio;
    private ArrayList<String> equips;
    private Statement instruccions;
    private ResultSet resultats;

    public Opcions() {
        idEnquesta=0;
        havotat=0;
        idOpcio=0;
        text="";
    }

    public ArrayList<String> getEquips() {
        return equips;
    }

    public void setEquips(ArrayList<String> equips) {
        this.equips = equips;
    }
    
    
    
    public Integer getIdEnquesta() {
        return idEnquesta;
    }

    public Integer getHavotat() {
        return havotat;
    }

    public Integer getIdOpcio() {
        return idOpcio;
    }

    public String getText() {
        return text;
    }

    public void setIdEnquesta(Integer idEnquesta) {
        this.idEnquesta = idEnquesta;
    }

    public void setHavotat(Integer havotat) {
        this.havotat = havotat;
    }

    public void setIdOpcio(Integer idOpcio) {
        this.idOpcio = idOpcio;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    
    /*public void obtindreVots(int vots_vlc, int vots_bar, int vots_mad) {
         try {
         Class.forName("com.mysql.jdbc.Driver");
         connexio=DriverManager.getConnection("jdbc:mysql://localhost:3306/proves","root","");
         instruccions=connexio.createStatement();
         
         resultats=instruccions.executeQuery("select vots from opcions;");
         
         vots_vlc = resultats.getInt(1);
         vots_bar = resultats.getInt(2);
         vots_mad = resultats.getInt(3);
         
         connexio.close();
         }
         catch(SQLException e) {
             
                 } 
         catch (ClassNotFoundException ex) {
             Logger.getLogger(Opcions.class.getName()).log(Level.SEVERE, null, ex);
         }
     }*/
        
    public void votarEquip(String equip) {
         try {
         Class.forName("com.mysql.jdbc.Driver");
         connexio=DriverManager.getConnection("jdbc:mysql://localhost:3306/proves","root","");
         instruccions=connexio.createStatement();
         
         switch(equip){
             case "1": instruccions.executeUpdate("UPDATE opcions SET vots = vots + 1 WHERE idOpcio=1;"); break;
             case "2": instruccions.executeUpdate("UPDATE opcions SET vots = vots + 1 WHERE idOpcio=2;"); break;
             case "3": instruccions.executeUpdate("UPDATE opcions SET vots = vots + 1 WHERE idOpcio=3;"); break;
         }
          connexio.close();
         }
         catch(SQLException e) {
             
                 } 
         catch (ClassNotFoundException ex) {
             Logger.getLogger(Opcions.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
    
    public ArrayList<Opcions> instanciarOpcions() {
        ArrayList<Opcions> llista = new ArrayList<>();
        try {
        Class.forName("com.mysql.jdbc.Driver");
        // 1r Connectar a la BBDD
        connexio=DriverManager.getConnection("jdbc:mysql://localhost:3306/proves","root","");
        // 2n crear el manejador d'instruccions
        instruccions=connexio.createStatement();
        // 3r ara ja podem llançar totes les instruccions SQL que necessitem
        resultats=instruccions.executeQuery("select * from opcions");

        int contador=0;
        while(resultats.next()) {
            
            contador++;
            Opcions opt = new Opcions();
            opt.setIdEnquesta(resultats.getInt(1));
            opt.setIdOpcio(resultats.getInt(2));
            opt.setText(resultats.getString(3));
            opt.setHavotat(resultats.getInt(4));
            llista.add(opt);
            
           }
         
         connexio.close();
         
        }
        catch(SQLException e) {
                } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(Enquesta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return llista;
    }
     
    
}
