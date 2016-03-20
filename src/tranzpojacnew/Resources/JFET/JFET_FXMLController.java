/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tranzpojacnew.Resources.JFET;

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
public class JFET_FXMLController implements Initializable {
    @FXML
    private TextField Ugsq;
    @FXML
    private TextField Idq;
    @FXML
    private TextField Udsq;
    @FXML
    private TextField Gm;
    @FXML
    private TextField Rdizl;
    @FXML
    private TextField Av2;
    @FXML
    private TextField Rul2;
    @FXML
    private TextField Rizl2;
    @FXML
    private TextField Ai2;
    @FXML
    private TextField Udd;
    @FXML
    private TextField RG;
    @FXML
    private TextField Rd;
    @FXML
    private TextField Rs;
    @FXML
    private TextField Idss;
    @FXML
    private TextField Mi;
    @FXML
    private TextField Rt2;
    @FXML
    private TextField Rg2;
    @FXML
    private TextField Ugs0;
    @FXML
    private CheckBox checkCs;
    @FXML
    private TextField Uul2;
    @FXML
    private TextField Uizl2;
    @FXML
    private Button ReturnJFET;
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
    private void handleButtonActionClearSZSFet(ActionEvent event) {
    }

    @FXML
    private void handleButtonActionCalculateSZSFet(ActionEvent event) {
    }

    @FXML
    private void handleCheckBoxKondCs(ActionEvent event) {
    }

    @FXML
    private void Return(ActionEvent event) throws IOException{
         Parent home_page_parent = FXMLLoader.load(getClass().getResource("/tranzpojacnew/MainMenuFXML.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        app_stage.setScene(home_page_scene);
        app_stage.show();
        
        stageJFET.close();
        openJFETshema = false;
        stageJFETgraf.close();
        openGrafJFET = false;    
    }
    
    // otvaranje u novom prozoru
    public static Stage stageJFET;
    public boolean openJFETshema;
    @FXML
    public void Shema(ActionEvent event) throws Exception {               
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/tranzpojacnew/Resources/JFET/Shema/JFETshemaFXML.fxml"));
                if(openJFETshema==false){               
                Parent root1 = (Parent) fxmlLoader.load();
                stageJFET = new Stage();
                stageJFET.setScene(new Scene(root1));
                //stageSZE.show();
                
             //otvaranje pokraj main screena                
                double windowGap = 5 ;
                Stage currentStage = (Stage) ReturnJFET.getScene().getWindow(); // the current window...

                stageJFET.setX(currentStage.getX() + currentStage.getWidth() + windowGap);
                stageJFET.setY(currentStage.getY()-6);
                stageJFET.show();
                openJFETshema = true;
                }
                //kad se prozor zatvara na defaultni Close, "open" se postavlja na false
                stageJFET.setOnCloseRequest(new EventHandler<WindowEvent>() {
                    @Override
                    public void handle(WindowEvent we) {
                    //System.out.println("Stage is closing");
                    openJFETshema = false;
                    }
                });
    } 
    
    
        // otvaranje u novom prozoru
    public static Stage stageJFETgraf;
    public boolean openGrafJFET;
    @FXML
    public void Graf(ActionEvent event) throws Exception {               
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/tranzpojacnew/Resources/SZE/Graf/GrafSzeFXML.fxml"));
                if(openGrafJFET==false){               
                Parent root1 = (Parent) fxmlLoader.load();
                stageJFETgraf = new Stage();
                stageJFETgraf.setScene(new Scene(root1));
                stageJFETgraf.show();
                
             //otvaranje pokraj main screena                
                double windowGap = 5 ;
                Stage currentStage = (Stage) ReturnJFET.getScene().getWindow(); // the current window...

                stageJFETgraf.setX(currentStage.getX() - currentStage.getWidth() - 18);
                stageJFETgraf.setY(currentStage.getY()-6);
                stageJFETgraf.show();
                openGrafJFET = true;
                }
                //kad se prozor zatvara na defaultni Close, "open" se postavlja na false
                stageJFETgraf.setOnCloseRequest(new EventHandler<WindowEvent>() {
                    @Override
                    public void handle(WindowEvent we) {
                    //System.out.println("Stage is closing");
                    openGrafJFET = false;
                    }
                });
    }
    
}
