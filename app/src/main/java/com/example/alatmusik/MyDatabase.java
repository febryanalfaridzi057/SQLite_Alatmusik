package com.example.alatmusik;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db_usaha";
    private static final String tb_alatmusik = "tb_alatmusik";
    private static final String tb_tk_id = "id";
    private static final String tb_tk_nama = "nama";
    private static final String tb_tk_kondisi = "kondisi";
    private static final String tb_tk_harga = "harga";
    private static final String CREATE_TABLE_HP = "CREATE TABLE " +
            tb_alatmusik + "("
            + tb_tk_id + " INTEGER PRIMARY KEY ,"
            + tb_tk_nama + " TEXT,"
            + tb_tk_kondisi + " TEXT,"
            + tb_tk_harga + " TEXT " + ")";

    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_HP);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int
            newVersion) {
    }
    public void CreateToko (AlatMusik mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_tk_id, mdNotif.get_id());
        values.put(tb_tk_nama, mdNotif.get_nama());
        values.put(tb_tk_kondisi, mdNotif.get_kondisi());
        values.put(tb_tk_harga, mdNotif.get_harga());
        db.insert(tb_alatmusik, null, values);
        db.close();
    }
    public List<AlatMusik> ReadToko() {
        List<AlatMusik> judulModelList = new ArrayList<AlatMusik>();
        String selectQuery = "SELECT * FROM " + tb_alatmusik;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                AlatMusik mdKontak = new AlatMusik();
                mdKontak.set_id(cursor.getString(0));
                mdKontak.set_nama(cursor.getString(1));
                mdKontak.set_kondisi(cursor.getString(2));
                mdKontak.set_harga(cursor.getString(3));
                judulModelList.add(mdKontak);
            } while (cursor.moveToNext());
        }
        db.close();
        return judulModelList;
    }
    public int UpdateToko (AlatMusik mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_tk_nama, mdNotif.get_nama());
        values.put(tb_tk_kondisi, mdNotif.get_kondisi());
        values.put(tb_tk_harga, mdNotif.get_harga());
        return db.update(tb_alatmusik, values, tb_tk_id + " = ?",
                new String[] { String.valueOf(mdNotif.get_id())});
    }
    public void DeleteToko (AlatMusik mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_alatmusik, tb_tk_id+ " = ?",
                new String[]{String.valueOf(mdNotif.get_id())});
        db.close();
    }
}