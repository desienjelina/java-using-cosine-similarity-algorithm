/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Desi Enjelina Lubis;
 */
public class LvSimilarityAudioFXMLController implements Initializable {

    @FXML
    private Pane pane;
    @FXML
    private ListView lvMetadataOri;
    @FXML
    private ListView lvMetadataRev;
    @FXML
    private ListView similarityAudio;

    /**
     * Initializes the controller class.
     */
    
    
            //Membaca file's name
    private static final String DIR_Ori = ("E:\\semester 6\\TA2\\SimulatorMetadata_TA07\\SimulatorMetadata_TA07\\ori\\audio");
    private static final String DIR_Rev = ("E:\\semester 6\\TA2\\SimulatorMetadata_TA07\\SimulatorMetadata_TA07\\rev\\audio");
    private static final String DIR_Result = ("E:\\semester 6\\TA2\\SimulatorMetadata_TA07\\SimulatorMetadata_TA07\\result\\audio");
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      // TODO

        // start MEMBACA NAMA FILE
        File file_Ori = new File(DIR_Ori);
        File file_Rev = new File(DIR_Rev);

        File[] myFilesOri = file_Ori.listFiles();
        File[] myFilesRev = file_Rev.listFiles();

        for (File files : myFilesOri) {
            if (files != null) {
                lvMetadataOri.getItems().add(files.getName());
            }
        }
        for (File filess : myFilesRev) {
            if (filess != null) {
                lvMetadataRev.getItems().add(filess.getName());
            }
        }
        //end of get file's name to compare

        //-----START ALGORTIMA COSINE SIMILARYTY------
        Algo_cosine_similarity cs1 = new Algo_cosine_similarity();

        System.out.println("[Word # VectorA # VectorB]");

        int count = new File("E:\\semester 6\\TA2\\SimulatorMetadata_TA07\\SimulatorMetadata_TA07\\rev\\audio")
                .list().length;

        String fileNameOri, fileNameRec;
        PrintWriter results;
        File fileOri, fileRec;
        FileReader frOri, frRec;
        BufferedReader brOri, brRec;
        String lineOri, lineRec;

        for (int i = 1; i <= count; i++) {

            fileNameOri = "E:\\semester 6\\TA2\\SimulatorMetadata_TA07\\SimulatorMetadata_TA07\\ori\\audio\\oriAudio" + i + ".txt";
            fileNameRec = "E:\\semester 6\\TA2\\SimulatorMetadata_TA07\\SimulatorMetadata_TA07\\rev\\audio\\revAudio" + i + ".txt";
            //results = new PrintWriter(new FileWriter("E:\\semester 6\\TA2\\Program\\algo_cosine_similarity\\result\\video\\similarity " + i + ".txt"));

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

                    double sim_score = cs1.Cosine_Similarity_Score(lineOri,
                            lineRec);
                    System.out.println("Cosine similarity score = " + sim_score);

                    for (int j = 1; j <= i; j++) {
                        PrintStream out = new PrintStream(new FileOutputStream("E:\\semester 6\\TA2\\SimulatorMetadata_TA07\\SimulatorMetadata_TA07\\result\\audio\\Output" + i + ".txt"));
                        //output to the file a line
                        out.println(sim_score);
                    }

                    //GET LISTVIEW SIMILARITY
                    File file = new File("E:\\semester 6\\TA2\\SimulatorMetadata_TA07\\SimulatorMetadata_TA07\\result\\audio\\Output" + i + ".txt");
                    long lines = Files.lines(file.toPath()).count();
                    long line = 0;
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    String x = null;
                    while ((x = reader.readLine()) != null) {
                        //similarityVideo.getItems(reader);
                        similarityAudio.getItems().add(x);
                    }

                } catch (IOException ex) {
                    Logger.getLogger(Algo_cosine_similarity.class.getName()).log(Level.SEVERE, null, ex);
                }

            } catch (FileNotFoundException ex) {
                Logger.getLogger(Algo_cosine_similarity.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }   
    
}
