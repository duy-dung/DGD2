package com.example.bum.dgdv2.lockscreen;

import android.app.Notification;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;

import com.example.bum.dgdv2.R;

/**
 * Created by Bum on 16-Aug-17.
 */

public class LockScreenService extends Service {
    private BroadcastReceiver mReceiver;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_ON);
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        mReceiver = new LockScreenReceiver();
        registerReceiver(mReceiver, filter);
        startForeground();
        return START_STICKY;

    }

    private void startForeground() {
        Notification notification = new NotificationCompat.Builder(this)
                .setContentTitle(getResources().getString(R.string.app_name))
                .setTicker(getResources().getString(R.string.app_name))
                .setContentText("Running")
//                .setSmallIcon(R.drawable.ic_launcher)
                .setContentIntent(null)
                .setOngoing(true)
                .build();
        startForeground(9999,notification);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        super.onDestroy();
        unregisterReceiver(mReceiver);
    }
}
