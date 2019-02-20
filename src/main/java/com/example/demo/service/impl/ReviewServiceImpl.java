package com.example.demo.service.impl;


import com.example.demo.dto.ReviewDTO;
import com.example.demo.mapper.PointMapper;
import com.example.demo.mapper.ReviewMapper;
import com.example.demo.service.ReviewService;
import com.example.demo.vo.MemberReviewVO;
import com.example.demo.vo.UserPointLogVO;
import com.example.demo.vo.UserPointVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewMapper reviewMapper;
    
    @Autowired
    private PointMapper pointMapper;


	@Override
	public MemberReviewVO getUserReviewByPlaceId(ReviewDTO review) {
		
		return reviewMapper.selectUserReviewByPlaceId(review);
	}


	@Override
	public int getAllReviewByPlaceId(String placeId) {
		
		return reviewMapper.selectAllReviewByPlaceId(placeId);
	}


	@Override
	public MemberReviewVO getUserReviewByReviewId(String reviewId) {
		
		return reviewMapper.selectUserReviewByReviewId(reviewId);
	}


	@Override
	public void deleteReviewPoint(int point, ReviewDTO review) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("point", point);
		params.put("reviewId", review.getReviewId());
		reviewMapper.deleteReviewPoint(params);
		
	}


	@Override
	public UserPointVO getMemberPoint(String userId) {
		
		return pointMapper.selectMemberPoint(userId);
	}


	@Override
	public void addReviewPoint(int point, ReviewDTO review) {
		
		
	}


	@Override
	public List<UserPointLogVO> getMemberPointLog(String userId) {
		return pointMapper.selectMemberPointLog(userId);
	}


	@Override
	public void addUserReview(ReviewDTO review) {
		// TODO Auto-generated method stub
		
	}
}
