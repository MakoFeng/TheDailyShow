package com.makofeng.dailyshow.net.handlers;

import com.avos.avoscloud.AVObject;
import com.makofeng.dailyshow.model.Article;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by 冯浩 on 2015/6/4.
 */
public class ArticlesHandler implements RespHandler<List<Article>, List<AVObject>> {


    @Override
    public List<Article> parse(List<AVObject> data) {
        List<Article> articleLists = new LinkedList<Article>();

        for (int i = 0; i < data.size(); i++) {
            AVObject avObject = data.get(i);

            Article articleItem = new Article();
            articleItem.setArticleId(avObject.getString("articleId"));
            articleItem.setCategory(avObject.getInt("category"));
            articleItem.setContent(avObject.getString("content"));
            articleItem.setTime(avObject.getString("time"));
            articleItem.setAuthor(avObject.getString("author"));

            articleLists.add(articleItem);
        }
        return articleLists;

    }


}
