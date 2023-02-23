package com.app.blog.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
//@NoArgsConstructor
//@Getter
//@Setter
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;

	@Column(name = "user_name", nullable = false, length = 100)
	@NotBlank
	private String username;

	@Email @NotBlank
	private String email;

	@NotNull @NotBlank
	private String password;

	@NotNull @NotBlank
	private String about;

//	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//	private List<Post> posts = new ArrayList<>();
}
