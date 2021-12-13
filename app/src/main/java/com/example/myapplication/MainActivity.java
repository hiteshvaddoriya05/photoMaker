package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {

    private ImageView id_imagetake,id_imageResult;
    private int imagecode=200;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id_imagetake=findViewById(R.id.id_imagetake);
        id_imageResult=findViewById(R.id.id_imageResult);



        id_imagetake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takeimage=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(takeimage,imagecode);
            }
        });




    }//------end oncreate------------------

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==imagecode) {
            Uri imageUri = data.getData();
            id_imageResult.setImageURI(imageUri);

            // send image to next page-----------------

            //get image from imageview and convet to bitmap
            Bitmap imageBitmap=((BitmapDrawable)id_imageResult.getDrawable()).getBitmap();
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            imageBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            byte[] byteArray = stream.toByteArray();

            Intent intent = new Intent(this, ImageEdit.class);
            intent.putExtra("picture", byteArray);
            startActivity(intent);


        }
    }
}//---end Class-----------------------