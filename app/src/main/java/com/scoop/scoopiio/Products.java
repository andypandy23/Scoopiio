package com.scoop.scoopiio;

/**
 * Created by Andreas on 11.09.2015.
 */

public class Products { //This class contains all products
    private int _id; // Using datatype integer for the id.
    private String _productname; // Text has to be a String datatype

    public Products(){

    }

    public Products(String productname) {
        this._productname = productname; //Using String for the product name
    }

    public void set_id(int _id) {
        this._id = _id;
    } // Using datatype integer for ID

    public void set_productname(String _productname) {
        this._productname = _productname;
    }

    public int get_id() {
        return _id;
    }

    public String get_productname() {
        return _productname;
    }
}
