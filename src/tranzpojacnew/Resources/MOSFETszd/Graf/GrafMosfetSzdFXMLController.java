/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tranzpojacnew.Resources.MOSFETszd.Graf;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import tranzpojacnew.Resources.MOSFETszd.MOSFETszdFXMLController;

/**
 * FXML Controller class
 *
 * @author Matija
 */
public class GrafMosfetSzdFXMLController extends MOSFETszdFXMLController implements Initializable {
    @FXML
    private LineChart<Integer, Integer> chartSZD;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        chartSZD.getData().clear();
               
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
        while ((MOSFETszd.getRdRs()*n+MOSFETszd.getUddRdRs()) >= -1){
            String xVal = String.format("%.1f", n);
            SRP.getData().add(new XYChart.Data(xVal, (MOSFETszd.getRdRs()*n+MOSFETszd.getUddRdRs())));
            n = n + 0.1;
        }
        
        double m = 0;
        while ((MOSFETszd.getRdRt()*m + MOSFETszd.getIdqudsq()) >= -1){
            String yVal = String.format("%.1f", m);
            DRP.getData().add(new XYChart.Data(yVal, (MOSFETszd.getRdRt()*m + MOSFETszd.getIdqudsq())));
            m = m + 0.1;
        }
        
        chartSZD.setCreateSymbols(false);
        chartSZD.setAnimated(false);
        chartSZD.getData().add(SRP);
        chartSZD.getData().add(DRP);
  
    }    
    
}
