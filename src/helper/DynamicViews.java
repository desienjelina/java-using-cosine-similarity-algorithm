/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.io.IOException;
import java.io.InputStream;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Desi Enjelina Lubis;
 */
public class DynamicViews {

    private DynamicViews() {

    }

    public static void loadBorderCenter(BorderPane borderPane, String resource) throws IOException {
        Parent MenuUtama = FXMLLoader.load(new DynamicViews().getClass().getResource("/view/" + resource + ".fxml"));
        borderPane.setCenter(MenuUtama);
    }
    
    
 
}
