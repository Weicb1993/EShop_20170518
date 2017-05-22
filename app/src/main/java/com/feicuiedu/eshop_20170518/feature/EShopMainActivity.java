package com.feicuiedu.eshop_20170518.feature;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.feicuiedu.eshop_20170518.R;
import com.feicuiedu.eshop_20170518.base.utils.TestFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import butterknife.BindView;
import butterknife.ButterKnife;


public class EShopMainActivity extends AppCompatActivity implements OnTabSelectListener {

    @BindView(R.id.bottom_bar)
    BottomBar mBottomBar;

    private TestFragment mHomeFragment;
    private TestFragment mCategoryFragment;
    private TestFragment mCartFragment;
    private TestFragment mMineFragment;

    private Fragment mCurrentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eshop_main);
        ButterKnife.bind(this);

        //初始化视图
        initView();
    }

    //视图处理
    private void initView() {
        retrieveFragment();

        //底部导航监听
        mBottomBar.setOnTabSelectListener(this);
    }

    private void retrieveFragment() {
        FragmentManager manager= getSupportFragmentManager();
        mHomeFragment = (TestFragment) manager.findFragmentByTag("HomeFragment");
        mCategoryFragment = (TestFragment) manager.findFragmentByTag("CategoryFragment");
        mCartFragment = (TestFragment) manager.findFragmentByTag("CartFragment");
        mMineFragment = (TestFragment) manager.findFragmentByTag("MineFragment");

    }

    @Override
    public void onTabSelected(@IdRes int tabId) {
        switch (tabId){
            case R.id.tab_home:
                if (mHomeFragment==null){
                    mHomeFragment=TestFragment.newInstance("HomeFragment");
                }
                switchFragment(mHomeFragment);
                break;
            case R.id.tab_category:
                if (mCartFragment==null){
                    mCategoryFragment=TestFragment.newInstance("CategoryFragment");
                }
                switchFragment(mCategoryFragment);
                break;
            case R.id.tab_cart:
               if (mCartFragment==null){
                   mCartFragment=TestFragment.newInstance("CartFragment");
               }
               switchFragment(mCartFragment);
                break;
            case R.id.tab_mine:
                if (mMineFragment==null){
                    mMineFragment=TestFragment.newInstance("MineFragment");
                }
                switchFragment(mMineFragment);
                break;
            default:
                throw new UnsupportedOperationException("unSupport");
        }
    }

    private void switchFragment(Fragment fragment) {
        if (mCurrentFragment== fragment) return;
        FragmentTransaction transaction =
                getSupportFragmentManager().beginTransaction();
        if (mCurrentFragment!=null){
            transaction.hide(mCurrentFragment);
        }
        if (fragment.isAdded()){
            transaction.show(fragment);
        }else {
            String tag = ((TestFragment)fragment).getArgumentTest();
            transaction.add(R.id.layout_container,fragment,tag);
        }
        transaction.commit();
        mCurrentFragment=fragment;
    }
    @Override
    public void onBackPressed() {
        if (mCurrentFragment!=mHomeFragment){
            mBottomBar.selectTabWithId(R.id.tab_home);
            return;
        }
        moveTaskToBack(true);
    }
}
