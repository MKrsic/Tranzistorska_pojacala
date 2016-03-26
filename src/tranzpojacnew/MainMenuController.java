package tranzpojacnew;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *
 * @author MatijaKrsic
 */
public class MainMenuController implements Initializable {
    

    @FXML
    private Button Return;
    
    /**
     * 
     * @param event
     * @throws IOException 
     * 
     * Opens SzeFXML scene
     */
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException{
         Parent home_page_parent = FXMLLoader.load(getClass().getResource("/tranzpojacnew/Resources/SZE/SzeFXML.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        app_stage.setScene(home_page_scene);
        app_stage.setTitle("Spoj zajedničkog emitera");
        app_stage.show();
    }
    
    /**
     * 
     * @param event
     * @throws IOException
     * 
     * Opens SzcFXML scene
     */
    @FXML
    private void handleButtonAction1(ActionEvent event) throws IOException{
         Parent home_page_parent = FXMLLoader.load(getClass().getResource("/tranzpojacnew/Resources/SZC/SzcFXML.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        app_stage.setScene(home_page_scene);
        app_stage.setTitle("Spoj zajedničkog kolektora");
        app_stage.show();
    }
    
    
    /**
     * 
     * @param event
     * @throws IOException
     * 
     * Opens JFET_FXML scene
     */
    @FXML
    private void handleButtonAction2(ActionEvent event) throws IOException{
         Parent home_page_parent = FXMLLoader.load(getClass().getResource("/tranzpojacnew/Resources/JFET/JFET_FXML.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        app_stage.setScene(home_page_scene);
        app_stage.setTitle("Spoj zajedničkog source-a JFET");
        app_stage.show();
    }
    
    
    /**
     * 
     * @param event
     * @throws IOException 
     * 
     * Opens SZDmosfet scene
     */
    @FXML
    private void handleButtonAction3(ActionEvent event) throws IOException{
         Parent home_page_parent = FXMLLoader.load(getClass().getResource("/tranzpojacnew/Resources/MOSFETszd/SZDmosfet.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        app_stage.setScene(home_page_scene);
        app_stage.setTitle("Spoj zajedničkog drain-a MOSFET");
        app_stage.show();
    }
    
    /**
     * 
     * @param event
     * @throws IOException 
     * 
     * Opens SZSmosfet scene
     */
    @FXML
    private void handleButtonAction4(ActionEvent event) throws IOException{
         Parent home_page_parent = FXMLLoader.load(getClass().getResource("/tranzpojacnew/Resources/MOSFETszs/SZSmosfet.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        app_stage.setScene(home_page_scene);
        app_stage.setTitle("Spoj zajedničkog source-a MOSFET");
        app_stage.show();
    }
         
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}



