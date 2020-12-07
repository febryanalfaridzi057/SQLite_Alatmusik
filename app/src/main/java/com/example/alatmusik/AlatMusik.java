package com.example.alatmusik;

public class AlatMusik {
    private String _id, _nama, _kondisi, _harga;
    public AlatMusik(String id, String nama, String kondisi, String harga)
    {
        this._id = id;
        this._nama = nama;
        this._kondisi = kondisi;
        this._harga = harga;
    }

    public AlatMusik() {

    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String get_nama() {
        return _nama;
    }

    public void set_nama(String _nama) {
        this._nama = _nama;
    }

    public String get_kondisi() {
        return _kondisi;
    }

    public void set_kondisi(String _kondisi) {
        this._kondisi = _kondisi;
    }

    public String get_harga() {
        return _harga;
    }

    public void set_harga(String _harga) {
        this._harga = _harga;
    }
}
