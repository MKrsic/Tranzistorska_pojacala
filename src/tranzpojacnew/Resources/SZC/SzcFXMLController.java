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
    private Button Return1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Return(ActionEvent event) throws IOException{
         Parent home_page_parent = FXMLLoader.load(getClass().getResource("MainMenuFXML.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
    
}
