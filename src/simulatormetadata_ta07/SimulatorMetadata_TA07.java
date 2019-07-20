/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulatormetadata_ta07;

import controller.MetadataImageFXMLController;
import java.io.File;
import java.io.IOException;
import java.util.Optional;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author Desi Enjelina Lubis;
 */
public class SimulatorMetadata_TA07 extends Application {

    Stage window;
    BorderPane border_pane;

//    @Override
//    public void start(Stage stage) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("/view/MenuUtamaFXML.fxml"));
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/MenuUtamaFXML.fxml"));
        Scene scene = new Scene(root); // main menu
        stage.setScene(scene);
        stage.show();

        stage.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });

    }
//delete file from directory
//        if( MetadataImageFXMLController.deleteFile_1(FILE_PATH_1) ){
//                System.out.println("File is deleted!");
//            } else {
//                System.err.println("Failed to delete file.");
//            }
//    File directory = new File(directoryName);
//// Get all files in directory
//    File[] files = directory.listFiles();
//    for (File file : files)
//    {
//        if (!file.delete()) {
//                 System.out.println("Failed to delete " + file);
//             }
//    }

    private void closeProgram() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Simulator Metadata Multimedia File");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to exit ?");
        Optional result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            Alert keluar = new Alert(Alert.AlertType.ERROR);
            keluar.hide();
            delete_FileImgOri();
            delete_FileImgRev();
            delete_FileAudOri();
            delete_FileAudRev();
            delete_FileVidOri();
            delete_FileVidRev();
            System.exit(0);
        } else {
            alert.close();
        }

    }

    // DELETE TXT FILE IN DIRECTORY
    //1. IMG
    private void delete_FileImgOri() {
        String path = "E:\\semester 6\\TA2\\SimulatorMetadata_TA07\\SimulatorMetadata_TA07\\ori\\image";
        File file = new File(path);
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isFile() && f.exists()) {
                f.delete();
            }
        }
    }

    private void delete_FileImgRev() {
        String path = "E:\\semester 6\\TA2\\SimulatorMetadata_TA07\\SimulatorMetadata_TA07\\rev\\image";
        File file = new File(path);
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isFile() && f.exists()) {
                f.delete();
            }
        }
    }

    //2. Audio
    private void delete_FileAudOri() {
        String path = "E:\\semester 6\\TA2\\SimulatorMetadata_TA07\\SimulatorMetadata_TA07\\ori\\audio";
        File file = new File(path);
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isFile() && f.exists()) {
                f.delete();
            }
        }
    }

    private void delete_FileAudRev() {
        String path = "E:\\semester 6\\TA2\\SimulatorMetadata_TA07\\SimulatorMetadata_TA07\\rev\\audio";
        File file = new File(path);
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isFile() && f.exists()) {
                f.delete();
            }
        }
    }

    //3. Video
    private void delete_FileVidOri() {
        String path = "E:\\semester 6\\TA2\\SimulatorMetadata_TA07\\SimulatorMetadata_TA07\\ori\\video";
        File file = new File(path);
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isFile() && f.exists()) {
                f.delete();
            }
        }
    }

    private void delete_FileVidRev() {
        String path = "E:\\semester 6\\TA2\\SimulatorMetadata_TA07\\SimulatorMetadata_TA07\\rev\\video";
        File file = new File(path);
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isFile() && f.exists()) {
                f.delete();
            }
        }
    }
    
    

}
