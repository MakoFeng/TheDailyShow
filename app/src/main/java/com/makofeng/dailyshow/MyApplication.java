package com.makofeng.dailyshow;

import android.app.Application;

import com.avos.avoscloud.AVOSCloud;
import com.makofeng.dailyshow.util.Constants;

/**
 * Created by 冯浩 on 2015/6/2.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化leancloud
        AVOSCloud.initialize(this, Constants.APP_ID, Constants.APP_KEY);
    }
}
