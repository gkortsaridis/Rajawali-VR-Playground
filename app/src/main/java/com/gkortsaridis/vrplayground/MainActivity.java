package com.gkortsaridis.vrplayground;

import android.os.Bundle;
import android.view.View;

import com.google.vrtoolkit.cardboard.CardboardActivity;

import org.rajawali3d.cardboard.RajawaliCardboardRenderer;
import org.rajawali3d.cardboard.RajawaliCardboardView;

public class MainActivity extends CardboardActivity {

    RajawaliCardboardRenderer renderer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RajawaliCardboardView view = new RajawaliCardboardView(this);
        setContentView(view);
        setCardboardView(view);

        renderer = new MyRenderer(this);     // your renderer
        view.setRenderer(renderer);          // required for CardboardView
        view.setSurfaceRenderer(renderer);   // required for RajawaliSurfaceView

        view.setVRModeEnabled(true);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Do your trigger stuff
                renderer.changePano(R.drawable.pano2);
            }
        });
    }

    @Override
    public void onCardboardTrigger() {
        super.onCardboardTrigger();
        //Do your trigger stuff
        renderer.changePano(R.drawable.pano2);
    }
}
