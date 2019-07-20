/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Desi Enjelina Lubis;
 */
public class tvOriImage {
    //private String oriImageFileLoc;
    private String created_dateOri;
    private String image_heightOri;
    private String image_widthOri;
    private String image_sizeOri;

    public tvOriImage() {
    }

    public tvOriImage(String created_dateOri, String image_heightOri, String image_widthOri, String image_sizeOri) {
        this.created_dateOri = created_dateOri;
        this.image_heightOri = image_heightOri;
        this.image_widthOri = image_widthOri;
        this.image_sizeOri = image_sizeOri;
    }

    public tvOriImage(String[] createdDateOri, String[] imageHeightOri, String[] imageWidthOri, String[] imageSizeOri) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getCreated_dateOri() {
        return created_dateOri;
    }

    public void setCreated_dateOri(String created_dateOri) {
        this.created_dateOri = created_dateOri;
    }

    public String getImage_heightOri() {
        return image_heightOri;
    }

    public void setImage_heightOri(String image_heightOri) {
        this.image_heightOri = image_heightOri;
    }

    public String getImage_widthOri() {
        return image_widthOri;
    }

    public void setImage_widthOri(String image_widthOri) {
        this.image_widthOri = image_widthOri;
    }

    public String getImage_sizeOri() {
        return image_sizeOri;
    }

    public void setImage_sizeOri(String image_sizeOri) {
        this.image_sizeOri = image_sizeOri;
    }
    
    

}