/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tranzpojacnew.Resources.JFET.Graf;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import tranzpojacnew.Resources.JFET.JFET_FXMLController;

/**
 * FXML Controller class
 *
 * @author MatijaKrsic
 */
public class GrafJfetFXMLController extends JFET_FXMLController implements Initializable {
    @FXML
    private LineChart<Integer, Integer> chartSZS;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(selectedSZSFet == false){
            chartSZS.getData().clear();

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
            while ((JFETbK.getRdRs()*n+JFETbK.getUddRdRs()) >= -1){
                String xVal = String.format("%.1f", n);
                SRP.getData().add(new XYChart.Data(xVal, (JFETbK.getRdRs())*n+JFETbK.getUddRdRs()));
                n = n + 0.1;
            }

            double m = 0;
            while ((JFETbK.getRdRt()*m + JFETbK.getIdqudsq()) >= -1){
                String yVal = String.format("%.1f", m);
                DRP.getData().add(new XYChart.Data(yVal, (JFETbK.getRdRt()*m + JFETbK.getIdqudsq())));
                m = m + 0.1;
            }

            chartSZS.setCreateSymbols(false);
            chartSZS.setAnimated(false);
            chartSZS.getData().add(SRP);
            chartSZS.getData().add(DRP);
        }
        
        if(selectedSZSFet == true){
            chartSZS.getData().clear();

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
            while ((JFETsK.getRdRs()*n+JFETsK.getUddRdRs()) >= -1){
                String xVal = String.format("%.1f", n);
                SRP.getData().add(new XYChart.Data(xVal, (JFETsK.getRdRs())*n+JFETsK.getUddRdRs()));
                n = n + 0.1;
            }

            double m = 0;
            while ((JFETsK.getRdRt()*m + JFETsK.getIdqudsq()) >= -1){
                String yVal = String.format("%.1f", m);
                DRP.getData().add(new XYChart.Data(yVal, (JFETsK.getRdRt()*m + JFETsK.getIdqudsq())));
                m = m + 0.1;
            }

            chartSZS.setCreateSymbols(false);
            chartSZS.setAnimated(false);
            chartSZS.getData().add(SRP);
            chartSZS.getData().add(DRP);
        }
    }
    
    
    
}
