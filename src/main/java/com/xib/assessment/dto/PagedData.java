package com.xib.assessment.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

import lombok.Data;

@Data
public class PagedData<T> {

    private List<T> resultList;
	int noOfItems;
	long totalCount;
	int pageNo;
	int totalPage;
	
	public PagedData(Page<T> page) {
		this.resultList=page.getContent()!=null?page.getContent():new ArrayList<>();
		this.noOfItems=page.getNumberOfElements();
		this.totalCount=page.getTotalElements();
		this.pageNo=page.getNumber();
		this.totalPage=page.getTotalPages();
		
	}
}
