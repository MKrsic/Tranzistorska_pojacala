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

/**
 * FXML Controller class
 *
 * @author Matija
 */
public class SzcFXMLController implements Initializable {
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
    private Button ReturnSZC;

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
    
    // otvaranje u novom prozoru
    public static Stage stageSZC;
    public boolean openSZCshema;
    @FXML
    public void Shema(ActionEvent event) throws Exception { 
        System.out.println("asknčajsgbčajsgakjsgksgjasfjzs,gaj");
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
    
}
