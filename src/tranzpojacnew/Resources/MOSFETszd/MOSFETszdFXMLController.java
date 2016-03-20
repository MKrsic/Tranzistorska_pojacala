/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tranzpojacnew.Resources.MOSFETszd;

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

/**
 * FXML Controller class
 *
 * @author Matija
 */
public class MOSFETszdFXMLController implements Initializable {
    @FXML
    private Button ReturnMOSFETszd;
    @FXML
    private Button ShemaSzeShow;
    @FXML
    private Button SzeGraf;
    @FXML
    private TextField Udd2;
    @FXML
    private TextField R13;
    @FXML
    private TextField Rs2;
    @FXML
    private TextField Mi2;
    @FXML
    private TextField Rt4;
    @FXML
    private TextField Rg4;
    @FXML
    private TextField Ugs02;
    @FXML
    private TextField K1;
    @FXML
    private TextField R23;
    @FXML
    private TextField Ugsq2;
    @FXML
    private TextField Idq2;
    @FXML
    private TextField Udsq2;
    @FXML
    private TextField Gm2;
    @FXML
    private TextField Rdizl2;
    @FXML
    private TextField Av4;
    @FXML
    private TextField Rul4;
    @FXML
    private TextField Rizl4;
    @FXML
    private TextField Ai4;
    @FXML
    private TextField Uul4;
    @FXML
    private TextField Uizl4;
    @FXML
    private TextField SRPSZE;
    @FXML
    private TextField DRPSZE;

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
        
        stageMOSFETszd.close();
        openMOSFETszdShema = false;
        stageMOSFETszdGraf.close();
        openGrafMOSFETszd = false; 
    }

    // otvaranje u novom prozoru
    public static Stage stageMOSFETszd;
    public boolean openMOSFETszdShema;
    @FXML
    public void Shema(ActionEvent event) throws Exception {               
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/tranzpojacnew/Resources/MOSFETszd/Shema/MOSFETszdShemaFXML.fxml"));
                if(openMOSFETszdShema==false){               
                Parent root1 = (Parent) fxmlLoader.load();
                stageMOSFETszd = new Stage();
                stageMOSFETszd.setScene(new Scene(root1));
                //stageSZE.show();
                
             //otvaranje pokraj main screena                
                double windowGap = 5 ;
                Stage currentStage = (Stage) ReturnMOSFETszd.getScene().getWindow(); // the current window...

                stageMOSFETszd.setX(currentStage.getX() + currentStage.getWidth() + windowGap);
                stageMOSFETszd.setY(currentStage.getY()-6);
                stageMOSFETszd.show();
                openMOSFETszdShema = true;
                }
                //kad se prozor zatvara na defaultni Close, "open" se postavlja na false
                stageMOSFETszd.setOnCloseRequest(new EventHandler<WindowEvent>() {
                    @Override
                    public void handle(WindowEvent we) {
                    //System.out.println("Stage is closing");
                    openMOSFETszdShema = false;
                    }
                });
    } 

    // otvaranje u novom prozoru
    public static Stage stageMOSFETszdGraf;
    public boolean openGrafMOSFETszd;
    @FXML
    public void Graf(ActionEvent event) throws Exception {               
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/tranzpojacnew/Resources/SZE/Graf/GrafSzeFXML.fxml"));
                if(openGrafMOSFETszd==false){               
                Parent root1 = (Parent) fxmlLoader.load();
                stageMOSFETszdGraf = new Stage();
                stageMOSFETszdGraf.setScene(new Scene(root1));
                stageMOSFETszdGraf.show();
                
             //otvaranje pokraj main screena                
                double windowGap = 5 ;
                Stage currentStage = (Stage) ReturnMOSFETszd.getScene().getWindow(); // the current window...

                stageMOSFETszdGraf.setX(currentStage.getX() - currentStage.getWidth() - 18);
                stageMOSFETszdGraf.setY(currentStage.getY()-6);
                stageMOSFETszdGraf.show();
                openGrafMOSFETszd = true;
                }
                //kad se prozor zatvara na defaultni Close, "open" se postavlja na false
                stageMOSFETszdGraf.setOnCloseRequest(new EventHandler<WindowEvent>() {
                    @Override
                    public void handle(WindowEvent we) {
                    //System.out.println("Stage is closing");
                    openGrafMOSFETszd = false;
                    }
                });
    }

    @FXML
    private void handleButtonActionClearSZDMosfet(ActionEvent event) {
    }

    @FXML
    private void handleButtonActionCalculateSZDmosfet(ActionEvent event) {
    }
    
}
