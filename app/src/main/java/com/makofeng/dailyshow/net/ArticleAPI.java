package com.makofeng.dailyshow.net;

import com.makofeng.dailyshow.listeners.DataListener;
import com.makofeng.dailyshow.listeners.ErrorListener;
import com.makofeng.dailyshow.model.Article;

import java.util.List;

/**
 * 文章的网络API接口
 * Created by 冯浩 on 2015/6/4.
 */
public interface ArticleAPI {
    /**
     * 根据分类获取文章
     *
     * @param category 文章分类,1代表全部 2代表图文
     * @param listener 监听器
     */
    public void fetchArticles(int category, DataListener<List<Article>> listener,
                              ErrorListener errorListener);

    /**
     * 获取某篇文章的内容
     *
     * @param articleId  文章id
     * @param listener
     */
    public void fetchArticleContent(String articleId, DataListener<Article> listener,
                                    ErrorListener errorListener);

    /**
     * 加载更多文章
     *
     * @param category 分类
     * @param listener
     */
    public void loadMore(int category, DataListener<List<Article>> listener,
                         ErrorListener errorListener);

}
