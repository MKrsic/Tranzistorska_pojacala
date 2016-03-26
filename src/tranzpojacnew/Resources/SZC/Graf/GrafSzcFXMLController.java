/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tranzpojacnew.Resources.SZC.Graf;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import tranzpojacnew.Resources.SZC.SzcFXMLController;

/**
 * FXML Controller class
 *
 * @author MatijaKrsic
 */
public class GrafSzcFXMLController extends SzcFXMLController implements Initializable {
    @FXML
    private LineChart<Integer, Integer> ChartSZC;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {        
        ChartSZC.getData().clear();
               
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
        while ((SZC.getReRec()*n+SZC.getUccRe()) >= 0){
            String xVal = String.format("%.1f", n);
            SRP.getData().add(new XYChart.Data(xVal, (SZC.getReRec()*n+SZC.getUccRe())));
            n = n + 0.1;
        }
        
        double m = 0;
        while ((SZC.getReRt()*m + SZC.getIcquceq()) >= 0){
            String yVal = String.format("%.1f", m);
            DRP.getData().add(new XYChart.Data(yVal, (SZC.getReRt()*m + SZC.getIcquceq())));
            m = m + 0.1;
        }
        
        ChartSZC.setCreateSymbols(false);
        ChartSZC.setAnimated(false);
        ChartSZC.getData().add(SRP);
        ChartSZC.getData().add(DRP);
    }    
    
}
