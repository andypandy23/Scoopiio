package com.scoop.scoopiio;

/**
 * Created by Andreas on 11.09.2015.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper { //This Class is to work directly with the database
//**Variables **//
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "products.db"; // A db extension tells Android that is at database file stored in here.
    public static final String TABLE_PRODUCTS = "products"; // This is the name of my table
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_PRODUCTNAME = "productname";

    //Constructor, wich inialise the objects
    public Database(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION); //Android need to know which database verion I'm working with
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE" + TABLE_PRODUCTS + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT  " +
                COLUMN_PRODUCTNAME + " TEXT " + //This will be storing all the products the user types in
                ")";
        db.execSQL(query); //The exec gonna execute the query in the parameter
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP_TABLE IF EXIST" + TABLE_PRODUCTS); //This one gonna delete the table
        onCreate(db);
    }

    //Adding a new row to the database
    public void addProduct(Products product) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_PRODUCTNAME, product.get_productname());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_PRODUCTS, null, values); //This line is gonna answer a new product or a new row into the table
        db.close(); //Close the databse
    }

    //This will delete products from the database
    public void deleteProduct(String productName) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM" + TABLE_PRODUCTS + "WHERE" + COLUMN_PRODUCTNAME + "=\"" + productName + "\";");
    }

    //Printing results

    public String databaseToString() {
        String dbString = ""; //need a variable to save in
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM" + TABLE_PRODUCTS + "WHERE 1"; // select every column and select every row

        //Point a location to my results
        Cursor c = db.rawQuery(query, null);
        c.moveToFirst(); //Move to first row in the results
//Loop trough each row in the database
        while (!c.isAfterLast()) { //The C wich is my cursor is after last  I wanne sure that it's not position after the last row
            if (c.getString(c.getColumnIndex("productname")) != null) {
                dbString += c.getString(c.getColumnIndex("productname"));
                dbString += "\n";
            }
        }

        db.close();
        return dbString; // the needs to return a string
    }
}