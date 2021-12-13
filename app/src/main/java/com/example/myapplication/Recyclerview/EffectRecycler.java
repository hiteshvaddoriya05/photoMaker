package com.example.myapplication.Recyclerview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.SetImage;

public class EffectRecycler extends RecyclerView.Adapter<EffectRecycler.Dataholder> {
    Activity activity;
    int[] array3d;


    public EffectRecycler(SetImage setImage, int[] array3d) {
        activity = setImage;
        this.array3d = array3d;
    }

    @NonNull
    @Override
    public Dataholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.item_effectview, parent, false);
        return new Dataholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Dataholder holder, @SuppressLint("RecyclerView") int position) {
        holder.viewId_effect.setImageResource(array3d[position]);
        holder.viewId_effect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("TAG", "onClick-------: "+ array3d[position] );
                SetImage.id_imageEffect.setImageResource(array3d[position]);
            }


        });
    }//--------end onBindview Holder---------------




    @Override
    public int getItemCount() {
        return array3d.length;
    }

    class Dataholder extends RecyclerView.ViewHolder {


        private final ImageView viewId_effect;

        public Dataholder(@NonNull View itemView) {
            super(itemView);
            viewId_effect = itemView.findViewById(R.id.viewId_effect);
        }
    }
}
