package com.green.dto;

import com.green.entity.Article;

public class ArticleDto {
	// Field
	private Long id;
	private String title;
	private String content;

	// Getter / Setter

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "ArticleDto [title=" + title + ", content=" + content + "]";
	}
	
	public Article toEntity() {
		Article article = new Article(id, title, content);
		return  article;
	}
	
}


