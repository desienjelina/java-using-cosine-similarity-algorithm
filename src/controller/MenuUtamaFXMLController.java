/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import helper.DynamicViews;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Desi Enjelina Lubis;
 */
public class MenuUtamaFXMLController implements Initializable {

    @FXML
    private ImageView logo;
    @FXML
    private BorderPane border_pane;
    @FXML
    private VBox root;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      Image img = new Image("/image/logo.jpg");
      logo.setImage(img);
    }    

    @FXML
    private void show_MetadataImage(MouseEvent event) throws IOException {
        DynamicViews.loadBorderCenter(border_pane, "MetadataImageFXML");
    }

    @FXML
    private void show_MetadataAudio(MouseEvent event) throws IOException {
        DynamicViews.loadBorderCenter(border_pane, "MetadataAudioFXML");
    }

    @FXML
    private void show_MetadataVideo(MouseEvent event) throws IOException {
        DynamicViews.loadBorderCenter(border_pane, "MetadataVideoFXML");
    }

    //back to beranda. kasi id yang mau ditunjukkan
    @FXML
    private void show_MenuUtama(MouseEvent event) throws IOException {
    border_pane.setCenter(root);
    
    }
    
}
