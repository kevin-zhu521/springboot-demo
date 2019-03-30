package com.xiaoi.repository;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.xiaoi.ElasticsearchApplicationTests;
import com.xiaoi.bean.Article;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

import java.util.List;

/**
 * @author kevin.zhu
 * @date 2019/3/30 21:32
 */
public class ArticleRepositoryTest extends ElasticsearchApplicationTests{

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Test
    public void saveArticle(){
        Article article = new Article();
        article.setId(3);
        article.setTitle("吃玩");
        article.setContent("肌肉好吃");
        articleRepository.save(article);
    }
    @Test
    public void findArticle(){
        Article article = new Article();
        article.setId(2);
        Article article1 = articleRepository.findOne(article.getId());
        System.out.println(article1);
    }

    @Test
    public void findArticleByContent(){
        List<Article> lists = articleRepository.findArticleByContentLike("肌肉");
        System.out.println(lists);
    }

}