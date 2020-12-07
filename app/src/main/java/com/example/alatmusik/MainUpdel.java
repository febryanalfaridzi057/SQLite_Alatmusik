package com.example.alatmusik;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainUpdel extends AppCompatActivity {
    private MyDatabase db;
    private String Sid, Snama, Skondisi, Sharga;
    private EditText Enama, Ekondisi, Eharga;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_updel);
        db = new MyDatabase(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Snama = i.getStringExtra("Inama");
        Skondisi = i.getStringExtra("Ikondisi");
        Sharga = i.getStringExtra("Iharga");
        Enama = (EditText) findViewById(R.id.updel_nama);
        Ekondisi = (EditText) findViewById(R.id.updel_kondisi);
        Eharga = (EditText) findViewById(R.id.updel_harga);
        Enama.setText(Snama);
        Ekondisi.setText(Skondisi);
        Eharga.setText(Sharga);
        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Skondisi = String.valueOf(Ekondisi.getText());
                Sharga = String.valueOf(Eharga.getText());
                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi nama AlatMusik",
                            Toast.LENGTH_SHORT).show();
                } else if (Skondisi.equals("")){
                    Ekondisi.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi Kondisi",
                            Toast.LENGTH_SHORT).show();
                } else if (Sharga.equals("")){
                    Eharga.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi Harga",
                            Toast.LENGTH_SHORT).show();
                } else {
                    db.UpdateToko(new AlatMusik(Sid, Snama, Skondisi, Sharga));
                    Toast.makeText(MainUpdel.this, "Data telah diupdate",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeleteToko(new AlatMusik(Sid, Snama, Skondisi, Sharga));
                Toast.makeText(MainUpdel.this, "Data telah dihapus",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}