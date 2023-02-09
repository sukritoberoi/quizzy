package com.example.quizzy;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class popup extends AppCompatActivity {

    ImageView done;
    AnimatedVectorDrawableCompat avd;
    AnimatedVectorDrawable avd2;

    @RequiresApi(api= Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);
        done=(ImageView)findViewById(R.id.imageView);
        Drawable drawable = done.getDrawable();
        if(drawable instanceof AnimatedVectorDrawableCompat) {
            avd = (AnimatedVectorDrawableCompat) drawable;
            avd.start();
        }
        else if(drawable instanceof AnimatedVectorDrawable){
            avd2 = (AnimatedVectorDrawable) drawable;
            avd2.start();
        }
    }
}