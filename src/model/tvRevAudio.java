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
public class tvRevAudio {

    private String titleRev;
    private String genreRev;
    private String sample_rateRev;
    private String durationRev;
    private String channel_typeRev;

    public tvRevAudio() {
    }

    public tvRevAudio(String titleRev, String genreRev, String sample_rateRev, String durationRev, String channel_typeRev) {
        this.titleRev = titleRev;
        this.genreRev = genreRev;
        this.sample_rateRev = sample_rateRev;
        this.durationRev = durationRev;
        this.channel_typeRev = channel_typeRev;
    }

    public String getTitleRev() {
        return titleRev;
    }

    public void setTitleRev(String titleRev) {
        this.titleRev = titleRev;
    }

    public String getGenreRev() {
        return genreRev;
    }

    public void setGenreRev(String genreRev) {
        this.genreRev = genreRev;
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

    public String getChannel_typeRev() {
        return channel_typeRev;
    }

    public void setChannel_typeRev(String channel_typeRev) {
        this.channel_typeRev = channel_typeRev;
    }
    
    
}
