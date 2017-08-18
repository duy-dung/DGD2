package com.example.bum.dgdv2.dialog;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.example.bum.dgdv2.R;
import com.example.bum.dgdv2.base.BaseDialog;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Bum on 17-Aug-17.
 */

public class DialogContribute extends BaseDialog {
    public DialogContribute(@NonNull Activity activity) {
        super(activity);
    }

    @Override
    protected void initDialog() {
        View view = LayoutInflater.from(mActivity).inflate(R.layout.dialog_contribute, null);
        setContentView(view);
        ButterKnife.bind(this, view);
        this.setCanceledOnTouchOutside(false);
        this.setCancelable(false);
    }
    @OnClick(R.id.tv_contribute_ok)
    public void successContribute(){
        Toast.makeText(mActivity, "Update in the ...", Toast.LENGTH_SHORT).show();
        dismiss();
    }
    @OnClick(R.id.tv_contribute_cancel)
    public void cancelContribute(){
        this.dismiss();
    }
}
