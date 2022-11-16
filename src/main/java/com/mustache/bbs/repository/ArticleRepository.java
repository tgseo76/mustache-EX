package com.mustache.bbs.repository;

import com.mustache.bbs.domain.dto.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article,Long> {
}
