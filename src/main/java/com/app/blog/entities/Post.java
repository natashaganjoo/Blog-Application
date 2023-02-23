package com.app.blog.entities;

import java.util.Date;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "posts")
@Data
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int postId;

	private String title;

	private String content;

	private String imgName;

	private Date date;

	// if we don't use @JoinColumn then category_category_id column will be created
	// so to change name of joined column we will use @JouinColumn
	@ManyToOne()
	@JoinColumn(name = "category_id")
	private Category category;

	@ManyToOne()
	@JoinColumn(name = "user_id")
	private User user;
}
