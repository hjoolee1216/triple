package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ReviewDTO;
import com.example.demo.vo.MemberReviewVO;
import com.example.demo.vo.UserPointLogVO;
import com.example.demo.vo.UserPointVO;

public interface ReviewService {


	MemberReviewVO getUserReviewByPlaceId(ReviewDTO review);

	int getAllReviewByPlaceId(String placeId);

	MemberReviewVO getUserReviewByReviewId(String reviewId);

	void deleteReviewPoint(int point, ReviewDTO review);

	UserPointVO getMemberPoint(String userId);

	void addReviewPoint(int point, ReviewDTO review);

	List<UserPointLogVO> getMemberPointLog(String userId);

	void addUserReview(ReviewDTO review);
}
