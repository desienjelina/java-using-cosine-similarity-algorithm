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
public class tvOriVideo {

    private String creation_dateOri;
    private String modified_dateOri;
    private String sample_rateOri;
    private String durationOri;
    private String image_lengthOri;
    private String image_widthOri;

    public tvOriVideo() {
    }

    public tvOriVideo(String creation_dateOri, String modified_dateOri, String sample_rateOri, String durationOri, String image_lengthOri, String image_widthOri) {
        this.creation_dateOri = creation_dateOri;
        this.modified_dateOri = modified_dateOri;
        this.sample_rateOri = sample_rateOri;
        this.durationOri = durationOri;
        this.image_lengthOri = image_lengthOri;
        this.image_widthOri = image_widthOri;
    }

    public String getCreation_dateOri() {
        return creation_dateOri;
    }

    public void setCreation_dateOri(String creation_dateOri) {
        this.creation_dateOri = creation_dateOri;
    }

    public String getModified_dateOri() {
        return modified_dateOri;
    }

    public void setModified_dateOri(String modified_dateOri) {
        this.modified_dateOri = modified_dateOri;
    }

    public String getSample_rateOri() {
        return sample_rateOri;
    }

    public void setSample_rateOri(String sample_rateOri) {
        this.sample_rateOri = sample_rateOri;
    }

    public String getDurationOri() {
        return durationOri;
    }

    public void setDurationOri(String durationOri) {
        this.durationOri = durationOri;
    }

    public String getImage_lengthOri() {
        return image_lengthOri;
    }

    public void setImage_lengthOri(String image_lengthOri) {
        this.image_lengthOri = image_lengthOri;
    }

    public String getImage_widthOri() {
        return image_widthOri;
    }

    public void setImage_widthOri(String image_widthOri) {
        this.image_widthOri = image_widthOri;
    }

}
