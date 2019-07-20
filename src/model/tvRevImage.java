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
public class tvRevImage {
 private String created_dateRev;
    private String image_heightRev;
    private String image_widthRev;
    private String image_sizeRev;

    public tvRevImage() {
    }

    public tvRevImage(String created_dateRev, String image_heightRev, String image_widthRev, String image_sizeRev) {
        this.created_dateRev = created_dateRev;
        this.image_heightRev = image_heightRev;
        this.image_widthRev = image_widthRev;
        this.image_sizeRev = image_sizeRev;
    }

    public String getCreated_dateRev() {
        return created_dateRev;
    }

    public void setCreated_dateRev(String created_dateRev) {
        this.created_dateRev = created_dateRev;
    }

    public String getImage_heightRev() {
        return image_heightRev;
    }

    public void setImage_heightRev(String image_heightRev) {
        this.image_heightRev = image_heightRev;
    }

    public String getImage_widthRev() {
        return image_widthRev;
    }

    public void setImage_widthRev(String image_widthRev) {
        this.image_widthRev = image_widthRev;
    }

    public String getImage_sizeRev() {
        return image_sizeRev;
    }

    public void setImage_sizeRev(String image_sizeRev) {
        this.image_sizeRev = image_sizeRev;
    }
    
    
    

}