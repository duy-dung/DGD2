package com.example.bum.dgdv2.base;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.view.Window;

/**
 * Created by Bum on 22-Jul-17.
 */

public abstract class BaseDialog extends Dialog {
    protected Activity mActivity;

    public BaseDialog(@NonNull Activity activity) {
        super(activity);
        this.mActivity = activity;
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        initDialog();
    }

    protected abstract void initDialog();
}