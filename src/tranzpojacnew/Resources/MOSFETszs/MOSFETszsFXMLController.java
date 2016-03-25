/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tranzpojacnew.Resources.MOSFETszs;

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
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import tranzpojacnew.Tranzistori.Unipolarni.MOSFETszsBezKond;
import tranzpojacnew.Tranzistori.Unipolarni.MOSFETszsSaKond;

/**
 * FXML Controller class
 *
 * @author Matija
 */
public class MOSFETszsFXMLController implements Initializable {
    @FXML
    private Button ReturnMOSFETszs;
    @FXML
    private TextField Ugsq1;
    @FXML
    private TextField Idq1;
    @FXML
    private TextField Udsq1;
    @FXML
    private TextField Gm1;
    @FXML
    private TextField Rdizl1;
    @FXML
    private TextField Av3;
    @FXML
    private TextField Rul3;
    @FXML
    private TextField Rizl3;
    @FXML
    private TextField Ai3;
    @FXML
    private TextField Udd1;
    @FXML
    private TextField R12;
    @FXML
    private TextField Rd1;
    @FXML
    private TextField Rs1;
    @FXML
    private TextField Mi1;
    @FXML
    private TextField Rt3;
    @FXML
    private TextField Rg3;
    @FXML
    private TextField Ugs01;
    @FXML
    private TextField K;
    @FXML
    private TextField R22;
    @FXML
    private CheckBox checkCs1;
    @FXML
    private TextField SRPSZS1;
    @FXML
    private TextField DRPSZS1;
    @FXML
    private TextField Uul3;
    @FXML
    private TextField Uizl3;
    @FXML
    private Button Shema;
    
    public static boolean selectedSZSMosfet;
    public static MOSFETszsSaKond MOSFETsK;
    public static MOSFETszsBezKond MOSFETbK;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Return(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/tranzpojacnew/MainMenuFXML.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        app_stage.setScene(home_page_scene);
        app_stage.show();
        
        stageMOSFETszs.close();
        openMOSFETszsShema = false;
        stageMOSFETszsGraf.close();
        openGrafMOSFETszs = false; 
    }

    @FXML
    private void handleButtonActionClearSZSMosfet(ActionEvent event) {
        Udd1.clear();
        R12.clear();
        R22.clear();
        Rd1.clear();
        Rs1.clear();
        Mi1.clear();
        Rt3.clear();
        Rg3.clear();
        Ugs01.clear();
        K.clear();   
        
        Ugsq1.clear();
        Idq1.clear();
        Udsq1.clear();
        Gm1.clear();
        Rdizl1.clear();
        Av3.clear();
        Ai3.clear();
        Rul3.clear();
        Rizl3.clear();
        
        Uul3.setText("0");
        Uizl3.clear();
        
        DRPSZS1.clear();
        SRPSZS1.clear();
    }

    @FXML
    private void handleButtonActionCalculateSZSMosfet(ActionEvent event) {
        if(selectedSZSMosfet == true){   //odabir sa ili bez Cs (sa Cs)
            MOSFETsK = new MOSFETszsSaKond(
                    Double.parseDouble(Udd1.getText()), 
                    Double.parseDouble(Ugs01.getText()), 
                    Double.parseDouble(K.getText()), 
                    Double.parseDouble(Mi1.getText()), 
                    Double.parseDouble(R12.getText()), 
                    Double.parseDouble(R22.getText()), 
                    Double.parseDouble(Rs1.getText()), 
                    Double.parseDouble(Rd1.getText()), 
                    Double.parseDouble(Rt3.getText()), 
                    Double.parseDouble(Rg3.getText()), 
                    Double.parseDouble(Uul3.getText()));
                
        Ugsq1.setText(String.format("%.2f", MOSFETsK.getUgsq()));
        Idq1.setText(String.format("%.2f", MOSFETsK.getIdq()));
        Udsq1.setText(String.format("%.2f", MOSFETsK.getUdsq()));
        Gm1.setText(String.format("%.2f", MOSFETsK.getGm()));
        Rdizl1.setText(String.format("%.2f", MOSFETsK.getRd()));
        Av3.setText(String.format("%.2f", MOSFETsK.getAv()));
        Ai3.setText(String.format("%.2f", MOSFETsK.getAi()));
        Rul3.setText(String.format("%.2f", MOSFETsK.getRul()));
        Rizl3.setText(String.format("%.2f", MOSFETsK.getRizl()));
        Uizl3.setText(String.format("%.2f", MOSFETsK.getUizl()));
        SRPSZS1.setText(MOSFETsK.getSRP());             
        DRPSZS1.setText(MOSFETsK.getDRP());
        }
        
        if(selectedSZSMosfet == false){   //odabir sa ili bez Cs (bez Cs)
            MOSFETbK = new MOSFETszsBezKond(
                    Double.parseDouble(Udd1.getText()), 
                    Double.parseDouble(Ugs01.getText()), 
                    Double.parseDouble(K.getText()), 
                    Double.parseDouble(Mi1.getText()), 
                    Double.parseDouble(R12.getText()), 
                    Double.parseDouble(R22.getText()), 
                    Double.parseDouble(Rs1.getText()), 
                    Double.parseDouble(Rd1.getText()), 
                    Double.parseDouble(Rt3.getText()), 
                    Double.parseDouble(Rg3.getText()), 
                    Double.parseDouble(Uul3.getText()));
                
        Ugsq1.setText(String.format("%.2f", MOSFETbK.getUgsq()));
        Idq1.setText(String.format("%.2f", MOSFETbK.getIdq()));
        Udsq1.setText(String.format("%.2f", MOSFETbK.getUdsq()));
        Gm1.setText(String.format("%.2f", MOSFETbK.getGm()));
        Rdizl1.setText(String.format("%.2f", MOSFETbK.getRd()));
        Av3.setText(String.format("%.2f", MOSFETbK.getAv()));
        Ai3.setText(String.format("%.2f", MOSFETbK.getAi()));
        Rul3.setText(String.format("%.2f", MOSFETbK.getRul()));
        Rizl3.setText(String.format("%.2f", MOSFETbK.getRizl()));
        Uizl3.setText(String.format("%.2f", MOSFETbK.getUizl()));
        SRPSZS1.setText(MOSFETbK.getSRP());             
        DRPSZS1.setText(MOSFETbK.getDRP());
        }
    }

    @FXML
    private void handleCheckBoxKondCs1(ActionEvent event) {
        selectedSZSMosfet = checkCs1.isSelected();
    }

    // otvaranje u novom prozoru
    public static Stage stageMOSFETszs;
    public boolean openMOSFETszsShema;
    @FXML
    public void Shema(ActionEvent event) throws Exception {               
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/tranzpojacnew/Resources/MOSFETszs/Shema/MOSFETszsShemaFXML.fxml"));
                if(openMOSFETszsShema==false){               
                Parent root1 = (Parent) fxmlLoader.load();
                stageMOSFETszs = new Stage();
                stageMOSFETszs.setScene(new Scene(root1));
                //stageSZE.show();
                
             //otvaranje pokraj main screena                
                double windowGap = 5 ;
                Stage currentStage = (Stage) ReturnMOSFETszs.getScene().getWindow(); // the current window...

                stageMOSFETszs.setX(currentStage.getX() + currentStage.getWidth() + windowGap);
                stageMOSFETszs.setY(currentStage.getY()-6);
                stageMOSFETszs.show();
                openMOSFETszsShema = true;
                }
                //kad se prozor zatvara na defaultni Close, "open" se postavlja na false
                stageMOSFETszs.setOnCloseRequest(new EventHandler<WindowEvent>() {
                    @Override
                    public void handle(WindowEvent we) {
                    //System.out.println("Stage is closing");
                    openMOSFETszsShema = false;
                    }
                });
    } 

    // otvaranje u novom prozoru
    public static Stage stageMOSFETszsGraf;
    public boolean openGrafMOSFETszs;
    @FXML
    public void Graf(ActionEvent event) throws Exception {               
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/tranzpojacnew/Resources/MOSFETszs/Graf/GrafMosfetSzsFXML.fxml"));
                if(openGrafMOSFETszs==false){               
                Parent root1 = (Parent) fxmlLoader.load();
                stageMOSFETszsGraf = new Stage();
                stageMOSFETszsGraf.setScene(new Scene(root1));
                stageMOSFETszsGraf.show();
                
             //otvaranje pokraj main screena                
                double windowGap = 5 ;
                Stage currentStage = (Stage) ReturnMOSFETszs.getScene().getWindow(); // the current window...

                stageMOSFETszsGraf.setX(currentStage.getX() - currentStage.getWidth() - 18);
                stageMOSFETszsGraf.setY(currentStage.getY()-6);
                stageMOSFETszsGraf.show();
                openGrafMOSFETszs = true;
                }
                //kad se prozor zatvara na defaultni Close, "open" se postavlja na false
                stageMOSFETszsGraf.setOnCloseRequest(new EventHandler<WindowEvent>() {
                    @Override
                    public void handle(WindowEvent we) {
                    //System.out.println("Stage is closing");
                    openGrafMOSFETszs = false;
                    }
                });
    }
    
}
