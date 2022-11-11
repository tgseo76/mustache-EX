package com.mustache.bbs.controller;

import com.mustache.bbs.domain.dto.ArticleDto;
import com.mustache.bbs.domain.entity.Article;
import com.mustache.bbs.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/articles")
@Slf4j //log 사용할수있는 어노테이션
public class ArticleController {
//스프링이 article래포지토리 구현체를 di
//    @Autowired
    private final ArticleRepository articleRepository;

    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping("/list")
    public String list(Model model){
        List<Article> articles=articleRepository.findAll();
        model.addAttribute("articles",articles);
        return "articles/list";
    }

    @GetMapping("")
    public String index(){
        return "redirect:/articles/list";
    }

    @GetMapping(value = "/new")
    public String newArticleForm() {
        return "articles/new";
    }

    @GetMapping("/{id}")
    public String selectSingle(@PathVariable Long id, Model model) {
        Optional<Article> optArticle = articleRepository.findById(id);

        if (!optArticle.isEmpty()) {
            // Optional.get() ---> Article
            model.addAttribute("article", optArticle.get());
            return "/articles/show";
        } else {
            return "/articles/error";
        }
    }

    @GetMapping("/{id}/edit")
    public String delete(@PathVariable Long id, Model model) {
        Optional<Article> optionalArticle = articleRepository.findById(id);

        if (!optionalArticle.isEmpty()) {
            // Optional.get() ---> Article
            model.addAttribute("article", optionalArticle.get());
            return "/articles/edit";
        } else {
            model.addAttribute("message", String.format("%d가 없습니다",id));
            return "/articles/error";
        }
    }


    @PostMapping(value = "/posts")
    public String createArticle(ArticleDto form) {
        // 실무에서 println 안씀 로그를 쓴다(서버에서 일어나는 일을 기록하는것)
        log.info(form.toString());
        Article article = form.toEntity();
        articleRepository.save(article);
        return String.format("redirect:/articles/%d", article.getId());
    }
    //    @PostMapping(value = "/posts")
//    public String createArticle(ArticleDto form) {
//        // 실무에서 println 안씀 로그를 쓴다(서버에서 일어나는 일을 기록하는것)
//        log.info(form.toString());
//        Article article = form.toEntity();
//        articleRepository.save(article);
//        return "";
//    }

//    @PostMapping("")
//    public String add(ArticleDto articleDto) {
////        log.info(articleDto.getTitle());
//        Article savedArticle = articleRepository.save(articleDto.toEntity());
////        log.info("generatedId:{}", savedArticle.getId());
//        // souf %d %s
//        return String.format("redirect:/articles/%d", savedArticle.getId());
//    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable Long id, ArticleDto articleDto, Model model) {
        log.info("title:{} content:{}", articleDto.getTitle(), articleDto.getContent());
        Article article = articleRepository.save(articleDto.toEntity());
        model.addAttribute("article", article);
        return String.format("redirect:/articles/%d",article.getId());
    }

//삭제
    @GetMapping("/{id}/delete")
    public String edit(@PathVariable Long id){
        articleRepository.deleteById(id);
        return "redirect:/articles";
    }


}

