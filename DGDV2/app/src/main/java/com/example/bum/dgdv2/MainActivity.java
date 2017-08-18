package com.example.bum.dgdv2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import android.view.MenuItem;


import android.widget.TextView;

import com.example.bum.dgdv2.fragment.chat.FragmentChat;
import com.example.bum.dgdv2.fragment.home.FragmentHome;
import com.example.bum.dgdv2.fragment.list.FragmentMyList;
import com.example.bum.dgdv2.fragment.notification.FragmentNotification;
import com.example.bum.dgdv2.fragment.setting.FragmentSetting;
import com.example.bum.dgdv2.lockscreen.LockScreenActivity;


public class MainActivity extends AppCompatActivity {
    private TextView mTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;
                switch (item.getItemId()) {
                    case R.id.tab_home:
                        selectedFragment= FragmentHome.newInstance();
                        break;
                    case R.id.tab_list:
                        selectedFragment=FragmentMyList.newInstance();
                        break;
                    case R.id.tab_notifition:
                        selectedFragment=FragmentNotification.newInstance();
                        break;
                    case R.id.tab_setting:
                        selectedFragment=FragmentSetting.newInstance();
                        break;
                    case R.id.tab_chat:
                        selectedFragment= FragmentChat.newInstance();
                        break;
                }
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_layout, selectedFragment);
                transaction.commit();
                return true;
            }
        });
        navigation.setSelectedItemId(R.id.tab_home);
        //defauld fragment


    }

    private void initViews() {

    }


}
