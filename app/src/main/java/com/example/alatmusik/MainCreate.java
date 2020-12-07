package com.example.alatmusik;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainCreate extends AppCompatActivity {
    private MyDatabase db;
    private EditText Enama, Ekondisi, Eharga;
    private String Snama, Skondisi, Sharga;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);

        db = new MyDatabase(this);
        Enama = (EditText) findViewById(R.id.create_nama);
        Ekondisi = (EditText) findViewById(R.id.create_kondisi);
        Eharga = (EditText) findViewById(R.id.create_harga);
        Button btnCreate = (Button) findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Skondisi = String.valueOf(Ekondisi.getText());
                Sharga = String.valueOf(Eharga.getText());

                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi nama AlatMusik",
                            Toast.LENGTH_SHORT).show();
                } else if (Skondisi.equals("")){
                    Ekondisi.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi Kondisi AlatMusik",
                            Toast.LENGTH_SHORT).show();
                } else if (Sharga.equals("")){
                    Eharga.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi Harga AlatMusik",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Enama.setText("");
                    Ekondisi.setText("");
                    Eharga.setText("");
                    Toast.makeText(MainCreate.this, "Data telah  ditambah",
                            Toast.LENGTH_SHORT).show();
                    db.CreateToko(new AlatMusik(null, Snama, Skondisi, Sharga));
                    Intent a = new Intent(MainCreate.this,
                            MainActivity.class);
                    startActivity(a);
                }
            }
        });
    }
}
