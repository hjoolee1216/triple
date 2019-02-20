package com.example.demo.mapper;

import org.springframework.stereotype.Repository;

import com.example.demo.dto.ReviewDTO;
import com.example.demo.vo.MemberReviewVO;

import java.util.Map;

@Repository
public interface ReviewMapper {
    void insertMember(Map<String,Object> params);

    int selectMemberEmail(String email);

	MemberReviewVO selectMemberInfo(Map<String, Object> params);

	MemberReviewVO selectUserReviewByPlaceId(ReviewDTO review);

	int selectAllReviewByPlaceId(String placeId);

	MemberReviewVO selectUserReviewByReviewId(String reviewId);

	void deleteReviewPoint(Map<String, Object> params);
}
