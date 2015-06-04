package com.makofeng.dailyshow.net.impl;

import android.util.Log;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.FindCallback;
import com.makofeng.dailyshow.listeners.DataListener;
import com.makofeng.dailyshow.listeners.ErrorListener;
import com.makofeng.dailyshow.model.Article;
import com.makofeng.dailyshow.net.ArticleAPI;
import com.makofeng.dailyshow.net.handlers.ArticlesHandler;

import java.util.List;

/**
 * Created by 冯浩 on 2015/6/4.
 */
public class ArticleAPIImp implements ArticleAPI {

    private int mPage = 1;

    ArticlesHandler articlesHandler;

    public ArticleAPIImp() {
        articlesHandler = new ArticlesHandler();
    }


    @Override
    public void fetchArticles(int category, DataListener<List<Article>> listener, ErrorListener errorListener) {

    }

    @Override
    public void fetchArticleContent(String articleId, final DataListener<Article> listener, final ErrorListener errorListener) {


//        AVQuery<AVObject> query = AVQuery.getQuery("article");
//        query.whereEqualTo("articleId", articleId);
//        query.countInBackground(new CountCallback() {
//            public void done(int count, AVException e) {
//                if (e == null) {
//                    // The count request succeeded. Log the count
//                    Log.d("成功", "查询到" + count + " 条符合条件的数据");
//                } else {
//                    Log.d("失败", "查询错误: " + e.getMessage());
//                }
//            }
//        });

        AVQuery<AVObject> query = AVQuery.getQuery("article");
        query.whereEqualTo("articleId", articleId);
        query.findInBackground(new FindCallback<AVObject>() {
            public void done(List<AVObject> avObjects, AVException e) {
                if (e == null) {

                    listener.onComplete(articlesHandler.parse(avObjects).get(0));
                    Log.d("成功", "查询到" + avObjects.size() + " 条符合条件的数据");
                } else {
                    errorListener.onErrorResponse(e);
                    Log.d("失败", "查询错误: " + e.getMessage());
                }
            }
        });
    }

    @Override
    public void loadMore(int category, DataListener<List<Article>> listener, ErrorListener errorListener) {

    }

    private void performRequest(final int page, int category,
                                final DataListener<List<Article>> listener, ErrorListener errorListener) {

        AVQuery<AVObject> query = new AVQuery<AVObject>("article");
        query.whereEqualTo("playerName", "steve");
        query.findInBackground(new FindCallback<AVObject>() {
            public void done(List<AVObject> avObjects, AVException e) {
                if (e == null) {
                    Log.d("成功", "查询到" + avObjects.size() + " 条符合条件的数据");
                } else {
                    Log.d("失败", "查询错误: " + e.getMessage());
                }
            }
        });


//        JsonArrayRequest request = new JsonArrayRequest(
//                "http://www.devtf.cn/api/v1/?type=articles&page=" + mPage + "&count=20&categoty="
//                        + category,
//                new Listener<JSONArray>() {
//
//                    @Override
//                    public void onResponse(JSONArray jsonArray) {
//                        if (listener != null) {
//                            // 解析结果
//                            listener.onComplete(mRespHandler.parse(jsonArray));
//                        }
//                    }
//                }, errorListener);
//        RequestQueueMgr.getRequestQueue().add(request);
    }
}
