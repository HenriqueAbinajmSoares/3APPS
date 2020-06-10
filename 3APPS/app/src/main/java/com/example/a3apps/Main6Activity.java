package com.example.a3apps;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Main6Activity extends AppCompatActivity {
private Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK && requestCode == 1) {
            Uri imgSelecionar = data.getData();
            ImageView imgvVer = (ImageView) findViewById(R.id.imgvVer);
            imgvVer.setImageURI(imgSelecionar);
        }
        else {
            showMessage("Imagem não foi carregada!!");
        }
    }

    private void showMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }

    private void btnAbrirOnClick (View view){
        Intent intentGALERIA = new Intent (Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intentGALERIA,1 );
    }
}
