package com.example.demo.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardVO {
	private Integer id;
	private String title;
	private String contents;
	private Date created_at;
	private Date updated_at;
	private String writer;
}
