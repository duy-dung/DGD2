package com.example.bum.dgdv2.fragment.setting;


import com.example.bum.dgdv2.R;
import com.example.bum.dgdv2.base.BaseFragment;

/**
 * Created by Bum on 07-Aug-17.
 */

public class FragmentSetting extends BaseFragment {
    public static FragmentSetting newInstance(){
        FragmentSetting fragmentSetting=new FragmentSetting();
        return fragmentSetting;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.frm_setting;
    }

    @Override
    protected void initView() {

    }


}
