package com.example.bum.dgdv2.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Bum on 08-Aug-17.
 */

public abstract class BaseFragment extends Fragment {
    protected abstract int getLayoutId();
    protected abstract void initView();
    protected void onScreenLoadData() {
    }
    protected abstract void  initViewMain();
    private View mView;
    private Unbinder mUnbinder;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mView == null) {
            mView = inflater.inflate(getLayoutId(), container, false);
        }
        mUnbinder = ButterKnife.bind(this, mView);
        initView();
        return mView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViewMain();
    }

    @Override
    public Animation onCreateAnimation(int transit, final boolean enter, int nextAnim) {
        Animation animation = super.onCreateAnimation(transit, enter, nextAnim);
        if (animation == null && nextAnim != 0) {
            animation = AnimationUtils.loadAnimation(getActivity(), nextAnim);
        }
        if (animation != null) {
            animation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    BaseFragment.this.onAnimationEnd(enter);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                }
            });
        } else {
            if (enter) {
                // when the fragment is added/attached/shown
                onScreenLoadData();
            } else {
                // Do nothings
                // when the fragment is removed/detached/hidden.
            }
        }
        return animation;
    }
    public void onAnimationEnd(boolean enter) {
        if (enter) {
            // when the fragment is added/attached/shown
            onScreenLoadData();
        } else {
            // Do nothings
            // when the fragment is removed/detached/hidden.
        }
    }

    @Override
    public void onDestroyView() {
        mUnbinder.unbind();
        super.onDestroyView();
    }
}
