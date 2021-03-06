package com.example.zaidamejia.iouuome;

/**
 * Created by zaidamejia on 9/16/15.
 */
public class UserData {

    //private variables
    private int _id;
    private String _name;
    private String _email;
    private String _phone;

    // Empty constructor
    public UserData(){

    }


    // constructor
    public UserData(int id, String name, String email, String phone){
        this._id = id;
        this._name = name;
        this._email = email;
        this._phone = phone;
    }

    // constructor
    public UserData(String name, String email){
        this._name = name;
        this._email = email;
    }


    // getting ID
    public int getID(){
        return this._id;
    }

    // setting id
    public void setID(int id){
        this._id = id;
    }

    // getting name
    public String getName(){
        return this._name;
    }

    // setting name
    public void setName(String name){
        this._name = name;
    }

    // getting phone
    public String getPhone(){
        return this._phone;
    }

    // setting phone
    public void setPhone(String phone){
        this._phone = phone;
    }


    // getting email
    public String getEmail(){
        return this._email;
    }

    // setting email
    public void setEmail(String email){
        this._email = email;
    }


}
