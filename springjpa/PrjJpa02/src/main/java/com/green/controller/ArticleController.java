package com.green.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.green.dto.ArticleDto;
import com.green.dto.ArticleForm;
import com.green.entity.Article;
import com.green.repository.ArticleRepository;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class ArticleController {

	@Autowired
	private ArticleRepository articleRepository;

	@GetMapping("/articles/WriteForm")
	public String writeForm() {
		return "articles/write";
	}

	// 405 에러 : method="post" -> @GetMapping
	// 에러 : @GetMapping("/articles/Write")
	@PostMapping("/articles/Write")
	public String write(ArticleDto articleDto) {
		// 넘어온 데이터 확인
		System.out.println(articleDto.toString()); // 책 : ArticleForm
		// db 에 저장 h2 article 테이블에 저장
		// Entity : db 의 테이블이다
		// 1. Dto -> Entity
		Article article = articleDto.toEntity();
		// 2. 리포지터리(인터페이스)를 사용하여 엔티티을 저장
		Article saved = articleRepository.save(article);
		System.out.println("saved :" + saved);
		return "redirect:/articles/List";
	}

	@GetMapping("/articles/List")
	public String articleList(Model model) {
		
		//1. List<Article> articleEntityList = (List<Article>)articleRepository.findAll();
		// 2. ArticleRepository에 함수 등록
		// 3. Iterable<Article> read = articleRepository.findAll();
		List<Article> articleEntityList = articleRepository.findAll();
		model.addAttribute("read", articleEntityList);
		return "articles/list";
	}

	@GetMapping("/articles/{id}")
	public String view(Model model, @PathVariable Long id) {
		/*
		 * Optional<Article> articleOptional = articleRepository.findById(id); if
		 * (articleOptional.isPresent()) { Article article = articleOptional.get();
		 * model.addAttribute("view", article); // Optional에서 Article 객체를 추출하여 추가 } else
		 * { return "redirect:/"; }
		 */
		
		 Article article = articleRepository.findById(id).orElse(null);
		 model.addAttribute("view", article);
		

		return "articles/view";
	}

	@GetMapping("/articles/Update/{id}")
	public String articleUpdate(Model model, @PathVariable("id") Long id) {
		 Article article = articleRepository.findById(id).orElse(null);
		 model.addAttribute("view", article);
		return "articles/update";
	}

	@PutMapping("/articles/Update/{id}")
	public String updateArticle(Model model, ArticleForm articleForm, @PathVariable("id") Long id) {
		 Article articleEntity = articleForm.toEntity();		 
		 Article target = articleRepository.findById(articleEntity.getId()).orElse(null);
		 if (target != null) {
	            articleRepository.save(articleEntity);  // 엔티티를 DB에 저장(갱신)
	        }
		return "redirect:/articles/List";
	 
	}


	@DeleteMapping("/articles/Delete/{id}")
	public String deleteArticle(@PathVariable("id") Long id, RedirectAttributes rttr) {
        log.info("삭제 요청이 들어왔습니다!!");
        // 1. 삭제할 대상 가져오기
        Article target = articleRepository.findById(id).orElse(null);
        log.info(target.toString());
        // 2. 대상 엔티티 삭제하기
        if (target != null) {
            articleRepository.delete(target);
            rttr.addFlashAttribute("msg", "삭제됐습니다!");
        }
        // 3. 결과 페이지로 리다이렉트하기
        return "redirect:/";
	}
}
