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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import pi.projet.Entities.Transport;
import pi.projet.Services.CRUDClass;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * FXML Controller class
 *
 * @author samination
 */
public class AfficherAnnonceController1 implements Initializable {
    
    List<Transport> liste_commentaire;
private CRUDClass cs=new CRUDClass();
public static Transport he;
    
    @FXML
    private TableView<Transport> table11;
    @FXML
    private TableColumn<Transport, Integer> c11;
    @FXML
    private TableColumn<Transport, String> c21;
    @FXML
    private TableColumn<Transport, Date> c31;
    @FXML
    private TableColumn<Transport, String> c41;
    @FXML
    private TableColumn<Transport, Float> c51;
    @FXML
    private TableColumn<Transport, String> c61;
    @FXML
    private Button sup11;
    @FXML
    private Button mod11;
    @FXML
    private Button aff11;
    @FXML
    private Button ch11;
    @FXML
    private TextField e11;
    @FXML
    private ComboBox<String> cm11;
    ObservableList<String> liste_spec=FXCollections.observableArrayList("nombre de personnes","prix");
    @FXML
    private Button im1;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cm11.setValue("Critère");
        cm11.setItems(liste_spec);
        
 ObservableList<Transport> data=FXCollections.observableArrayList();
     
       List<Transport> listeCompagnie=cs.afficherTransport();
       
       for(int i=0;i<listeCompagnie.size();i++){
           Transport c =listeCompagnie.get(i);           
       data.add(c);
       }

        c11.setCellValueFactory(
                new PropertyValueFactory<>("idAnnonce"));
       c21.setCellValueFactory(
                new PropertyValueFactory<>("nomPos"));
       c31.setCellValueFactory(
                new PropertyValueFactory<>("date_ajout"));
       c41.setCellValueFactory(
                new PropertyValueFactory<>("description"));
       c51.setCellValueFactory(
                new PropertyValueFactory<>("Prix"));
       c61.setCellValueFactory(
                new PropertyValueFactory<>("etat"));
        
      
   table11.setItems(data);
   
        
// TODO
   sup11.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                if (table11.getSelectionModel().getSelectedItem() != null) {
            try {
                int id = table11.getSelectionModel().getSelectedItem().getIdAnnonce();
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
    mod11.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
         if (table11.getSelectionModel().getSelectedItem() != null) {

            
               try {
         Transport a = table11.getSelectionModel().getSelectedItem();
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
    aff11.setOnAction(new EventHandler<ActionEvent>() {
        @Override
            public void handle(ActionEvent event) {
                ObservableList<Transport> data=FXCollections.observableArrayList();
     
       List<Transport> listeCompagnie=cs.afficherTransport();
       
       for(int i=0;i<listeCompagnie.size();i++){
           Transport c =listeCompagnie.get(i);           
       data.add(c);
       }

        c11.setCellValueFactory(
                new PropertyValueFactory<>("idAnnonce"));
       c21.setCellValueFactory(
                new PropertyValueFactory<>("nomPos"));
       c31.setCellValueFactory(
                new PropertyValueFactory<>("date_ajout"));
       c41.setCellValueFactory(
                new PropertyValueFactory<>("description"));
       c51.setCellValueFactory(
                new PropertyValueFactory<>("Prix"));
       c61.setCellValueFactory(
                new PropertyValueFactory<>("etat"));
        
      
   table11.setItems(data);
            
                
                
                
                
                
                
                
                
                
                
                
            }
        
            
            
            
         });
    
    ch11.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
       if (cm11.getValue()=="prix") {
             
            
     
       List<Transport> listeCompagnie=cs.afficherTransport(Float.parseFloat(e11.getText()));
       
       ObservableList obs;
       obs=FXCollections.observableArrayList(listeCompagnie);
       table11.setItems(obs);
              c11.setCellValueFactory(new PropertyValueFactory<>("idAnnonce"));

       c21.setCellValueFactory(new PropertyValueFactory<>("nomPos"));
              c31.setCellValueFactory(new PropertyValueFactory<>("date_ajout"));
       c41.setCellValueFactory(new PropertyValueFactory<>("description"));
       c51.setCellValueFactory(new PropertyValueFactory<>("prix"));
       c61.setCellValueFactory(new PropertyValueFactory<>("etat"));

      
            
       }
       
             
             
             
         }
         
         

            
          
            
         });
    
   
    
        
    }  

    @FXML
    
        
    private void imprimer(ActionEvent event) throws FileNotFoundException, DocumentException {
        CRUDClass rs=new CRUDClass();
        
            Document pdfReport = new Document();
            PdfWriter.getInstance(pdfReport, new FileOutputStream("Annonce.pdf"));
            pdfReport.open();
            pdfReport.add(new Paragraph("les annonces De Transport"));
            pdfReport.add(Chunk.NEWLINE);
            pdfReport.add(Chunk.NEWLINE);
           
            
            
            
            PdfPTable my_report_table = new PdfPTable(3);
            
            /* PdfPCell tableCellColumn = new PdfPCell(new Phrase("debut vol"));
            my_report_table.addCell(tableCellColumn);
            tableCellColumn = new PdfPCell(new Phrase("fin volt"));
            my_report_table.addCell(tableCellColumn);*/
            PdfPCell  tableCellColumn = new PdfPCell(new Phrase("Nom Du posteur"));
            my_report_table.addCell(tableCellColumn);
           
            
            tableCellColumn = new PdfPCell(new Phrase("Description"));
            my_report_table.addCell(tableCellColumn);
            tableCellColumn = new PdfPCell(new Phrase("Etat"));
            my_report_table.addCell(tableCellColumn);
            
          
            
            /*
            tableCellColumn = new PdfPCell(new Phrase("Quantite"));
            my_report_table.addCell(tableCellColumn);
            tableCellColumn = new PdfPCell(new Phrase("Date"));
            my_report_table.addCell(tableCellColumn);
            */
            double h= 0;
            table11.getItems().forEach((Transport e) -> {
                
                PdfPCell  tableCell = new PdfPCell(new Phrase(e.getNomPos()));
                my_report_table.addCell(tableCell);
                
                tableCell = new PdfPCell(new Phrase(e.getEtat()));
                my_report_table.addCell(tableCell);
                tableCell = new PdfPCell(new Phrase(e.getDescription()));
                my_report_table.addCell(tableCell);
                
                
                
//                String Prix = "" + e.getPrix();
//                tableCell = new PdfPCell(new Phrase(Prix));
//                my_report_table.addCell(tableCell);
                
                
//                tableCell = new PdfPCell(new Phrase(e.getType_vol()));
//                
//                my_report_table.addCell(tableCell);
                
//                String NB_PLACE = " "+e.getNb_pr();
//                tableCell = new PdfPCell(new Phrase(NB_PLACE));
//                my_report_table.addCell(tableCell);
                // double h = h + e.getPrixProduit()*e.getQuantite();
            });
            /* Attach report table to PDF */
            pdfReport.add(my_report_table);
            pdfReport.add(Chunk.NEWLINE);
            pdfReport.add(Chunk.NEWLINE);
            
            
            
            
            
            
            pdfReport.close();
            
            Alert alertReservation = new Alert(Alert.AlertType.INFORMATION);
            alertReservation.setTitle("Extraction en PDF");
            alertReservation.setHeaderText(null);
            alertReservation.setContentText("PDF report has been created.\nYou'll find "
                    + "the file under: C:\\Users\\esprit\\Desktop\\mafhemtekch2\\Restaurant\\PI");
            alertReservation.showAndWait();
        
        }
    }

