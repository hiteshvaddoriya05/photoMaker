package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.myapplication.Recyclerview.EffectRecycler;
import com.theartofdev.edmodo.cropper.CropImage;

public class SetImage extends AppCompatActivity implements View.OnClickListener {
    int array3d[] = {R.drawable.effect_1, R.drawable.effect_2, R.drawable.effect_3, R.drawable.effect_4, R.drawable.effect_5};
    int effect_Array[] = {R.drawable.pixel_1, R.drawable.pixel_2, R.drawable.pixel_3, R.drawable.pixel_4, R.drawable.pixel_5,
            R.drawable.pixel_6, R.drawable.pixel_7, R.drawable.pixel_8, R.drawable.pixel_9, R.drawable.pixel_10};
    int test[];
    private ImageView id_imageset;
    private LinearLayout id_Effect, id_3d;
    private RecyclerView id_RecToolView;
    public static ImageView id_imageEffect;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_image);

        id_imageset = findViewById(R.id.id_imageset);
        id_imageset.setImageBitmap(ImageEdit.cropped);// set image of imageEdit page

        id_RecToolView = findViewById(R.id.id_RecToolView);
        id_imageEffect = findViewById(R.id.id_imageEffect);



       //effect button click list
        id_3d = findViewById(R.id.id_3d);
        id_Effect = findViewById(R.id.id_Effect);





        id_3d.setOnClickListener(this);
        id_Effect.setOnClickListener(this);






    }//---------end oncreate---------

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.id_3d:
                test=array3d;
                callRecycler(test);
                break;
            case R.id.id_Effect:
                test=effect_Array;
                callRecycler(test);
        }

    }//------end onclick swithcase---------------------------------

    private void callRecycler(int[] test) {
        EffectRecycler effectAdaptor = new EffectRecycler(SetImage.this, test);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(SetImage.this, RecyclerView.HORIZONTAL, false);
        id_RecToolView.setLayoutManager(manager);
        id_RecToolView.setAdapter(effectAdaptor);


    }
}//-----end class-----------------------