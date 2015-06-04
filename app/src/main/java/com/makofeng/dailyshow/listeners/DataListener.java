package com.makofeng.dailyshow.listeners;

/**
 * 通用数据Listener
 * Created by 冯浩 on 2015/6/4.
 */
public interface DataListener<T> {
    public void onComplete(T result);
}
