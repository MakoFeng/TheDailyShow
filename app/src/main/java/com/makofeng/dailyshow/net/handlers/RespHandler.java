package com.makofeng.dailyshow.net.handlers;

/**
 * Created by 冯浩 on 2015/6/4.
 */
public interface RespHandler<T, D> {
    public T parse(D data);
}
