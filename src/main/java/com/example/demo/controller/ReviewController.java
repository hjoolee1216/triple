package com.example.demo.controller;

import com.example.demo.constant.Constant;
import com.example.demo.dto.ReviewDTO;
import com.example.demo.service.ReviewService;
import com.example.demo.vo.MemberReviewVO;
import com.example.demo.vo.UserPointLogVO;
import com.example.demo.vo.UserPointVO;
import com.example.demo.vo.MemberPointHistoryResponse;
import com.example.demo.vo.MemberPointResponse;
import com.example.demo.vo.MemberResponse;

import io.swagger.annotations.ApiOperation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @RequestMapping(value = "/point/add", method = RequestMethod.POST)
    @ApiOperation(value="리뷰 생성 ", notes= "리뷰생성 ")
    public MemberResponse add(@RequestBody ReviewDTO review) throws Exception {
        int point = 0;
        MemberReviewVO memberReviewVO = null;
        if(review.getAction().equals(Constant.ADD)) {
        	memberReviewVO = reviewService.getUserReviewByPlaceId(review);
        	if(memberReviewVO == null) {
        		if(review.getContent().length() > 0) {
        			point++;
        		}
        		
        	}
        	
        	if(review.getAttachedPhotoIds().length > 0) {
        		point++;
        	}
        	if(firstPlaceReview(review.getPlaceId())) {
        		point++;
        	}
        	
        } else if(review.getType().equals(Constant.DELETE)) {
        	memberReviewVO = reviewService.getUserReviewByReviewId(review);
        	if(memberReviewVO != null) {
        		deleteMemberPoint(memberReviewVO.getPoint(), review);
        	}
        } else {
        	memberReviewVO = reviewService.getUserReviewByReviewId(review);
        	if(review.getAttachedPhotoIds().length > memberReviewVO.getPhoto().size()) {
        		point++;
        	} else {
        		deleteMemberPoint(1, review);
        	}
        	
        }
        review.setPoint(point);
        reviewService.addReviewPoint(review);
        return MemberResponse.builder().code("200").msg("success").build();
    }


	private void deleteMemberPoint(int point, ReviewDTO review) {
		review.setPoint(point);
		reviewService.deleteReviewPoint(review);
	}


    private boolean firstPlaceReview(String placeId) {
		int count = reviewService.getAllReviewByPlaceId(placeId);
		
		return (count > 0)? false : true;
	}


    @RequestMapping(value = "/point/get", method = RequestMethod.GET)
    @ApiOperation(value="포인트 조회 ", notes= "포인트 조회 ")
    public MemberPointResponse get(@RequestParam("userId") String userId) {

		UserPointVO pointVO = reviewService.getMemberPoint(userId);

        return MemberPointResponse.builder().pointVO(pointVO).build();
    }
    
    
    @RequestMapping(value = "/point/history", method = RequestMethod.GET)
    @ApiOperation(value="포인트 이력 조회 ", notes= "포인트 이력 조회 ")
    public MemberPointHistoryResponse history(@RequestParam("userId") String userId) {

		List<UserPointLogVO> pointLogList = reviewService.getMemberPointLog(userId);

        return MemberPointHistoryResponse.builder().pointLogList(pointLogList).build();
    }
}
