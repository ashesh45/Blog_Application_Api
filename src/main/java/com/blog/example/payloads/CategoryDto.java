package com.blog.example.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDto {
	
	private int CategoryId;
	private String categoryTitle;
	private String categoryDescription;

}
