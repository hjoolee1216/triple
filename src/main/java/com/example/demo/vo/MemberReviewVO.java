package com.example.demo.vo;

import java.util.List;

import lombok.Data;

@Data
public class MemberReviewVO {
	private String reviewId;
	private String content;
	private String placeId;
	private int point;
	
	private List<String> photo;
}
