package com.example.bum.dgdv2.module;

import com.example.bum.dgdv2.R;

/**
 * Created by Bum on 07-Aug-17.
 */

public enum  TabItem {
    HOME("HOME_TAB", R.string.title_home, R.drawable.ic_home),
    MYLITS("MY_LIST", R.string.my_list, R.drawable.ic_list),
    NOTIFICATION("HOME_NOTIFICATION", R.string.notification, R.drawable.ic_notification),
    SETTINGS("SETTING", R.string.settings, R.drawable.ic_setting);

    private String tag;
    private int name;
    private int icon;

    private TabItem(String tag, int name, int icon) {
        this.tag = tag;
        this.name = name;
        this.icon = icon;
    }

    public String getTag() {
        return tag;
    }

    public int getName() {
        return name;
    }

    public int getIcon() {
        return icon;
    }

    @Override
    public String toString() {
        return tag;
    }
}
