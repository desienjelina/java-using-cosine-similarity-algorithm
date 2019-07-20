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
public class tvOriAudio {
    private String titleOri;
    private String genreOri;
    private String sample_rateOri;
    private String durationOri;
    private String channel_typeOri;

    public tvOriAudio() {
    }

    public tvOriAudio(String titleOri, String genreOri, String sample_rateOri, String durationOri, String channel_typeOri) {
        this.titleOri = titleOri;
        this.genreOri = genreOri;
        this.sample_rateOri = sample_rateOri;
        this.durationOri = durationOri;
        this.channel_typeOri = channel_typeOri;
    }

    public String getTitleOri() {
        return titleOri;
    }

    public void setTitleOri(String titleOri) {
        this.titleOri = titleOri;
    }

    public String getGenreOri() {
        return genreOri;
    }

    public void setGenreOri(String genreOri) {
        this.genreOri = genreOri;
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

    public String getChannel_typeOri() {
        return channel_typeOri;
    }

    public void setChannel_typeOri(String channel_typeOri) {
        this.channel_typeOri = channel_typeOri;
    }

    
}
