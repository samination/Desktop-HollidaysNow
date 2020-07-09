/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication7;

import java.sql.Connection;
import java.sql.Date;
import pi.projet.Entities.Transport;
import pi.projet.Entities.Treservation;
import pi.projet.Services.CRUDClass;
import pi.projet.Services.Reserver;
import pi.projet.Techniques.MyConnection;

/**
 *
 * @author samination
 */
public class JavaApplication7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Reserver RS=new Reserver();
        Connection cnx=MyConnection.getInstance().getConnection();
        Treservation r1= new Treservation(145,12,new Date(2018/7/8),12,16);
        
        RS.Reserver(r1);
        
        
        // TODO code application logic here*/
        
    }
    
}
