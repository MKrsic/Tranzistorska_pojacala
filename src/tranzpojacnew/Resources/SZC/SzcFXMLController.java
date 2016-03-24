/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tranzpojacnew.Resources.SZC;

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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import tranzpojacnew.Tranzistori.Bipolarni.SZC.SZC;

/**
 * FXML Controller class
 *
 * @author Matija
 */
public class SzcFXMLController implements Initializable {
    @FXML
    private TextField Uul1;
    @FXML
    private TextField Uizl1;
    @FXML
    private TextField SRPSZC;
    @FXML
    private TextField DRPSZC;
    @FXML
    private TextField Ucc1;
    @FXML
    private TextField R11;
    @FXML
    private TextField R21;
    @FXML
    private TextField Re1;
    @FXML
    private TextField hfe1;
    @FXML
    private TextField Rt1;
    @FXML
    private TextField Rg1;
    @FXML
    private TextField Ubeq1;
    @FXML
    private TextField Ubb1;
    @FXML
    private TextField Rbb1;
    @FXML
    private TextField Ibq1;
    @FXML
    private TextField Icq1;
    @FXML
    private TextField Uceq1;
    @FXML
    private TextField Hie1;
    @FXML
    private TextField Rul1;
    @FXML
    private TextField Rizl1;
    @FXML
    private TextField Av1;
    @FXML
    private TextField Ai1;
    @FXML
    private Button ReturnSZC;

    public static SZC SZC;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Return(ActionEvent event) throws IOException{
         Parent home_page_parent = FXMLLoader.load(getClass().getResource("/tranzpojacnew/MainMenuFXML.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        app_stage.setScene(home_page_scene);
        app_stage.show();
        
        stageSZC.close();
        openSZCshema = false;
        stageSZCgraf.close();
        openGrafSZC = false; 
    }
    
     @FXML
    private void handleButtonActionCalculateSZC(ActionEvent event) {
         SZC = new SZC(
                Double.parseDouble(Ucc1.getText()), 
                Double.parseDouble(R11.getText()), 
                Double.parseDouble(R21.getText()), 
                Double.parseDouble(Re1.getText()), 
                Double.parseDouble(hfe1.getText()), 
                Double.parseDouble(Rt1.getText()), 
                Double.parseDouble(Rg1.getText()), 
                Double.parseDouble(Ubeq1.getText()), 
                Double.parseDouble(Uul1.getText()));
                
        Ubb1.setText(String.format("%.2f", SZC.getUbb()));
        Rbb1.setText(String.format("%.2f", SZC.getRbb()));
        Ibq1.setText(String.format("%.2f", SZC.getIbqua()));
        Icq1.setText(String.format("%.2f", SZC.getIcqma()));
        Uceq1.setText(String.format("%.2f", SZC.getUceq()));
        Av1.setText(String.format("%.2f", SZC.getAv()));
        Hie1.setText(String.format("%.2f", SZC.getHie()));
        Rul1.setText(String.format("%.2f", SZC.getRul()));
        Rizl1.setText(String.format("%.2f", SZC.getRizl()));
        Ai1.setText(String.format("%.2f", SZC.getAi()));
        Uizl1.setText(String.format("%.2f", SZC.getUizl()));
        SRPSZC.setText(SZC.getSRP());             
        DRPSZC.setText(SZC.getDRP());             
    }
    
    // otvaranje u novom prozoru
    public static Stage stageSZC;
    public boolean openSZCshema;
    @FXML
    public void Shema(ActionEvent event) throws Exception { 
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/tranzpojacnew/Resources/SZC/Shema/SZCshemaFXML.fxml"));
                if(openSZCshema==false){               
                Parent root1 = (Parent) fxmlLoader.load();
                stageSZC = new Stage();
                stageSZC.setScene(new Scene(root1));
                //stageSZE.show();
                
             //otvaranje pokraj main screena                
                double windowGap = 5 ;
                Stage currentStage = (Stage) ReturnSZC.getScene().getWindow(); // the current window...

                stageSZC.setX(currentStage.getX() + currentStage.getWidth() + windowGap);
                stageSZC.setY(currentStage.getY()-6);
                stageSZC.show();
                openSZCshema = true;
                }
                //kad se prozor zatvara na defaultni Close, "open" se postavlja na false
                stageSZC.setOnCloseRequest(new EventHandler<WindowEvent>() {
                    @Override
                    public void handle(WindowEvent we) {
                    //System.out.println("Stage is closing");
                    openSZCshema = false;
                    }
                });
    } 
    
    
        // otvaranje u novom prozoru
    public static Stage stageSZCgraf;
    public boolean openGrafSZC;
    @FXML
    public void Graf(ActionEvent event) throws Exception {               
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/tranzpojacnew/Resources/SZE/Graf/GrafSzeFXML.fxml"));
                if(openGrafSZC==false){               
                Parent root1 = (Parent) fxmlLoader.load();
                stageSZCgraf = new Stage();
                stageSZCgraf.setScene(new Scene(root1));
                stageSZCgraf.show();
                
             //otvaranje pokraj main screena                
                double windowGap = 5 ;
                Stage currentStage = (Stage) ReturnSZC.getScene().getWindow(); // the current window...

                stageSZCgraf.setX(currentStage.getX() - currentStage.getWidth() - 18);
                stageSZCgraf.setY(currentStage.getY()-6);
                stageSZCgraf.show();
                openGrafSZC = true;
                }
                //kad se prozor zatvara na defaultni Close, "open" se postavlja na false
                stageSZCgraf.setOnCloseRequest(new EventHandler<WindowEvent>() {
                    @Override
                    public void handle(WindowEvent we) {
                    //System.out.println("Stage is closing");
                    openGrafSZC = false;
                    }
                });
    }
    
    @FXML
    private void handleButtonActionClearSZC(ActionEvent event){
        Ubb1.clear();
        Rbb1.clear();
        Ibq1.clear();
        Icq1.clear();
        Uceq1.clear();
        Av1.clear();
        Ai1.clear();
        Hie1.clear();
        Rul1.clear();
        Rizl1.clear();
        
        Ucc1.clear();
        R11.clear();
        R21.clear();
        Re1.clear();
        hfe1.clear();
        Rt1.clear();
        Rg1.clear();
        Ubeq1.setText("0.7");
        
        Uul1.setText("0");
        Uizl1.clear();
        
        DRPSZC.clear();
        SRPSZC.clear();
    }
    
}
