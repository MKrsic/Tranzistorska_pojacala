/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tranzpojacnew.Resources.SZE;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import tranzpojacnew.Tranzistori.Bipolarni.SZE.SZEbezKond;
import tranzpojacnew.Tranzistori.Bipolarni.SZE.SZEsaKond;

/**
 * FXML Controller class
 *
 * @author Matija
 */
public class SzeFXMLController implements Initializable {
    @FXML
    private TextField Uul;
    @FXML
    private TextField Uizl;
    @FXML
    private TextField SRPSZE;
    @FXML
    private TextField DRPSZE;
    @FXML
    private TextField Ucc;
    @FXML
    private TextField R1;
    @FXML
    private TextField Rc;
    @FXML
    private TextField R2;
    @FXML
    private TextField Re;
    @FXML
    private TextField hfe;
    @FXML
    private TextField Rt;
    @FXML
    private TextField Rg;
    @FXML
    private TextField Ubeq;
    @FXML
    private TextField Ubb;
    @FXML
    private TextField Rbb;
    @FXML
    private TextField Ibq;
    @FXML
    private TextField Icq;
    @FXML
    private TextField Uceq;
    @FXML
    private TextField Hie;
    @FXML
    private TextField Rul;
    @FXML
    private TextField Rizl;
    @FXML
    private TextField Av;
    @FXML
    private TextField Ai;
    @FXML
    private Button ReturnSZE;
    @FXML
    private CheckBox checkCe;
    @FXML
    private Button ShemaSzeShow;
    
    boolean selectedSZE;
    public static SZEbezKond SZEbK;
    
        @FXML
    public void handleCheckBoxKond (ActionEvent event){
        selectedSZE = checkCe.isSelected();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
    @FXML
    private void handleButtonActionCalculateSZE(ActionEvent event) {
                      
         if(selectedSZE == false){   //odabir sa ili bez Ce (bez Ce)
                SZEbK = new SZEbezKond(    
                    Double.parseDouble(Ucc.getText()), 
                    Double.parseDouble(R1.getText()), 
                    Double.parseDouble(R2.getText()), 
                    Double.parseDouble(Rc.getText()), 
                    Double.parseDouble(Re.getText()), 
                    Double.parseDouble(hfe.getText()), 
                    Double.parseDouble(Rt.getText()), 
                    Double.parseDouble(Rg.getText()), 
                    Double.parseDouble(Ubeq.getText()), 
                    Double.parseDouble(Uul.getText()));
             
             Ubb.setText(String.format("%.2f", SZEbK.getUbb()));
             Rbb.setText(String.format("%.2f", SZEbK.getRbb()));
             Ibq.setText(String.format("%.2f", SZEbK.getIbqua()));
             Icq.setText(String.format("%.2f", SZEbK.getIcqma()));
             Uceq.setText(String.format("%.2f", SZEbK.getUceq()));
             Av.setText(String.format("%.2f", SZEbK.getAv()));
             Hie.setText(String.format("%.2f", SZEbK.getHie()));
             Ubb.setText(String.format("%.2f", SZEbK.getUbb()));
             Rul.setText(String.format("%.2f", SZEbK.getRul()));
             Rizl.setText(String.format("%.2f", SZEbK.getRizl()));
             Ai.setText(String.format("%.2f", SZEbK.getAi()));
             Uizl.setText(String.format("%.2f", SZEbK.getUizl()));
             SRPSZE.setText(SZEbK.getSRP());             
             DRPSZE.setText(SZEbK.getDRP()); 
        }
          
        if(selectedSZE == true){   //odabir sa ili bez Ce (sa Ce)
             SZEsaKond SZEsK = new SZEsaKond(    
                    Double.parseDouble(Ucc.getText()), 
                    Double.parseDouble(R1.getText()), 
                    Double.parseDouble(R2.getText()),
                    Double.parseDouble(Rc.getText()),
                    Double.parseDouble(Re.getText()), 
                    Double.parseDouble(hfe.getText()), 
                    Double.parseDouble(Rt.getText()), 
                    Double.parseDouble(Rg.getText()), 
                    Double.parseDouble(Ubeq.getText()), 
                    Double.parseDouble(Uul.getText()));
            
             Ubb.setText(String.format("%.2f", SZEsK.getUbb()));
             Rbb.setText(String.format("%.2f", SZEsK.getRbb()));
             Ibq.setText(String.format("%.2f", SZEsK.getIbqua()));
             Icq.setText(String.format("%.2f", SZEsK.getIcqma()));
             Uceq.setText(String.format("%.2f", SZEsK.getUceq()));
             Av.setText(String.format("%.2f", SZEsK.getAv()));
             Hie.setText(String.format("%.2f", SZEsK.getHie()));
             Ubb.setText(String.format("%.2f", SZEsK.getUbb()));
             Rul.setText(String.format("%.2f", SZEsK.getRul()));
             Rizl.setText(String.format("%.2f", SZEsK.getRizl()));
             Ai.setText(String.format("%.2f", SZEsK.getAi()));
             Uizl.setText(String.format("%.2f", SZEsK.getUizl()));
             SRPSZE.setText(SZEsK.getSRP());             
             DRPSZE.setText(SZEsK.getDRP());             
        }           
         
    }   
    
    @FXML
    private void handleButtonActionClearSZE(ActionEvent event){
        Ubb.clear();
        Rbb.clear();
        Ibq.clear();
        Icq.clear();
        Uceq.clear();
        Av.clear();
        Ai.clear();
        Hie.clear();
        Rul.clear();
        Rizl.clear();
        
        Ucc.clear();
        R1.clear();
        R2.clear();
        Rc.clear();
        Re.clear();
        hfe.clear();
        Rt.clear();
        Rg.clear();
        Ubeq.setText("0.7");
        
        Uul.setText("0");
        Uizl.clear();
        
        DRPSZE.clear();
        SRPSZE.clear(); 
    }

    @FXML
    private void Return(ActionEvent event) throws IOException{
         Parent home_page_parent = FXMLLoader.load(getClass().getResource("/tranzpojacnew/MainMenuFXML.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        app_stage.setScene(home_page_scene);
        app_stage.show();
        
        stageSZE.close();
        openSZEshema = false;
        stageSZEgraf.close();
        openGrafSZE = false;    
    }
  
    
//    otvarnje u istom prozoru    
//    @FXML
//    private void Shema(ActionEvent event) throws IOException{
//         Parent home_page_parent = FXMLLoader.load(getClass().getResource("SzeShemaFXML.fxml"));
//            Scene home_page_scene = new Scene(home_page_parent);
//            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        
//        app_stage.setScene(home_page_scene);
//        app_stage.show();
//    }
    

    // otvaranje u novom prozoru
    public static Stage stageSZE;
    public boolean openSZEshema;
    @FXML
    public void Shema(ActionEvent event) throws Exception {               
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/tranzpojacnew/Resources/SZE/Shema/SzeShemaFXML.fxml"));
                if(openSZEshema==false){               
                Parent root1 = (Parent) fxmlLoader.load();
                stageSZE = new Stage();
                stageSZE.setScene(new Scene(root1));
                //stageSZE.show();
                
             //otvaranje pokraj main screena                
                double windowGap = 5 ;
                Stage currentStage = (Stage) ReturnSZE.getScene().getWindow(); // the current window...

                stageSZE.setX(currentStage.getX() + currentStage.getWidth() + windowGap);
                stageSZE.setY(currentStage.getY()-6);
                stageSZE.show();
                openSZEshema = true;
                }
                //kad se prozor zatvara na defaultni Close, "open" se postavlja na false
                stageSZE.setOnCloseRequest(new EventHandler<WindowEvent>() {
                    @Override
                    public void handle(WindowEvent we) {
                    //System.out.println("Stage is closing");
                    openSZEshema = false;
                    }
                });
    } 
    
    
        // otvaranje u novom prozoru
    public static Stage stageSZEgraf;
    public boolean openGrafSZE;
    @FXML
    public void Graf(ActionEvent event) throws Exception {               
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/tranzpojacnew/Resources/SZE/Graf/GrafSzeFXML.fxml"));
                if(openGrafSZE==false){               
                Parent root1 = (Parent) fxmlLoader.load();
                stageSZEgraf = new Stage();
                stageSZEgraf.setScene(new Scene(root1));
                stageSZEgraf.show();
                
             //otvaranje pokraj main screena                
                double windowGap = 5 ;
                Stage currentStage = (Stage) ReturnSZE.getScene().getWindow(); // the current window...

                stageSZEgraf.setX(currentStage.getX() - currentStage.getWidth() - 18);
                stageSZEgraf.setY(currentStage.getY()-6);
                stageSZEgraf.show();
                openGrafSZE = true;
                }
                //kad se prozor zatvara na defaultni Close, "open" se postavlja na false
                stageSZEgraf.setOnCloseRequest(new EventHandler<WindowEvent>() {
                    @Override
                    public void handle(WindowEvent we) {
                    //System.out.println("Stage is closing");
                    openGrafSZE = false;
                    }
                });
    }
         
}

