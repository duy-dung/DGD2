package com.example.bum.dgdv2.fragment.notification;


import com.example.bum.dgdv2.R;
import com.example.bum.dgdv2.base.BaseFragment;

/**
 * Created by Bum on 07-Aug-17.
 */

public class FragmentNotification extends BaseFragment {
    public static FragmentNotification newInstance(){
        FragmentNotification fragmentMyList=new FragmentNotification();
        return fragmentMyList;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.frm_notification;
    }

    @Override
    protected void initView() {

    }
}
