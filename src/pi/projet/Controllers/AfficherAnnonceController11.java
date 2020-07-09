/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.projet.Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import pi.projet.Entities.Transport;
import pi.projet.Services.CRUDClass;

/**
 * FXML Controller class
 *
 * @author samination
 */
public class AfficherAnnonceController11 implements Initializable {
    @FXML
    private TableView<Transport> table1;
    @FXML
    private TableColumn<Transport, Integer> c1;
    @FXML
    private TableColumn<Transport, String> c2;
    @FXML
    private TableColumn<Transport, Date> c3;
    @FXML
    private TableColumn<Transport, String> c4;
    @FXML
    private TableColumn<Transport,  Float> c5;
    @FXML
    private TableColumn<Transport, String> c6;
    List<Transport> liste_commentaire;
private CRUDClass cs=new CRUDClass();
public static Transport he;
    @FXML
    private Button sup1;
    @FXML
    private Button mod1;
    @FXML
    private Button aff1;
    @FXML
    private Button res1;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
 ObservableList<Transport> data=FXCollections.observableArrayList();
     
       List<Transport> listeCompagnie=cs.afficherTransport();
       
       for(int i=0;i<listeCompagnie.size();i++){
           Transport c =listeCompagnie.get(i);           
       data.add(c);
       }

        c1.setCellValueFactory(
                new PropertyValueFactory<>("idAnnonce"));
       c2.setCellValueFactory(
                new PropertyValueFactory<>("nomPos"));
       c3.setCellValueFactory(
                new PropertyValueFactory<>("date_ajout"));
       c4.setCellValueFactory(
                new PropertyValueFactory<>("description"));
       c5.setCellValueFactory(
                new PropertyValueFactory<>("Prix"));
       c6.setCellValueFactory(
                new PropertyValueFactory<>("etat"));
        
      
   table1.setItems(data);
   
        
// TODO
   sup1.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                if (table1.getSelectionModel().getSelectedItem() != null) {
            try {
                int id = table1.getSelectionModel().getSelectedItem().getIdAnnonce();
                CRUDClass s = new CRUDClass();
                s.supprimerAnnonce(id);
            } catch (SQLException ex) {
                Logger.getLogger(AfficherAnnonceController.class.getName()).log(Level.SEVERE, null, ex);
            }
            /*rafrechir();*/
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Vous devez selectionner un voyage organise");
            alert.show();
        }
            }
         });
    mod1.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
         if (table1.getSelectionModel().getSelectedItem() != null) {

            
               try {
         Transport a = table1.getSelectionModel().getSelectedItem();
        he = a;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("./Modifier Article.fxml"));
        Parent root = loader.load();
        ModifierArticleController hc = loader.getController();
        hc.setVoyageOrganise(a);
        
        Stage stage= new Stage();
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.showAndWait();
       /* rafrechir();*/
        } catch (IOException ex) {
            Logger.getLogger(AfficherAnnonce.class.getName()).log(Level.SEVERE, null, ex);
        }
                   } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Vous devez selectionner un voyage organise");
            alert.show();
        }
    }
            
         });
    aff1.setOnAction(new EventHandler<ActionEvent>() {
        @Override
            public void handle(ActionEvent event) {
                ObservableList<Transport> data=FXCollections.observableArrayList();
     
       List<Transport> listeCompagnie=cs.afficherTransport();
       
       for(int i=0;i<listeCompagnie.size();i++){
           Transport c =listeCompagnie.get(i);           
       data.add(c);
       }

        c1.setCellValueFactory(
                new PropertyValueFactory<>("idAnnonce"));
       c2.setCellValueFactory(
                new PropertyValueFactory<>("nomPos"));
       c3.setCellValueFactory(
                new PropertyValueFactory<>("date_ajout"));
       c4.setCellValueFactory(
                new PropertyValueFactory<>("description"));
       c5.setCellValueFactory(
                new PropertyValueFactory<>("Prix"));
       c6.setCellValueFactory(
                new PropertyValueFactory<>("etat"));
        
      
   table1.setItems(data);
            
                
                
                
                
                
                
                
                
                
                
                
            }
        
            
            
            
         });
    res1.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
         if (table1.getSelectionModel().getSelectedItem() != null) {

            
               try {
         Transport a = table1.getSelectionModel().getSelectedItem();
        he = a;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("./Reserver.fxml"));
        Parent root = loader.load();
        ReserverController hc = loader.getController();
        hc.setVoyageOrganise(a);
        
        Stage stage= new Stage();
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.showAndWait();
       /* rafrechir();*/
        } catch (IOException ex) {
            Logger.getLogger(AfficherAnnonce.class.getName()).log(Level.SEVERE, null, ex);
        }
                   } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Vous devez selectionner un voyage organise");
            alert.show();
        }
    }
            
         });
        
    
        
    }  
    
     
}
