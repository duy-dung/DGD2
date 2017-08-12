package com.example.bum.dgdv2.fragment.chat;


import com.example.bum.dgdv2.R;
import com.example.bum.dgdv2.base.BaseFragment;

/**
 * Created by Bum on 08-Aug-17.
 */

public class FragmentChat extends BaseFragment {
    public static FragmentChat newInstance(){
        FragmentChat fragmentChat=new FragmentChat();
        return fragmentChat;
    }
    @Override
    protected int getLayoutId() {
        return R.layout.frm_chat;
    }

    @Override
    protected void initView() {

    }

}
