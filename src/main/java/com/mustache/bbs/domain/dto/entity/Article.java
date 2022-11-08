package com.mustache.bbs.domain.dto.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity // -> JPA에서 객체로 다루겠다는 선언
@NoArgsConstructor
@Getter
public class Article {
    @Id //→ @Entity가 붙어있다면 꼭 붙여주어야 합니다. Primary Key를 의미 합니다. entitiy랑 세트
    @GeneratedValue //자동 생성 아아디 0분부터 자동으로 넣어준다
    private Long id;
    private String title;
    private String content;

    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
