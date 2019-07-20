/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import helper.ExportHelper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Desi Enjelina Lubis;
 */
public class LvSimilarityImgFXMLController implements Initializable {

    @FXML
    private ListView lvMetadataOri;
    @FXML
    private ListView lvMetadataRev;
    @FXML
    private ListView similarityImg;
    @FXML
    private Pane pane;

    /**
     * Initializes the controller class.
     */
    //Membaca file's name
    private static final String DIR_Ori = ("E:\\semester 6\\TA2\\SimulatorMetadata_TA07\\SimulatorMetadata_TA07\\ori\\image");
    private static final String DIR_Rev = ("E:\\semester 6\\TA2\\SimulatorMetadata_TA07\\SimulatorMetadata_TA07\\rev\\image");
    private static final String DIR_Result = ("E:\\semester 6\\TA2\\SimulatorMetadata_TA07\\SimulatorMetadata_TA07\\result\\image");
    @FXML
    private Button chartImg;
    
    List<Double> sim_score;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        // start MEMBACA NAMA FILE
        File file_Ori = new File(DIR_Ori);
        File file_Rev = new File(DIR_Rev);

        File[] myFilesOri = file_Ori.listFiles();
        File[] myFilesRev = file_Rev.listFiles();

        for (File files : myFilesOri) {
            //System.out.println(files.getName());
            if (files != null) {

                lvMetadataOri.getItems().add(files.getName());

                //lvMetadataOri.getItems().add(files.getClass());
            }

        }
        for (File filess : myFilesRev) {
            //System.out.println(filess.getName());
            if (filess != null) {
                lvMetadataRev.getItems().add(filess.getName());
            }
        }
        //end of get file's name to compare

        //-----START ALGORTIMA COSINE SIMILARYTY------
        Algo_cosine_similarity cs1 = new Algo_cosine_similarity();

        System.out.println("[Word # VectorA # VectorB]");

        int count = new File("E:\\semester 6\\TA2\\SimulatorMetadata_TA07\\SimulatorMetadata_TA07\\rev\\image")
                .list().length;

        String fileNameOri, fileNameRec;
        PrintWriter results;
        File fileOri, fileRec;
        FileReader frOri, frRec;
        BufferedReader brOri, brRec;
        String lineOri, lineRec;

        for (int i = 1; i <= count; i++) {

            fileNameOri = "E:\\semester 6\\TA2\\SimulatorMetadata_TA07\\SimulatorMetadata_TA07\\ori\\image\\oriImage" + i + ".txt";
            fileNameRec = "E:\\semester 6\\TA2\\SimulatorMetadata_TA07\\SimulatorMetadata_TA07\\rev\\image\\revImage" + i + ".txt";
            //results = new PrintWriter(new FileWriter("E:\\semester 6\\TA2\\Program\\algo_cosine_similarity\\result\\image\\similarity " + i + ".txt"));

            fileOri = new File(fileNameOri);
            fileRec = new File(fileNameRec);

            try {
                frOri = new FileReader(fileOri);
                frRec = new FileReader(fileRec);

                brOri = new BufferedReader(frOri);
                brRec = new BufferedReader(frRec);

                try {
                    lineOri = brOri.readLine();
                    lineRec = brRec.readLine();

                    double sim_scores = cs1.Cosine_Similarity_Score(lineOri,
                            lineRec);
                    
                    sim_score.add(sim_scores);
                    
                    String s = String.format("%.2f", sim_score);

                    for (int j = 1; j <= i; j++) {
                        PrintStream out = new PrintStream(new FileOutputStream("E:\\semester 6\\TA2\\SimulatorMetadata_TA07\\SimulatorMetadata_TA07\\result\\image\\Output" + i + ".txt"));
                        //output to the file a line
                        out.println(s);
                    }

                    //GET LISTVIEW SIMILARITY
                    File file = new File("E:\\semester 6\\TA2\\SimulatorMetadata_TA07\\SimulatorMetadata_TA07\\result\\image\\Output" + i + ".txt");
                    long lines = Files.lines(file.toPath()).count();
                    long line = 0;
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    String x = null;
                    while ((x = reader.readLine()) != null) {
                        //similarityImg.getItems(reader);

                        similarityImg.getItems().add(x);
                        DecimalFormat df = new DecimalFormat("#.00");
                        df.format(sim_score);
                    }

                } catch (IOException ex) {
                    Logger.getLogger(Algo_cosine_similarity.class.getName()).log(Level.SEVERE, null, ex);
                }

            } catch (FileNotFoundException ex) {
                Logger.getLogger(Algo_cosine_similarity.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @FXML
    private void chartAction(ActionEvent event) {
//        try {
//            ExportHelper.exportJadwal(sim_score);
        try {
            AnchorPane paneRevVideo = FXMLLoader.load(getClass().getResource("/view/ImageChartFXML3FXML.fxml"));
            pane.getChildren().setAll(paneRevVideo);
        } catch (Exception e) {
        }
//        } catch (Exception ex) {
//            Logger.getLogger(LvSimilarityImgFXMLController.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

     

}


