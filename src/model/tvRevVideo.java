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
public class tvRevVideo {

    private String creation_dateRev;
    private String modified_dateRev;
    private String sample_rateRev;
    private String durationRev;
    private String image_lengthRev;
    private String image_widthRev;

    public tvRevVideo() {
    }

    public tvRevVideo(String creation_dateRev, String modified_dateRev, String sample_rateRev, String durationRev, String image_lengthRev, String image_widthRev) {
        this.creation_dateRev = creation_dateRev;
        this.modified_dateRev = modified_dateRev;
        this.sample_rateRev = sample_rateRev;
        this.durationRev = durationRev;
        this.image_lengthRev = image_lengthRev;
        this.image_widthRev = image_widthRev;
    }

    public String getCreation_dateRev() {
        return creation_dateRev;
    }

    public void setCreation_dateRev(String creation_dateRev) {
        this.creation_dateRev = creation_dateRev;
    }

    public String getModified_dateRev() {
        return modified_dateRev;
    }

    public void setModified_dateRev(String modified_dateRev) {
        this.modified_dateRev = modified_dateRev;
    }

    public String getSample_rateRev() {
        return sample_rateRev;
    }

    public void setSample_rateRev(String sample_rateRev) {
        this.sample_rateRev = sample_rateRev;
    }

    public String getDurationRev() {
        return durationRev;
    }

    public void setDurationRev(String durationRev) {
        this.durationRev = durationRev;
    }

    public String getImage_lengthRev() {
        return image_lengthRev;
    }

    public void setImage_lengthRev(String image_lengthRev) {
        this.image_lengthRev = image_lengthRev;
    }

    public String getImage_widthRev() {
        return image_widthRev;
    }

    public void setImage_widthRev(String image_widthRev) {
        this.image_widthRev = image_widthRev;
    }

}
