package com.example.a3apps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import static android.media.MediaRecorder.VideoSource.CAMERA;

public class Main5Activity extends AppCompatActivity {
private static final int CAMERA = 1;
private Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
    }

    public void btnCAMERAOnClick (View v){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(intent, CAMERA);
            }
    }
        protected void onActivityResult (int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, requestCode, data);
                if (requestCode == CAMERA) {
                    if (resultCode == RESULT_OK) {
                        Bundle extras = data.getExtras();
                        Bitmap imageBitmap = (Bitmap) extras.get("data");
                        ImageView imgvFOTO = (ImageView) findViewById(R.id.imgvFOTO);
                        imgvFOTO.setImageBitmap(imageBitmap);
                        showMessage("Foto tirada!");
                        addGaleria();
                    } else {
                        showMessage("Foto não pode ser tirada!");
                    }
                }
            }

    private void addGaleria() {
        Intent intentADD = new Intent(
                Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        intentADD.setData(uri);
        this.sendBroadcast(intentADD);
    }

    public void btnGALERIAOnClick (View v){
        Intent intentGaleria = new Intent (Intent.ACTION_VIEW);
        intentGaleria.setDataAndType(uri, "image/jpeg");
        startActivity(intentGaleria);
    }

    private void showMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }
}