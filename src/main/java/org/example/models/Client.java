package org.example.models;

import lombok.Getter;

public class Client {
    @Getter
    private static String name;
    private static String country;
    private static String city;
    private static String card;
    private static String month;
    private static String year;

    public String getName(){return name;}
    public  String getCountry() {
        return country;
    }
    public  String getCity() {
        return city;
    }
    public  String getCard() {
        return card;
    }
    public  String getMonth() {
        return month;
    }
    public  String getYear() {
        return year;
    }


}
