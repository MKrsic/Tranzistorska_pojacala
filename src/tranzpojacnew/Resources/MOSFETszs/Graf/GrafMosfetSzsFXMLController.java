/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tranzpojacnew.Resources.MOSFETszs.Graf;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import tranzpojacnew.Resources.MOSFETszs.MOSFETszsFXMLController;

/**
 * FXML Controller class
 *
 * @author Matija
 */
public class GrafMosfetSzsFXMLController extends MOSFETszsFXMLController implements Initializable {
    @FXML
    private LineChart<Integer, Integer> chartSZS1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        if(selectedSZSMosfet == true){
        chartSZS1.getData().clear();
               
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
        while ((MOSFETsK.getRdRs()*n+MOSFETsK.getUddRdRs()) >= 0){
            String xVal = String.format("%.1f", n);
            SRP.getData().add(new XYChart.Data(xVal, (MOSFETsK.getRdRs()*n+MOSFETsK.getUddRdRs())));
            n = n + 0.1;
        }
        
        double m = 0;
        while ((MOSFETsK.getRdRt()*m + MOSFETsK.getIdqudsq()) >= 0){
            String yVal = String.format("%.1f", m);
            DRP.getData().add(new XYChart.Data(yVal, (MOSFETsK.getRdRt())*m + MOSFETsK.getIdqudsq()));
            m = m + 0.1;
        }
        
        chartSZS1.setCreateSymbols(false);
        chartSZS1.setAnimated(false);
        chartSZS1.getData().add(SRP);
        chartSZS1.getData().add(DRP);
        }
        
        if(selectedSZSMosfet == false){
            chartSZS1.getData().clear();
               
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
        while ((MOSFETbK.getRdRs()*n+MOSFETbK.getUddRdRs()) >= 0){
            String xVal = String.format("%.1f", n);
            SRP.getData().add(new XYChart.Data(xVal, (MOSFETbK.getRdRs()*n+MOSFETbK.getUddRdRs())));
            n = n + 0.1;
        }
        
        double m = 0;
        while ((MOSFETbK.getRdRt()*m + MOSFETbK.getIdqudsq()) >= 0){
            String yVal = String.format("%.1f", m);
            DRP.getData().add(new XYChart.Data(yVal, (MOSFETbK.getRdRt())*m + MOSFETbK.getIdqudsq()));
            m = m + 0.1;
        }
        
        chartSZS1.setCreateSymbols(false);
        chartSZS1.setAnimated(false);
        chartSZS1.getData().add(SRP);
        chartSZS1.getData().add(DRP);
        }
    }    
    
}
