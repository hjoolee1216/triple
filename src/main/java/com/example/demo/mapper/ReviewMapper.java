package com.example.demo.mapper;

import org.springframework.stereotype.Repository;

import com.example.demo.dto.ReviewDTO;
import com.example.demo.vo.MemberReviewVO;
import com.example.demo.vo.ReviewPhotoVO;

import java.util.List;

@Repository
public interface ReviewMapper {

	MemberReviewVO selectUserReviewByPlaceId(ReviewDTO review);

	int selectAllReviewByPlaceId(String placeId);

	int insertReview(ReviewDTO review);

	MemberReviewVO selectUserReviewByReviewId(ReviewDTO review);

	void deleteReview(ReviewDTO review);

	List<String> selectAllPhoto(ReviewDTO review);

	void insertPhoto(ReviewPhotoVO photoVO);

	void deletePhoto(ReviewPhotoVO photoVO);
}
