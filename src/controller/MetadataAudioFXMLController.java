/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import model.tvOriAudio;
import model.tvOriImage;
import model.tvRevAudio;
import model.tvRevImage;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.mp3.Mp3Parser;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * FXML Controller class
 *
 * @author Desi Enjelina Lubis;
 */
public class MetadataAudioFXMLController implements Initializable {

    @FXML
    private Pane pane;
    @FXML
    private TableView<tvOriAudio> tvOriAudio;
    @FXML
    private TableColumn<tvOriAudio, String> titleIdOri;
    @FXML
    private TableColumn<tvOriAudio, String> genreIdOri;
    @FXML
    private TableColumn<tvOriAudio, String> channel_typeIdOri;
    @FXML
    private TableColumn<tvOriAudio, String> sample_rateIdOri;
    @FXML
    private TableColumn<tvOriAudio, String> durationIdOri;
    @FXML
    private TableView<tvRevAudio> tvRevAudio;
    @FXML
    private TableColumn<tvRevAudio, String> titleIdRev;
    @FXML
    private TableColumn<tvRevAudio, String> genreIdRev;
    @FXML
    private TableColumn<tvRevAudio, String> channel_typeIdRev;
    @FXML
    private TableColumn<tvRevAudio, String> sample_rateIdRev;
    @FXML
    private TableColumn<tvRevAudio, String> durationIdRev;
    @FXML
    private Button importOriAudio;
    @FXML
    private Button importRevAudio;

    ObservableList<tvOriAudio> ol_OriAudio;
    ObservableList<tvRevAudio> ol_RevAudio;

    //Ori Audio
    String oriAudioFileLoc = "";
    String titleOri = "";
    String genreOri = "";
    String sampleRateOri = "";
    String durationOri = "";
    String channelTypeOri = "";

    //Rev Audio
    String revAudioFileLoc = "";
    String titleRev = "";
    String genreRev = "";
    String sampleRateRev = "";
    String durationRev = "";
    String channelTypeRev = "";

    int countOri = 1;
    int countRev = 1;
    
    @FXML
    private Button srcOriAudio;
    @FXML
    private Button srcRevAudio;
    @FXML
    private Button btnCompareMetadataAudio;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ol_OriAudio = FXCollections.observableArrayList();
        ol_RevAudio = FXCollections.observableArrayList();
    }

    @FXML
    private void srcOriiAudioAction(ActionEvent event) {
        FileChooser fcOri = new FileChooser();
        fcOri.setInitialDirectory(new File("E:\\semester 6\\TA2\\SimulatorMetadata_TA07\\SimulatorMetadata_TA07\\DataDummyTA\\MP3\\Ori"));
        fcOri.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Video files", "*.mp3"));

        File selectedFile = fcOri.showOpenDialog(null);
        if (selectedFile != null) {
            oriAudioFileLoc = selectedFile.getAbsolutePath();
            getMetadataOriAudio(oriAudioFileLoc);
        } else {
            System.out.println("file is not valid");
        }
    }

    @FXML
    private void srcRevAudioAction(ActionEvent event) {
        
        FileChooser fcRev = new FileChooser();
        fcRev.setInitialDirectory(new File("E:\\semester 6\\TA2\\SimulatorMetadata_TA07\\SimulatorMetadata_TA07\\DataDummyTA\\MP3\\Rev"));
        fcRev.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Video files", "*.mp3"));

        File selectedFile = fcRev.showOpenDialog(null);
        if (selectedFile != null) {
            oriAudioFileLoc = selectedFile.getAbsolutePath();
            getMetadataRevAudio(oriAudioFileLoc);
        } else {
            System.out.println("file is not valid");
        }

    }

    private void getMetadataOriAudio(String oriAudioFileLoc) {
        try {
            InputStream input = new FileInputStream(new File(oriAudioFileLoc));
            ContentHandler handler = new DefaultHandler();
            Metadata metadata = new Metadata();
            Parser parser = new Mp3Parser();
            ParseContext parseCtx = new ParseContext();
            parser.parse(input, handler, metadata, parseCtx);
            input.close();

            titleOri = metadata.get("title");
            genreOri = metadata.get("xmpDM:genre");
            sampleRateOri = metadata.get("xmpDM:audioSampleRate");
            durationOri = metadata.get("xmpDM:duration");
            channelTypeOri = metadata.get("xmpDM:audioChannelType");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (TikaException e) {
            e.printStackTrace();
        }
        setCellValueOriAudio();
    }
    
    
    private void getMetadataRevAudio(String revAudioFileLoc) {
        try {
            InputStream input = new FileInputStream(new File(revAudioFileLoc));
            ContentHandler handler = new DefaultHandler();
            Metadata metadata = new Metadata();
            Parser parser = new Mp3Parser();
            ParseContext parseCtx = new ParseContext();
            parser.parse(input, handler, metadata, parseCtx);
            input.close();

            titleRev = metadata.get("title");
            genreRev = metadata.get("xmpDM:genre");
            sampleRateRev = metadata.get("xmpDM:audioSampleRate");
            durationRev = metadata.get("xmpDM:duration");
            channelTypeRev = metadata.get("xmpDM:audioChannelType");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (TikaException e) {
            e.printStackTrace();
        }
        setCellValueRevAudio();
    }

    private void setCellValueOriAudio() {
        tvOriAudio tvOriAud = new tvOriAudio(titleOri, genreOri, sampleRateOri, durationOri, channelTypeOri);
        titleIdOri.setCellValueFactory(new PropertyValueFactory<>("titleOri"));
        genreIdOri.setCellValueFactory(new PropertyValueFactory<>("genreOri"));
        sample_rateIdOri.setCellValueFactory(new PropertyValueFactory<>("sample_rateOri"));
        durationIdOri.setCellValueFactory(new PropertyValueFactory<>("durationOri"));
        channel_typeIdOri.setCellValueFactory(new PropertyValueFactory<>("channel_typeOri"));

        ol_OriAudio.add(tvOriAud);
        tvOriAudio.setItems(ol_OriAudio);
    }

    private void setCellValueRevAudio() {
        tvRevAudio tvRevAud = new tvRevAudio(titleRev, genreRev, sampleRateRev, durationRev, channelTypeRev);
        titleIdRev.setCellValueFactory(new PropertyValueFactory<>("titleRev"));
        genreIdRev.setCellValueFactory(new PropertyValueFactory<>("genreRev"));
        sample_rateIdRev.setCellValueFactory(new PropertyValueFactory<>("sample_rateRev"));
        durationIdRev.setCellValueFactory(new PropertyValueFactory<>("durationRev"));
        channel_typeIdRev.setCellValueFactory(new PropertyValueFactory<>("channel_typeRev"));

        ol_RevAudio.add(tvRevAud);
        tvRevAudio.setItems(ol_RevAudio);
    }
    
    
    @FXML
    private void importOriAudioAction(ActionEvent event) {
        try {
            FileWriter writer = new FileWriter("ori" + "\\audio\\oriAudio" + countOri + ".txt", true);
            writer.write(titleOri);
            writer.write(" " + genreOri);
            writer.write(" " + sampleRateOri);
            writer.write(" " + durationOri);
            writer.write(" " + channelTypeOri);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        countOri++;
    }

    @FXML
    private void importRevAudioAction(ActionEvent event) {
        try {
            FileWriter writer = new FileWriter("rev" + "\\audio\\revAudio" + countRev + ".txt", true);
            writer.write(titleRev);
            writer.write(" " + genreRev);
            writer.write(" " + sampleRateRev);
            writer.write(" " + durationRev);
            writer.write(" " + channelTypeRev);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        countRev++;
    }

    @FXML
    private void btnCompareMetadataAudioAction(ActionEvent event) {
        try {
            AnchorPane paneRevAudio = FXMLLoader.load(getClass().getResource("/view/Lv_SimilarityAudioFXML.fxml"));
            pane.getChildren().setAll(paneRevAudio);
        } catch (Exception e) {
        }
    }

    

    

}
