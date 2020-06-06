package com.example.a3apps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main4Activity extends AppCompatActivity {
    Button btnEMAIL;
    EditText txtEMAIL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        inicializarComponentes();
        eventosButtons();
    }

    private void eventosButtons() {
        btnEMAIL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String destinatario = txtEMAIL.getText().toString().trim();
                Intent mail = new Intent(Intent.ACTION_SEND);
                mail.putExtra(Intent.EXTRA_EMAIL, new String[]{destinatario});
                mail.putExtra(Intent.EXTRA_SUBJECT, "Assunto do EMAIL!!!");
                mail.putExtra(Intent.EXTRA_TEXT, "Corpo do EMAIL!!!");
                mail.setType("message/rfc822");
                startActivity(Intent.createChooser(mail, "Escolha o cliente de EMAIL"));
            }
        });
    }

    private void inicializarComponentes() {
        btnEMAIL = (Button) findViewById(R.id.btnEMAIL);
        txtEMAIL = (EditText) findViewById(R.id.txtEMAIL);
    }
}