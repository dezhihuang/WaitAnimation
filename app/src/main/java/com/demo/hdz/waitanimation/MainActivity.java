package com.demo.hdz.waitanimation;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {

    private ImageView m_imgInsideCircle;  //内圆
    private ImageView m_imgOuterCircle;   //外圆

    private Animation m_animInsideCircle; //内圆动画
    private Animation m_animOuterCircle;  //外圆动画

    private AnimationDrawable m_frameAnim;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化旋转动画
        rotateAnimInit();

        Button btnStart = (Button) findViewById(R.id.btnStart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAnimation();
            }
        });

        Button btnStop = (Button) findViewById(R.id.btnStop);
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopAnimation();
            }
        });
    }

    private void rotateAnimInit() {
        m_imgInsideCircle = (ImageView) findViewById(R.id.imgInsideCircle);
        m_imgOuterCircle = (ImageView) findViewById(R.id.imgOuterCircle);

        m_animInsideCircle = AnimationUtils.loadAnimation(this, R.anim.inside_rotate_anim);
        m_animInsideCircle.setInterpolator(new LinearInterpolator()); //匀速动画

        m_animOuterCircle = AnimationUtils.loadAnimation(this, R.anim.outer_rotate_anim);
        m_animOuterCircle.setInterpolator(new LinearInterpolator()); //匀速动画


        ImageView imgView = (ImageView) findViewById(R.id.frameAnim);
        m_frameAnim = (AnimationDrawable) imgView.getBackground();

        //开始动画
        startAnimation();
    }

    //开始动画
    private void startAnimation() {
        m_imgInsideCircle.startAnimation(m_animInsideCircle);
        m_imgOuterCircle.startAnimation(m_animOuterCircle);

        m_frameAnim.start();
    }

    //停止动画
    private void stopAnimation() {
        m_imgInsideCircle.clearAnimation();
        m_imgOuterCircle.clearAnimation();

        m_frameAnim.stop();
    }
}
