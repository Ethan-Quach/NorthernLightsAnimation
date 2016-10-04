package com.example.equach3.northernlightsanimation;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class AnimationActivity extends AppCompatActivity {

    private ImageView lightsImageView;

    // Frame animations are different from tween animations in code.
    // They're distinguished as AnimationDrawables, rather than Animations.
    private AnimationDrawable frameAnim;

    // Regular tween animations are just referred to as Animations.
    private Animation rotateAnim;
    private Animation shakeAnim;
    private Animation customAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        lightsImageView = (ImageView) findViewById(R.id.lightsImageView);
    }

    public void toggleFrameAnim(View view) {
        // 1) Set the background of the imageView to @drawable/light1 in code
        lightsImageView.setBackgroundResource(R.drawable.frame_anim);

        // 2) Associate the frameAnim in the controller to the XML file
        frameAnim = (AnimationDrawable) lightsImageView.getBackground();

        if (frameAnim.isRunning())
            frameAnim.stop();
        else
            frameAnim.start();
    }

    public void toggleRotateAnim(View view) {
        rotateAnim = AnimationUtils.loadAnimation(this, R.anim.rotate_anim);
        if (rotateAnim != null && rotateAnim.hasStarted()){
            lightsImageView.clearAnimation();
            rotateAnim = null;
        }
        else
            lightsImageView.startAnimation(rotateAnim);
    }

    public void toggleShakeAnim(View view) {
        shakeAnim = AnimationUtils.loadAnimation(this, R.anim.shake_anim);
        if (shakeAnim != null && shakeAnim.hasStarted()){
            lightsImageView.clearAnimation();
            shakeAnim = null;
        }
        else
            lightsImageView.startAnimation(shakeAnim);
    }
}
