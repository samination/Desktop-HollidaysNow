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
import pi.projet.Entities.Transport;
import pi.projet.Techniques.MyConnection;

/**
 *
 * @author samination
 */
public class CRUDClass {
    Connection cnx;
    public CRUDClass(){
        cnx=MyConnection.getInstance().getConnection();
    }
    public  void ajouterPersonne(Transport p){
        try{
            String requete="INSERT INTO Transport (idAnnonce,nomPos,date_aj,descri,prix,etat) VALUES('"+ p.getIdAnnonce()+"','"+ p.getNomPos()+"','"+ p.getDate_ajout()+"','"+ p.getDescription()+"','"+ p.getPrix()+"','"+ p.getEtat()+"')";
            Statement st = cnx.createStatement();
            st.executeUpdate(requete);
            System.out.println("Personne AjoutÃ©e");
        } catch (SQLException Ex) {
        Logger.getLogger(Connection.class.getName()).log(Level.SEVERE,null,Ex );
        }
    }
    public void modifierPersonne(Transport p){
        try{
            String requete="UPDATE Transport SET nomPos=?,date_aj=?,descri=?,prix=?,etat=? where idAnnonce=?";
            PreparedStatement pst=cnx.prepareStatement(requete);
            pst.setString(1, p.getNomPos());
            pst.setDate(2, p.getDate_ajout());
            pst.setString(3, p.getDescription());
            pst.setFloat(4, p.getPrix());
            pst.setString(5, p.getEtat());
            pst.setInt(6, p.getIdAnnonce());
            
            pst.executeUpdate();
            System.out.println("Personne Modifiée");
        }catch(SQLException Ex){
            Logger.getLogger(CRUDClass.class.getName()).log(Level.SEVERE,null,Ex);
            }
    }
    
    /**
     *
     * @return
     */
   public ObservableList<Transport> afficherTransport()
    {
        ResultSet rs;
        List<Transport> listeComm = new ArrayList<>() ;
         try {
             
             String req="select * from Transport";
             PreparedStatement pst = cnx.prepareStatement(req);
             rs=pst.executeQuery(req);
             while(rs.next()){
                 Transport c=new Transport(rs.getInt("idAnnonce"),rs.getString("nomPos"),rs.getDate("date_aj"),rs.getString("descri"),rs.getFloat("prix"),rs.getString("etat"),rs.getInt("idAgence"));
                 
                     listeComm.add(c);
             }
             ObservableList<Transport> lc=FXCollections.observableArrayList(listeComm);
             return lc;
         } catch (SQLException ex) {
             Logger.getLogger(CRUDClass.class.getName()).log(Level.SEVERE, null, ex);
             return null;
         }

    }
    public void supprimerAnnonce(int id_Annonce) throws SQLException {
        String sql = "DELETE FROM Transport WHERE idAnnonce=?";
        PreparedStatement statement = cnx.prepareStatement(sql);
        statement.setInt(1, id_Annonce);
        statement.executeUpdate();
            
    }
    
     public ObservableList<Transport> afficherTransport(float idReservation) {
        ResultSet rs;
        List<Transport> listeComm = new ArrayList<>() ;
         try {
             
             String req="SELECT  * from Transport WHERE prix="+idReservation;
             
             PreparedStatement pst = cnx.prepareStatement(req);
             
           
             rs=pst.executeQuery(req);
             while(rs.next()){
                 Transport c=new Transport(rs.getInt("idAnnonce"),rs.getString("nomPos"),rs.getDate("date_aj"),rs.getString("descri"),rs.getFloat("prix"),rs.getString("etat"),rs.getInt("idAGENCE"));
                 
                     listeComm.add(c);
                     
             }
             ObservableList<Transport> lc=FXCollections.observableArrayList(listeComm);
             return lc;
                    

             
         } catch (SQLException ex) {
             Logger.getLogger(Reserver.class.getName()).log(Level.SEVERE, null, ex);
             return null;
         }
    }
}















