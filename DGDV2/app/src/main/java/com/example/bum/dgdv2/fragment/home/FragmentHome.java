package com.example.bum.dgdv2.fragment.home;



import com.example.bum.dgdv2.R;
import com.example.bum.dgdv2.base.BaseFragment;

/**
 * Created by Bum on 08-Aug-17.
 */

public class FragmentHome extends BaseFragment {
    public static FragmentHome newInstance(){
        FragmentHome fragmentHome=new FragmentHome();
        return fragmentHome;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.frm_home;
    }

    @Override
    protected void initView() {

    }
}
