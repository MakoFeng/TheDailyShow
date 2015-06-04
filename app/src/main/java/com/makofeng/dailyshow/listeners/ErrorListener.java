package com.makofeng.dailyshow.listeners;

import com.avos.avoscloud.AVException;

/**
 * Created by 冯浩 on 2015/6/4.
 */
public interface ErrorListener {
    public void onErrorResponse(AVException e);
}
