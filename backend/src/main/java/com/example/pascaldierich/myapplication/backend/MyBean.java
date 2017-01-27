package com.example.pascaldierich.myapplication.backend;

/**
 * The object model for the data we are sending through endpoints
 */
public class MyBean {

    private String myData;

    public String getData() {
        return myData;
    }

    /**
     * Unnecessary because of Java Library 'jokeslib'
     */
    public void setData(String data) {
        myData = data;
    }
}