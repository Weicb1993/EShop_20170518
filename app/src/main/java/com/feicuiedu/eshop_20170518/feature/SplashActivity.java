package com.feicuiedu.eshop_20170518.feature;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.feicuiedu.eshop_20170518.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends AppCompatActivity implements Animator.AnimatorListener {

    @BindView(R.id.image_splash)
    ImageView mImageSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        //初始化视图
        initView();
    }
    //初始化
    private void initView() {

        mImageSplash.setAlpha(0.3f);

        mImageSplash.animate()
                .alpha(1.0f)//透明度动画
                .setDuration(2000)//动画时间
                .setListener(this)//动画监听
                .start();//开始

    }
    //动画开始时触发
    @Override
    public void onAnimationStart(Animator animation) {

    }
    //结束时触发
    @Override
    public void onAnimationEnd(Animator animation) {
        //跳转：转场效果（从右进入和退出）
        Intent intent=new Intent(this,EShopMainActivity.class);
        startActivity(intent);
        //转场效果直接放置动画资源文件
        overridePendingTransition(R.anim.push_right_in,R.anim.push_right_out);
        finish();


    }
    //取消时触发
    @Override
    public void onAnimationCancel(Animator animation) {

    }
    //重复播放时触发
    @Override
    public void onAnimationRepeat(Animator animation) {

    }
}
