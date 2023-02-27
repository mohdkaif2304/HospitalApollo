package com.example.hospitalapollo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {

    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query1 = "create table users (username text , email text , password text )";
        sqLiteDatabase.execSQL(query1);

        String query2 = "create table cart(username text , product text , price float , otype text)";
        sqLiteDatabase.execSQL(query2);

        String query3 = "create table orderplace (username text , fullname text , address text , contact_no text ,pincode int , date text , time text ,amount float , otype text)";
        sqLiteDatabase.execSQL(query3);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
    public void register (String username , String email , String password ){
        ContentValues contentValues = new ContentValues();
        contentValues.put("username" , username);
        contentValues.put("email" , email);
        contentValues.put("password" , password);
        SQLiteDatabase db = getWritableDatabase();
        db.insert("users" ,null,contentValues);
        db.close();
    }

    public int login (String username , String password){
       int result = 0 ;
       String [] str = new String[2];
       str[0] = username ;
       str[1] = password ;

       SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from users where username = ? and password = ?" , str);
        if(cursor.moveToFirst()){
            result = 1 ;
        }
        return result;
    }
    public void addToCart (String username , String product , float price , String otype){
        ContentValues contentValues = new ContentValues();
        contentValues.put("username" , username);
        contentValues.put("product" , product);
        contentValues.put("price" , price);
        contentValues.put("otype" , otype);
        SQLiteDatabase db = getWritableDatabase();
        db.insert("cart" ,null,contentValues);
        db.close();
    }
    public int checkCart (String username , String product){
        int result = 0 ;
        String [] str = new String[2];
        str[0] = username ;
        str[1] = product ;

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from cart where username = ? and product = ?" , str);
        if(cursor.moveToFirst()){
            result = 1 ;
        }
        db.close();
        return result;
    }
    public void removeCart (String username , String otype){
        int result = 0 ;
        String [] str = new String[2];
        str[0] = username ;
        str[1] = otype ;

        SQLiteDatabase db = getWritableDatabase();
         db.delete("cart" , " username = ? and otype = ?" , str);
         db.close();
    }
    public ArrayList getCartData (String username , String otype){
        ArrayList<String> arr = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String [] str = new String[2];
        str[0] = username ;
        str[1] = otype ;
        Cursor cursor = db.rawQuery("select * from cart where username = ? and otype = ?" , str);
        if(cursor.moveToFirst()){
            do {
                String product = cursor.getString(1);
                String price = cursor.getString(2);
                arr.add(product + "$" + price);
            }
            while(cursor.moveToNext());
        }
        db.close();
        return arr;
    }
    public void addOrder(String username , String fullname , String address , String contact ,int pincode , String date , String time , float price , String otype ){
        ContentValues contentValues = new ContentValues();
        contentValues.put("username" , username);
        contentValues.put("fullname" , fullname);
        contentValues.put("address" , address);
        contentValues.put("contact" , contact);
        contentValues.put("pincode" , pincode);
        contentValues.put("date" , date);
        contentValues.put("time" , time);
        contentValues.put("price" , price);
        contentValues.put("otype" , otype);
        SQLiteDatabase db = getWritableDatabase();
        db.insert("orderplace" ,null,contentValues);
        db.close();
    }
}
