package com.monzag;

import javax.xml.crypto.Data;

public class Reservation {

    private String movie;
    private Double price;
    private Integer place;
    private String  data;
    private String hour;
    private String holder;

    public Reservation() {

    }

    public Reservation(String movie, Double price, Integer place, String data, String hour, String holder) {
        this.movie = movie;
        this.price = price;
        this.place = place;
        this.data = data;
        this.hour = hour;
        this.holder = holder;
    }


    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getPlace() {
        return place;
    }

    public void setPlace(Integer place) {
        this.place = place;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public String toString() {
        return "Reservation: " +
                "movie='" + movie + '\'' +
                ", price=" + price +
                ", place=" + place +
                ", data=" + data +
                ", holder='" + holder + '\'';
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }


}
