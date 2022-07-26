package com.devskiller.tasks.blog.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Comment {

	private @Id
	@GeneratedValue(strategy= GenerationType.IDENTITY) Long id;

	@ManyToOne
	@JoinColumn(name = "post_id", nullable = false, unique = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Post post;

	private String comment;

	private String author;

	private LocalDateTime creationDate;

	public Comment() {
	}

	public Comment(Long id, Post post, String comment, String author, LocalDateTime creationDate) {
		this.id = id;
		this.post = post;
		this.comment = comment;
		this.author = author;
		this.creationDate = creationDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}
}
