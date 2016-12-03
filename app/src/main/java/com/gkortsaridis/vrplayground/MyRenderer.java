package com.gkortsaridis.vrplayground;

import android.content.Context;
import android.os.Vibrator;
import android.util.Log;

import org.rajawali3d.cardboard.RajawaliCardboardRenderer;
import org.rajawali3d.materials.Material;
import org.rajawali3d.materials.textures.ATexture;
import org.rajawali3d.materials.textures.Texture;
import org.rajawali3d.math.vector.Vector3;
import org.rajawali3d.primitives.Sphere;

public class MyRenderer extends RajawaliCardboardRenderer {

    public MyRenderer(Context context) {
        super(context);
    }

    Sphere sphere;

    @Override
    protected void initScene() {

        /***SETTING UP THE DEFAULT CAMERA***/
        getCurrentCamera().setPosition(Vector3.ZERO);
        getCurrentCamera().setRotation(0, 0, 90);
        getCurrentCamera().setFieldOfView(75);

        /***SETTING UP THE PANORAMA SPHERE***/
        try {
            Material material = new Material();
            material.setColor(0);
            material.addTexture(new Texture("panorama", R.drawable.pano1));
            sphere = new Sphere(50, 64, 32); //radius , SegmentsW , segmentsH
            sphere.setScaleX(-1);
            sphere.setMaterial(material);
            getCurrentScene().addChild(sphere);
        } catch (ATexture.TextureException e) {
            throw new RuntimeException(e);
        }

    }

    /***CUSTOM METHOD FOR TRIGGER ACTION***/
    public void changePano(int panoToChange){

        Vibrator v = (Vibrator) this.getContext().getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(200);

        try {
            Material material = new Material();
            material.setColor(0);
            material.addTexture(new Texture("photo", panoToChange));
            sphere.setMaterial(material);
        } catch (ATexture.TextureException e) {
            throw new RuntimeException(e);
        }

    }

}
