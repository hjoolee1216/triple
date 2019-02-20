package com.example.demo.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.dto.ReviewDTO;
import com.example.demo.vo.UserPointLogVO;
import com.example.demo.vo.UserPointVO;

@Repository
public interface PointMapper {

	UserPointVO selectMemberPoint(String userId);

	List<UserPointLogVO> selectMemberPointLog(String userId);

	void insertMemberPoint(ReviewDTO review);

	void insertMemberPointLog(ReviewDTO review);

	void deleteReviewPoint(ReviewDTO review);

	void deleteMemberPointLog(ReviewDTO review);

}
