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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import model.tvOriAudio;
import model.tvOriVideo;
import model.tvRevAudio;
import model.tvRevVideo;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.mp4.MP4Parser;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * FXML Controller class
 *
 * @author Desi Enjelina Lubis;
 */
public class MetadataVideoFXMLController implements Initializable {

    @FXML
    private Pane pane;
    @FXML
    private Button srcOriVideo;
    @FXML
    private TableView<tvOriVideo> tvOriVideo;
    @FXML
    private Button importOriVideo;
    @FXML
    private Button srcRevVideo;
    @FXML
    private TableView<tvRevVideo> tvRevVideo;
    @FXML
    private TableColumn<tvOriVideo, String> creation_dateIdOri;
    @FXML
    private TableColumn<tvOriVideo, String> modified_dateIdOri;
    @FXML
    private TableColumn<tvOriVideo, String> sample_rateIdOri;
    @FXML
    private TableColumn<tvOriVideo, String> durationIdOri;
    @FXML
    private TableColumn<tvOriVideo, String> image_lengthIdOri;
    @FXML
    private TableColumn<tvOriVideo, String> image_widthIdOri;
    @FXML
    private Button importRevVideo;
    @FXML
    private TableColumn<tvRevVideo, String> creation_dateIdRev;
    @FXML
    private TableColumn<tvRevVideo, String> modified_dateIdRev;
    @FXML
    private TableColumn<tvRevVideo, String> sample_rateIdRev;
    @FXML
    private TableColumn<tvRevVideo, String> durationIdRev;
    @FXML
    private TableColumn<tvRevVideo, String> image_lengthIdRev;
    @FXML
    private TableColumn<tvRevVideo, String> image_widthIdRev;

    ObservableList<tvOriVideo> ol_OriVideo;
    ObservableList<tvRevVideo> ol_RevVideo;

    //Ori Video
    String oriVideoFileLoc = "";
    String creationDateOri = "";
    String modifiedDateOri = "";
    String sampleRateOri = "";
    String durationOri = "";
    String imageLengthOri = "";
    String imageWidthOri = "";

    //Rev Video
    String revVideoFileLoc = "";
    String creationDateRev = "";
    String modifiedDateRev = "";
    String sampleRateRev = "";
    String durationRev = "";
    String imageLengthRev = "";
    String imageWidthRev = "";

    int countOri = 1;
    int countRev = 1;

    @FXML
    private BorderPane border_pane;
    @FXML
    private Button btnCompareMetadataVideo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ol_OriVideo = FXCollections.observableArrayList();
        ol_RevVideo = FXCollections.observableArrayList();
    }

    @FXML
    private void srcOriVideoAction(ActionEvent event) {
        FileChooser fcOri = new FileChooser();
        fcOri.setInitialDirectory(new File("E:\\semester 6\\TA2\\SimulatorMetadata_TA07\\SimulatorMetadata_TA07\\DataDummyTA\\MP4\\Ori"));
        fcOri.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Video files", "*.mp4"));

        File selectedFile = fcOri.showOpenDialog(null);
        if (selectedFile != null) {
            oriVideoFileLoc = selectedFile.getAbsolutePath();
            getMetadataOriVideo(oriVideoFileLoc);
        } else {
            System.out.println("file is not valid");
        }
        
    }

    @FXML
    private void srcRevVideoAction(ActionEvent event) {
        FileChooser fcRev = new FileChooser();
        fcRev.setInitialDirectory(new File("E:\\semester 6\\TA2\\SimulatorMetadata_TA07\\SimulatorMetadata_TA07\\DataDummyTA\\MP4\\Rev"));
        fcRev.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Video files", "*.mp4"));

        File selectedFile = fcRev.showOpenDialog(null);
        if (selectedFile != null) {
            oriVideoFileLoc = selectedFile.getAbsolutePath();
            getMetadataRevVideo(oriVideoFileLoc);
        } else {
            System.out.println("file is not valid");
        }
        

    }

    private void getMetadataOriVideo(String oriVideoFileLoc) {
        try {
            InputStream input = new FileInputStream(new File(oriVideoFileLoc));
            ContentHandler handler = new DefaultHandler();
            Metadata metadata = new Metadata();
            Parser parser = new MP4Parser();
            ParseContext parseCtx = new ParseContext();
            parser.parse(input, handler, metadata, parseCtx);
            input.close();

            creationDateOri = metadata.get("Creation-Date");
            modifiedDateOri = metadata.get("dcterms:modified");
            sampleRateOri = metadata.get("xmpDM:audioSampleRate");
            durationOri = metadata.get("xmpDM:duration");
            imageLengthOri = metadata.get("tiff:ImageLength");
            imageWidthOri = metadata.get("tiff:ImageWidth");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (TikaException e) {
            e.printStackTrace();
        }

        setCellValueOriVideo();
    }

    private void setCellValueOriVideo() {
        tvOriVideo tvOriVid = new tvOriVideo(creationDateOri, modifiedDateOri, sampleRateOri, durationOri, imageLengthOri, imageWidthOri);
        creation_dateIdOri.setCellValueFactory(new PropertyValueFactory<>("creation_dateOri"));
        modified_dateIdOri.setCellValueFactory(new PropertyValueFactory<>("modified_dateOri"));
        sample_rateIdOri.setCellValueFactory(new PropertyValueFactory<>("sample_rateOri"));
        durationIdOri.setCellValueFactory(new PropertyValueFactory<>("durationOri"));
        image_lengthIdOri.setCellValueFactory(new PropertyValueFactory<>("image_lengthOri"));
        image_widthIdOri.setCellValueFactory(new PropertyValueFactory<>("image_widthOri"));

        ol_OriVideo.add(tvOriVid);
        tvOriVideo.setItems(ol_OriVideo);
    }

    private void getMetadataRevVideo(String oriVideoFileLoc) {
        try {
            InputStream input = new FileInputStream(new File(oriVideoFileLoc));
            ContentHandler handler = new DefaultHandler();
            Metadata metadata = new Metadata();
            Parser parser = new MP4Parser();
            ParseContext parseCtx = new ParseContext();
            parser.parse(input, handler, metadata, parseCtx);
            input.close();

            creationDateRev = metadata.get("Creation-Date");
            modifiedDateRev = metadata.get("dcterms:modified");
            sampleRateRev = metadata.get("xmpDM:audioSampleRate");
            durationRev = metadata.get("xmpDM:duration");
            imageLengthRev = metadata.get("tiff:ImageLength");
            imageWidthRev = metadata.get("tiff:ImageWidth");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (TikaException e) {
            e.printStackTrace();
        }

        setCellValueRevVideo();
    }

    private void setCellValueRevVideo() {
        tvRevVideo tvRevVid = new tvRevVideo(creationDateRev, modifiedDateRev, sampleRateRev, durationRev, imageLengthRev, imageWidthRev);
        creation_dateIdRev.setCellValueFactory(new PropertyValueFactory<>("creation_dateRev"));
        modified_dateIdRev.setCellValueFactory(new PropertyValueFactory<>("modified_dateRev"));
        sample_rateIdRev.setCellValueFactory(new PropertyValueFactory<>("sample_rateRev"));
        durationIdRev.setCellValueFactory(new PropertyValueFactory<>("durationRev"));
        image_lengthIdRev.setCellValueFactory(new PropertyValueFactory<>("image_lengthRev"));
        image_widthIdRev.setCellValueFactory(new PropertyValueFactory<>("image_widthRev"));

        ol_RevVideo.add(tvRevVid);
        tvRevVideo.setItems(ol_RevVideo);
    }

    @FXML
    private void btnCompareMetadataVideoAction(ActionEvent event) {
        try {
            AnchorPane paneRevVideo = FXMLLoader.load(getClass().getResource("/view/LvSimilarityVideoFXML.fxml"));
            pane.getChildren().setAll(paneRevVideo);
        } catch (Exception e) {
        }
    }

    @FXML
    private void importOriVideoAction(ActionEvent event) {
        try {
            FileWriter writer = new FileWriter("ori" + "\\video\\oriVideo" + countOri + ".txt", true);
            writer.write(creationDateOri);
            writer.write(" " + modifiedDateOri);
            writer.write(" " + sampleRateOri);
            writer.write(" " + durationOri);
            writer.write(" " + imageLengthOri);
            writer.write(" " + imageWidthOri);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        countOri++;
    }

    @FXML
    private void importRevVideoAction(ActionEvent event) {
        try {
            FileWriter writer = new FileWriter("rev" + "\\video\\revVideo" + countRev + ".txt", true);
            writer.write(creationDateRev);
            writer.write(" " + modifiedDateRev);
            writer.write(" " + sampleRateRev);
            writer.write(" " + durationRev);
            writer.write(" " + imageLengthRev);
            writer.write(" " + imageWidthRev);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        countRev++;
    }

}
