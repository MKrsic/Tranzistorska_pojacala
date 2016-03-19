/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tranzpojacnew;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

/**
 * FXML Controller class
 *
 * @author Matija
 */
public class GrafSzeFXMLController extends SzeFXMLController implements Initializable {
    @FXML
    private LineChart<Integer, Integer> chartSZE;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        chartSZE.getData().clear();
               
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
         
        xAxis.setLabel("uce (V)");
        yAxis.setLabel("ic (mA)");
        xAxis.setForceZeroInRange(false);
        yAxis.setForceZeroInRange(false);
        yAxis.setLowerBound(0);
        

        XYChart.Series SRP = new XYChart.Series();
        SRP.setName("Statički radni pravac");
        
        XYChart.Series DRP = new XYChart.Series();
        DRP.setName("Dinamički radni pravac");
                
        double n = 0;
        while ((SZEbK.getRcRe()*n+SZEbK.getUccRcRe()) >= -1){
            String xVal = String.format("%.1f", n);
            SRP.getData().add(new XYChart.Data(xVal, (SZEbK.getRcRe()*n+SZEbK.getUccRcRe())));
            n = n + 0.1;
        }
        
        double m = 0;
        while ((SZEbK.getRcRtRe()*m + SZEbK.getIcquceq()) >= -1){
            String yVal = String.format("%.1f", m);
            DRP.getData().add(new XYChart.Data(yVal, (SZEbK.getRcRtRe()*m + SZEbK.getIcquceq())));
            m = m + 0.1;
        }
        
        chartSZE.setCreateSymbols(false);
        chartSZE.setAnimated(false);
        chartSZE.getData().add(SRP);
        chartSZE.getData().add(DRP);
  
    }    
    
}
