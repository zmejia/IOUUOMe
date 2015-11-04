package com.example.zaidamejia.iouuome;

/**
 * Created by zaidamejia on 10/24/15.
 */
public class EntryData {


    private int id;
    private String description;
    private String date;
    private String total;

    public EntryData(){

    }

    public EntryData(int id, String description, String date, String total){
       this.id = id;
        this.description = description;
        this.date = date;
        this.total = total;
    }


    public void setID(int id){
        this.id = id;
    }

    public int getID(){
        return id;
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
