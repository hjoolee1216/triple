package com.example.demo.service.impl;


import com.example.demo.dto.ReviewDTO;
import com.example.demo.mapper.PointMapper;
import com.example.demo.mapper.ReviewMapper;
import com.example.demo.service.ReviewService;
import com.example.demo.vo.MemberReviewVO;
import com.example.demo.vo.ReviewPhotoVO;
import com.example.demo.vo.UserPointLogVO;
import com.example.demo.vo.UserPointVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewMapper reviewMapper;
    
    @Autowired
    private PointMapper pointMapper;


	@Override
	public MemberReviewVO getUserReviewByPlaceId(ReviewDTO review) {
		
		MemberReviewVO reviewVO = reviewMapper.selectUserReviewByPlaceId(review);
		if(reviewVO != null) {
			reviewVO.setPhoto(reviewMapper.selectAllPhoto(review));
		}
		return reviewVO;
	}


	@Override
	public int getAllReviewByPlaceId(String placeId) {
		
		return reviewMapper.selectAllReviewByPlaceId(placeId);
	}


	@Override
	public MemberReviewVO getUserReviewByReviewId(ReviewDTO review) {
		
		MemberReviewVO reviewVO = reviewMapper.selectUserReviewByReviewId(review);
		if(reviewVO != null) {
			reviewVO.setPhoto(reviewMapper.selectAllPhoto(review));
		}
		
		return reviewVO;
	}

	@Transactional
	@Override
	public void deleteReviewPoint(ReviewDTO review) {
		
		pointMapper.deleteReviewPoint(review);
		pointMapper.deleteMemberPointLog(review);
		reviewMapper.deleteReview(review);
		
	}


	@Override
	public UserPointVO getMemberPoint(String userId) {
		
		return pointMapper.selectMemberPoint(userId);
	}


	@Transactional
	@Override
	public void addReviewPoint(ReviewDTO review) {
		reviewMapper.insertReview(review);
		System.out.println(review.getAttachedPhotoIds().length);
		if(review.getAttachedPhotoIds().length>0) {
			ReviewPhotoVO photoVO = null;
			for(int i=0; i<review.getAttachedPhotoIds().length; i++) {
				photoVO = new ReviewPhotoVO();
				photoVO.setPhoto(review.getAttachedPhotoIds()[i]);
				photoVO.setReviewId(review.getReviewId());
				reviewMapper.deletePhoto(photoVO);
				reviewMapper.insertPhoto(photoVO);
			}
		}
		if(review.getId() > 0) {
			pointMapper.insertMemberPoint(review);
			pointMapper.insertMemberPointLog(review);
		}
		
	}


	@Override
	public List<UserPointLogVO> getMemberPointLog(String userId) {
		return pointMapper.selectMemberPointLog(userId);
	}


	
}
