package com.example.zaidamejia.iouuome;

/**
 * Created by zaidamejia on 10/24/15.
 */
public class EntryData {


    private String description;
    private String date;
    private String total;

    public EntryData(){

    }

    public EntryData(String description, String date, String total){
        this.description = description;
        this.date = date;
        this.total = total;
    }


    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    public void setDate(String date){
        this.date = date;
    }

    public String getDate(){
        return date;
    }

    public void setTotal(String total){
        this.total = total;
    }

    public String getTotal(){
        return total;
    }





}
