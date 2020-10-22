package com.example.demo.domain;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class PagingVO<T> {

	private List<T> list;
	// 현재 페이지
	private int nowPage;
	// 시작 페이지
	private int startPage;
	// 마지막 페이지
	private int endPage;
	// 총 갯수
	private int total;
	// 페이지 당 글 갯수
	private int size = 5;
	// 마지막 페이지
	private int lastPage;
	//SQL쿼리에 쓸 start
	private int start;
	
	//바닥에 보여줄 버튼 갯수
	private int cntPage = 5;
	
	public void LastPageNum(int total) {
		setLastPage((int)Math.ceil((double)total / (double)size));
	}
	
	public void calcStartEndPage(int nowPage) {
		setEndPage(((int)Math.ceil((double)nowPage / (double)cntPage)) * cntPage);
		setStartPage(((int)Math.ceil(((double)nowPage / (double)cntPage)-1) * cntPage) + 1);
		
		if(getLastPage() < getEndPage()) {
			setEndPage(getLastPage());
		}
		
		if(getStartPage() < 1 || nowPage <= 5) {
			setStartPage(1);
		}
	}
	
	public void StartBoard(int nowPage) {
		setStart((nowPage - 1) * size);
	}
	
	public PagingVO(int nowPage, int total) {
		setNowPage(nowPage);
		setTotal(total);
		LastPageNum(getTotal());
		StartBoard(nowPage);
		calcStartEndPage(nowPage);
	}
	
	

}
