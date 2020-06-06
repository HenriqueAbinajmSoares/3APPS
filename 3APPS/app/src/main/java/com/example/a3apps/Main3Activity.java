package com.example.a3apps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main3Activity extends AppCompatActivity {
    Button btnTEL;
    EditText txtTEL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        inicializarComponentes();
        eventosButtons();
    }

    private void eventosButtons() {
        btnTEL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fone = txtTEL.getText().toString().trim();
                try {
                    Intent call = new Intent(Intent.ACTION_DIAL);
                    call.setData(Uri.parse("tel:"+fone));
                    startActivity(call);
                } catch (ActivityNotFoundException e) {

                    Log.e("sample call in android", "Erro na ligação", e);
                }
            }
        });
    }

    private void inicializarComponentes() {
        btnTEL = (Button) findViewById(R.id.btnTEL);
        txtTEL = (EditText) findViewById(R.id.txtTEL);
    }
}
