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
    private Button ShemaSzeShow;
    @FXML
    private Button SzeGraf;

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
    }

    @FXML
    private void handleButtonActionCalculateSZSMosfet(ActionEvent event) {
    }

    @FXML
    private void handleCheckBoxKondCs1(ActionEvent event) {
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
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/tranzpojacnew/Resources/SZE/Graf/GrafSzeFXML.fxml"));
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
