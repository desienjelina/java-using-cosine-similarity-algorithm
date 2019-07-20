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
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.tvOriImage;
import model.tvRevImage;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.jpeg.JpegParser;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.value.ChangeListener;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author Desi Enjelina Lubis;
 */
public class MetadataImageFXMLController implements Initializable {

    @FXML
    private Pane pane;
    @FXML
    private Button srcOriImg;
    @FXML
    private Button srcRevImg;
    @FXML
    private TableView<tvOriImage> tvOriImage;
    @FXML
    private TableColumn<tvOriImage, String> created_dateOri;
    @FXML
    private TableColumn<tvOriImage, String> image_heightOri;
    @FXML
    private TableColumn<tvOriImage, String> image_widthOri;
    @FXML
    private TableColumn<tvOriImage, String> image_sizeOri;
    @FXML
    private TableColumn<tvRevImage, String> created_dateRev;
    @FXML
    private TableColumn<tvRevImage, String> image_heightRev;
    @FXML
    private TableColumn<tvRevImage, String> image_widthRev;
    @FXML
    private TableColumn<tvRevImage, String> image_sizeRev;
    @FXML
    private TableView<tvRevImage> tvRevImage;

//    private AnchorPane apane;
//    private AnchorPane apane2;
    ObservableList<tvOriImage> ol_OriImg;
    ObservableList<tvRevImage> ol_RevImg;
//    ResultSet rs_OriImg;
//    ResultSet rs_RevImg;

    //Ori Image
//    String oriImageFileLoc[];
//    String createdDateOri[];
//    String imageHeightOri[];
//    String imageWidthOri[];
//    String imageSizeOri[];
    
    String oriImageFileLoc = "";
    String createdDateOri = "";
    String imageHeightOri = "";
    String imageWidthOri = "";
    String imageSizeOri = "";

    //Recovery Image
    String revImageFileLoc = "";
    String createdDateRev = "";
    String imageHeightRev = "";
    String imageWidthRev = "";
    String imageSizeRev = "";

    private static final String FILE_PATH_1 = "E:\\semester 6\\TA2\\SimulatorMetadata_TA07\\SimulatorMetadata_TA07\\ori\\image\\oriImage1.txt";
    private static final String FILE_PATH_2 = "E:\\semester 6\\TA2\\SimulatorMetadata_TA07\\SimulatorMetadata_TA07\\ori\\image\\oriImage2.txt";
    ObservableList<TablePosition> selectedCells = FXCollections.observableArrayList();
    int countOri = 1;
    int countRev = 1;

    @FXML
    private Button importOriImage;
    @FXML
    private Button importRevImage;
    @FXML
    private Button btnCompareMetadataImg;
    private Window stage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ol_OriImg = FXCollections.observableArrayList();
        ol_RevImg = FXCollections.observableArrayList();
    }

    @FXML
    private void srcOriImgAction(ActionEvent event) {
        FileChooser fcOri = new FileChooser();
        fcOri.setInitialDirectory(new File("E:\\semester 6\\TA2\\SimulatorMetadata_TA07\\SimulatorMetadata_TA07\\DataDummyTA\\IMG\\Ori"));
        fcOri.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image files", "*.JPG"));
        //File selectedFile = fcOri.showOpenDialog(null);
        List<File> list
                = fcOri.showOpenMultipleDialog(stage);

        if (list != null) {
            for (File file : list) {
                open(file);
            }
        }
    }

    private void open(File file) {
        oriImageFileLoc = file.getAbsolutePath();
        getMetadataOriImg(oriImageFileLoc);

        if (oriImageFileLoc != null) {
            tvOriImage.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        }
    }

    @FXML
    private void srcRevImgAction(ActionEvent event) {
        FileChooser fcRev = new FileChooser();
        fcRev.setInitialDirectory(new File("E:\\semester 6\\TA2\\SimulatorMetadata_TA07\\SimulatorMetadata_TA07\\DataDummyTA\\IMG\\Rev"));
        fcRev.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image files", "*.JPG"));
        File selectedFile = fcRev.showOpenDialog(null);
        if (selectedFile != null) {
            revImageFileLoc = selectedFile.getAbsolutePath();
            getMetadataRevImg(revImageFileLoc);
        } else {
            System.out.println("file is not valid");
        }

    }

    private void getMetadataOriImg(String oriImageFileLoc) {
        try {
            InputStream input = new FileInputStream(new File(oriImageFileLoc));
            ContentHandler handler = new DefaultHandler();
            Metadata metadata = new Metadata();
            Parser parser = new JpegParser();
            ParseContext parseCtx = new ParseContext();
            parser.parse(input, handler, metadata, parseCtx);
            input.close();

            createdDateOri = metadata.get("Date/Time Original");
            imageHeightOri = metadata.get("Image Height");
            imageWidthOri = metadata.get("Image Width");
            imageSizeOri = metadata.get("File Size");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (TikaException e) {
            e.printStackTrace();
        }
        setCellValueTvOriImg();
    }

    private void setCellValueTvOriImg() {
        tvOriImage tvOriImg = new tvOriImage(createdDateOri, imageHeightOri, imageWidthOri, imageSizeOri);
        created_dateOri.setCellValueFactory(new PropertyValueFactory<>("created_dateOri"));
        image_heightOri.setCellValueFactory(new PropertyValueFactory<>("image_heightOri"));
        image_widthOri.setCellValueFactory(new PropertyValueFactory<>("image_widthOri"));
        image_sizeOri.setCellValueFactory(new PropertyValueFactory<>("image_sizeOri"));

        ol_OriImg.add(tvOriImg);
        tvOriImage.setItems(ol_OriImg);
    }

    private void getMetadataRevImg(String revImageFileLoc) {
        try {
            InputStream input = new FileInputStream(new File(revImageFileLoc));
            ContentHandler handler = new DefaultHandler();
            Metadata metadata = new Metadata();
            Parser parser = new JpegParser();
            ParseContext parseCtx = new ParseContext();
            parser.parse(input, handler, metadata, parseCtx);
            input.close();

            createdDateRev = metadata.get("Date/Time Original");
            imageHeightRev = metadata.get("Image Height");
            imageWidthRev = metadata.get("Image Width");
            imageSizeRev = metadata.get("File Size");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (TikaException e) {
            e.printStackTrace();
        }
        setCellValueTvRevImg();

    }

    private void setCellValueTvRevImg() {
        tvRevImage tvRevImg = new tvRevImage(createdDateRev, imageHeightRev, imageWidthRev, imageSizeRev);
        created_dateRev.setCellValueFactory(new PropertyValueFactory<>("created_dateRev"));
        image_heightRev.setCellValueFactory(new PropertyValueFactory<>("image_heightRev"));
        image_widthRev.setCellValueFactory(new PropertyValueFactory<>("image_widthRev"));
        image_sizeRev.setCellValueFactory(new PropertyValueFactory<>("image_sizeRev"));

        ol_RevImg.add(tvRevImg);
        tvRevImage.setItems(ol_RevImg);
    }

    @FXML
    private void importOriImageAction(ActionEvent event) {
        //int filename= tvOriImage.getSelectionModel().getSelectedItems().size();
        
        ObservableList<tvOriImage> selectedItems = tvOriImage.getSelectionModel().getSelectedItems();
        
//        System.out.println(tvOriImage.getSelectionModel().getSelectedItems().size());
        
        for (int i = 0; i < tvOriImage.getSelectionModel().getSelectedItems().size(); i++) {

            try {
                FileWriter writer = new FileWriter("ori" + "\\image\\oriImage" + countOri + ".txt", true);
                //System.out.println(selectedItems.get(i).getCreated_dateOri());
                writer.write(selectedItems.get(i).getCreated_dateOri());
                writer.write(" " +selectedItems.get(i).getImage_heightOri());
                writer.write(" " +selectedItems.get(i).getImage_widthOri());
                writer.write(" " +selectedItems.get(i).getImage_sizeOri());
                writer.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

            //System.out.println(tvOriImage.getSelectionModel().getSelectedItems().get(countOri));
            countOri++;
        }

        //System.out.println(tvOriImage.getSelectionModel().getSelectedItems().get(i));
    }

    @FXML
    private void importRevImageAction(ActionEvent event) {

//return myRow;
        try {
            FileWriter writer = new FileWriter("rev" + "\\image\\revImage" + countRev + ".txt", true);
            writer.write(" " + createdDateRev);
            writer.write(" " + imageHeightRev);
            writer.write(" " + imageWidthRev);
            writer.write(" " + imageSizeRev);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        countRev++;
    }

    @FXML
    private void btnCompareMetadataImgAction(ActionEvent event) {
        try {
            AnchorPane paneRevAudio = FXMLLoader.load(getClass().getResource("/view/Lv_SimilarityImgFXML.fxml"));
            pane.getChildren().setAll(paneRevAudio);
        } catch (Exception e) {
        }
    }

//    private void getSelectedIndex() {
//        int selectedIndex = tvOriImage.getSelectionModel().getSelectedIndex();
//        if (selectedIndex >= 0) {
//            tvOriImage.getSelectionModel().getSelectedIndex();
//            System.out.println(selectedIndex);
//        }
//}
    
}
