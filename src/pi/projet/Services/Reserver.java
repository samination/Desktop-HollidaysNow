/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.projet.Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import pi.projet.Entities.Treservation;
import pi.projet.Techniques.MyConnection;

/**
 *
 * @author samination
 */
public class Reserver {
    
    
     Connection cnx;
    public Reserver(){
        cnx=MyConnection.getInstance().getConnection();
    }
    public  void Reserver(Treservation r){
        try{
            String requete="INSERT INTO tresarvation (nombre_de_personnesT ,date_resT,id_clientT,idAnnonceT) VALUES('"+ r.getNbr_personnes()+"','"+ r.getDate_res()+"','"+ r.getId_client()+"','"+ r.getId_annonce()+"')";
            Statement st = cnx.createStatement();
            st.executeUpdate(requete);
            System.out.println("Reservé");
        } catch (SQLException Ex) {
        Logger.getLogger(Connection.class.getName()).log(Level.SEVERE,null,Ex );
        }
    }
    
    
   public ObservableList<Treservation> afficherTransport(int idReservation)
    {
        ResultSet rs;
        List<Treservation> listeComm = new ArrayList<>() ;
         try {
             
             String req="SELECT * from Tresarvation WHERE idReservationT="+idReservation;
             
             PreparedStatement pst = cnx.prepareStatement(req);
           
             rs=pst.executeQuery(req);
             while(rs.next()){
                 Treservation c=new Treservation(rs.getInt("idReservationT"),rs.getInt("nombre_de_personnesT"),rs.getDate("date_resT"),rs.getInt("id_clientT"),rs.getInt("idAnnonceT"));
                 
                     listeComm.add(c);
                     System.out.println(c);
             }
             ObservableList<Treservation> lc=FXCollections.observableArrayList(listeComm);
             return lc;
                    

             
         } catch (SQLException ex) {
             Logger.getLogger(Reserver.class.getName()).log(Level.SEVERE, null, ex);
             return null;
         }
    }
    
    public void supprimeragence(int idReservation) throws SQLException {
        String sql = "DELETE FROM `Tresarvation` WHERE idReservationT=?";
        PreparedStatement statement = cnx.prepareStatement(sql);
        statement.setInt(1, idReservation);
        statement.executeUpdate();
    }
    
    public ObservableList<Treservation> afficherReservation()
    {
        ResultSet rs;
        List<Treservation> listeComm = new ArrayList<>() ;
         try {
             
             String req="SELECT * from Tresarvation  ";
             
             PreparedStatement pst = cnx.prepareStatement(req);
            
             rs=pst.executeQuery(req);
             while(rs.next()){
                 Treservation c=new Treservation(rs.getInt("idReservationT"),rs.getInt("nombre_de_personnesT"),rs.getDate("date_resT"),rs.getInt("id_clientT"),rs.getInt("idAnnonceT"));
                 
                     listeComm.add(c);
             }
             ObservableList<Treservation> lc=FXCollections.observableArrayList(listeComm);
             return lc;
         } catch (SQLException ex) {
             Logger.getLogger(Reserver.class.getName()).log(Level.SEVERE, null, ex);
             return null;
         }

    }
    
}





