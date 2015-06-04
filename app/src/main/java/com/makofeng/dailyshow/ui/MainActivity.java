package com.makofeng.dailyshow.ui;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.util.Log;

import com.avos.avoscloud.AVException;
import com.makofeng.dailyshow.R;
import com.makofeng.dailyshow.listeners.DataListener;
import com.makofeng.dailyshow.listeners.ErrorListener;
import com.makofeng.dailyshow.model.Article;
import com.makofeng.dailyshow.net.ArticleAPI;
import com.makofeng.dailyshow.net.impl.ArticleAPIImp;


public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";

    // 从网络上获取文章的Api
    ArticleAPI mArticleApi = new ArticleAPIImp();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

//        AVObject article = new AVObject("article");
//        article.put("articleId", "1001");
//        article.put("category", 2);
//        article.put("content", "test");
//        article.put("time", String.valueOf(System.currentTimeMillis()));
//        article.put("author", "makofeng");
//        article.saveInBackground(new SaveCallback() {
//            public void done(AVException e) {
//                if (e == null) {
//                    Log.i(TAG, "保存成功");
//                } else {
//                    Log.i(TAG, "保存失败" + e.getMessage());
//                }
//            }
//        });


        mArticleApi.fetchArticleContent("1001", new DataListener<Article>() {
            @Override
            public void onComplete(Article result) {

                Log.i(TAG, "ArticleId" + result.getArticleId() + "Content" + result.getContent());

            }
        }, new ErrorListener() {
            @Override
            public void onErrorResponse(AVException e) {

                Log.i(TAG, "error" + e.getMessage());

            }
        });

    }

    private void initViews() {
        setupToolbar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        DrawerLayout mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_open,
                R.string.drawer_close);
        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

}
