/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author HIMATIFYES
 */
public class ImgChartFXML3FXMLController implements Initializable {

    @FXML
    private Pane pane;
    @FXML
    private LineChart<Number, Number> SimilarityChart;
    @FXML
    private NumberAxis yAxis;
    @FXML
    private CategoryAxis xAxis;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       int count = new File("E:\\semester 6\\TA2\\SimulatorMetadata_TA07\\SimulatorMetadata_TA07\\result\\image")
                .list().length;
        System.out.println(count);
        float[] avalue = new float[count];
        XYChart.Series series = new XYChart.Series<>();
        for (int i = 0; i < count; i++){
            try {
                //read file
                File inFile = new File("E:\\semester 6\\TA2\\SimulatorMetadata_TA07\\SimulatorMetadata_TA07\\result\\image\\Output" + (i+1) + ".txt");
                FileReader myFileReader = new FileReader(inFile);
                BufferedReader myBufReader = new BufferedReader(myFileReader);
                
                String line = myBufReader.readLine();
                avalue[i] = Float.parseFloat(line);
                System.out.println(avalue[i]);
                series.getData().add(new XYChart.Data(Integer.toString(i+1), avalue[i]));
                
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        SimilarityChart.getData().addAll(series);
    }    
    
}