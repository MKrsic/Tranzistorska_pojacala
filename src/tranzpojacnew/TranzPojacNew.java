/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tranzpojacnew;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author MatijaKrsic
 */
public class TranzPojacNew extends Application {
    
    /**
     * 
     * @param stage
     * @throws Exception
     * 
     * Opens MainMenuFXML scene
     */
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("MainMenuFXML.fxml"));
        
        Scene scene = new Scene(root);
              
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
        stage.setTitle("Tranzistorska pojačala");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
