package com.example.demo.dto;

import lombok.Data;

@Data
public class ReviewDTO {
	private int id;
	private String type;
	private String action;
	private String reviewId;
	private String content;
	private String[] attachedPhotoIds;
	private String userId;
	private String placeId;
	private int point;
}
