package com.example.demo.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardVO {
	private Integer id;
	private String title;
	private String contents;
	private Date created_at;
	private Date updated_at;
	private String writer;
}
