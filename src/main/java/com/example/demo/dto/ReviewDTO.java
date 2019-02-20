package com.example.demo.dto;

import lombok.Data;

@Data
public class ReviewDTO {
	private String type;
	private String action;
	private String reviewId;
	private String content;
	private String[] attchedPhotoIds;
	private String userId;
	private String placeId;
}
