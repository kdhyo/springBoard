package com.example.demo.domain;

import java.util.Date;

import com.example.demo.mapper.BoardMapper;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class BoardVO {
	private Integer id;
	private String title;
	private String contents;
	private Date created_at;
	private Date updated_at;
	private String writer;
}
