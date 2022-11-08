package com.mustache.bbs.repository;

import com.mustache.bbs.domain.dto.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article,Long> {
}
