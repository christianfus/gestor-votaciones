/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author fidel
 */
public class Usuari {
    private String nom, cognoms, poblacio, usuari, contrasenya;
    private Integer havotat;
    private Connection connexio;
    private Statement instruccions;
    private ResultSet resultats;

    public Usuari() {
        nom="";cognoms="";poblacio="";usuari="";contrasenya="";havotat=0;
    }

    public String getNom(){
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognoms() {
        return cognoms;
    }

    public void setCognoms(String cognoms) {
        this.cognoms = cognoms;
    }

    public String getPoblacio() {
        return poblacio;
    }

    public void setPoblacio(String poblacio) {
        this.poblacio = poblacio;
    }

    public String getUsuari() {
        return usuari;
    }

    public void setUsuari(String usuari) {
        this.usuari = usuari;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public Integer getHavotat() {
        return havotat;
    }

    public void setHavotat(Integer havotat) {
        this.havotat = havotat;
    }

    public void votar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connexio=DriverManager.getConnection("jdbc:mysql://localhost:3306/proves","root","");
            instruccions=connexio.createStatement();
            instruccions.executeUpdate("UPDATE usuaris SET havotat = havotat + 1 WHERE logUsuari='"
                    + this.usuari + "' AND passUsuari='" + this.contrasenya + "'");
            connexio.close();
        }
        catch(SQLException e) {
            
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(Opcions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean noHaVotat(){
        return this.havotat < 1;
    }
    public boolean isValid() {
        return (!this.usuari.equals("") && !this.contrasenya.equals(""));
    }
    public boolean isValidComplet() {
        return (this.isValid() && !this.poblacio.equals(""));
    }
    public boolean existeLogin() {
         // esta linea és per si diu que no troba el driver de MySQL 
        boolean tornar;
        try {
        Class.forName("com.mysql.jdbc.Driver");
        // 1r Connectar a la BBDD
        connexio=DriverManager.getConnection("jdbc:mysql://localhost:3306/proves","root","");
        // 2n crear el manejador d'instruccions
        instruccions=connexio.createStatement();
        // 3r ara ja podem llançar totes les instruccions SQL que necessitem
        resultats=instruccions.executeQuery("select * from usuaris WHERE logUsuari='"+this.usuari
        +"'");
        tornar = resultats.next();
        connexio.close();
        }
        catch(SQLException e) {
                tornar=false;
                } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(Usuari.class.getName()).log(Level.SEVERE, null, ex);
            tornar=false;
        }
        return tornar;
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
        resultats=instruccions.executeQuery("select * from usuaris WHERE logUsuari='"+this.usuari
        +"' AND passUsuari='"+this.contrasenya+"'");
        if(resultats.next()) {
           Integer _havotat=resultats.getInt(7);
           String _nom=resultats.getString(2);
           String _cognoms=resultats.getString(3);
           String _poblacio=resultats.getString(4);
           
           
           this.nom=_nom;
           this.cognoms=_cognoms;
           this.poblacio=_poblacio;
           this.havotat=_havotat;
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
            Logger.getLogger(Usuari.class.getName()).log(Level.SEVERE, null, ex);
            tornar=false;
        }
        return tornar;
    }
     public int alta() {
         // esta linea és per si diu que no troba el driver de MySQL 
        int tornar;
        try {
        Class.forName("com.mysql.jdbc.Driver");
        // 1r Connectar a la BBDD
        connexio=DriverManager.getConnection("jdbc:mysql://localhost:3306/proves","root","");
        // 2n crear el manejador d'instruccions
        instruccions=connexio.createStatement();
        // 3r ara ja podem llançar totes les instruccions SQL que necessitem
        String instruccio="insert into usuaris(nomUsuari,cognomsUsuari,pobUsuari,logUsuari,passUsuari)VALUES('"+this.nom+"','"+this.cognoms+"','"+this.poblacio+"','"+this.usuari+"','"+this.contrasenya+"')";
        int files=instruccions.executeUpdate(instruccio); 
        
       if (files!=0) { tornar=0; }
       else { tornar=1; }
       connexio.close();
        }
        catch(SQLException e) {
                tornar=2;
                } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(Usuari.class.getName()).log(Level.SEVERE, null, ex);
            tornar=3;
        }
        return tornar;
    }
}
