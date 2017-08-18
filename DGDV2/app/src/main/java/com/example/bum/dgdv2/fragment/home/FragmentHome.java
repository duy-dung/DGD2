package com.example.bum.dgdv2.fragment.home;




import android.content.Context;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.example.bum.dgdv2.R;
import com.example.bum.dgdv2.Untils;
import com.example.bum.dgdv2.base.BaseFragment;
import com.example.bum.dgdv2.dialog.DialogContribute;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLEncoder;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Bum on 08-Aug-17.
 */

public class FragmentHome extends BaseFragment {
    int AUTH_DISABLED = 15 * 1000;
    String str1 = null;
    @BindView(R.id.edt_search)
    EditText edtSearch;
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
        edtSearch.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId==EditorInfo.IME_ACTION_SEARCH) {
                    translateOnline(v.getText().toString());
                    hideSoftKeyboard();
                    return true;
                }
                return false;
            }
        });
    }

    private void translateOnline(String mInput) {
        DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient();
        HttpParams localHttpParams = localDefaultHttpClient.getParams();
        localHttpParams.setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, Integer.valueOf(AUTH_DISABLED));
        localHttpParams.setParameter(CoreConnectionPNames.SO_TIMEOUT, Integer.valueOf(AUTH_DISABLED));
        localHttpParams.setParameter(CoreProtocolPNames.HTTP_CONTENT_CHARSET, HTTP.UTF_8);
        HttpProtocolParams.setUserAgent(localHttpParams, "AndroidTranslate/2.5.3 2.5.3 (gzip)");
        try {
            str1 = new BufferedReader(new InputStreamReader(localDefaultHttpClient.execute(new HttpPost("https://translate.google.com/translate_a/t?client=at&sc=1&v=2.0&sl="
                    + "en" + "&tl=" + "vi" + "&ie=UTF-8&oe=UTF-8&text="
                    + URLEncoder.encode(mInput, "UTF-8"))).getEntity().getContent(), "utf-8"), 8).readLine();
            String a=Untils.paserTranslate(str1);
            Toast.makeText(getActivity(), ""+a, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void initViewMain() {
    }

    @OnClick(R.id.im_hoi)
    public void success(){
        hideSoftKeyboard();
        DialogContribute contribute=new DialogContribute(getActivity());
        contribute.show();
    }
    public void hideSoftKeyboard() {
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(
                Context.INPUT_METHOD_SERVICE
        );
        imm.hideSoftInputFromWindow(edtSearch.getWindowToken(), 0);
    }

}
