package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

public class ImageEdit extends AppCompatActivity {

    private Uri imageUri;
    private CropImageView cropImageView;
    private Uri uri;
    private Bitmap bitmap;
    private ImageView idBtn_crocpOk;
    public static Bitmap cropped;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_edit);

        cropImageView=findViewById(R.id.cropImageView);
        idBtn_crocpOk=findViewById(R.id.idBtn_crocpOk);


        byte[] byteArray = getIntent().getByteArrayExtra("picture");
        Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);

        cropImageView.setImageBitmap(bmp);

        idBtn_crocpOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                cropImageView.getCroppedImageAsync();
                 cropped = cropImageView.getCroppedImage();

                 Intent gosetimage=new Intent(ImageEdit.this,SetImage.class);
                 startActivity(gosetimage);
            }
        });

//

    }//----end oncreate--------

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                Uri resultUri = result.getUri();
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
            }
        }
    }


}