package com.xiaoi.repository;

import com.xiaoi.bean.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;


/**
 * @author kevin.zhu
 * @date 2019/3/30 21:26
 */
public interface ArticleRepository extends ElasticsearchRepository<Article, Integer>{
    List<Article> findArticleByContentLike(String part);
}
