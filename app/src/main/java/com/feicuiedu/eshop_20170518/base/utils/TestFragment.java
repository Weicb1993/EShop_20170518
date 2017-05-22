package com.feicuiedu.eshop_20170518.base.utils;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.feicuiedu.eshop_20170518.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 魏 on 2017/5/19.
 */

public class TestFragment extends Fragment {
    private static final String ARGUMENTS_TEXT ="arguments_text" ;
    @BindView(R.id.text)
    TextView mText;

    public static TestFragment newInstance(String test){
        TestFragment testFragment=new TestFragment();
        Bundle bundle=new Bundle();
        bundle.putString(ARGUMENTS_TEXT,test);
        testFragment.setArguments(bundle);//传递
        return testFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test, container, false);
        ButterKnife.bind(this,view);

        mText.setText(getArgumentTest());

        return view;
}
    //拿到传递
    public String getArgumentTest(){
        return getArguments().getString(ARGUMENTS_TEXT);
    }

}
