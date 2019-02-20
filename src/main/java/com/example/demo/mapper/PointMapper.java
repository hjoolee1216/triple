package com.example.demo.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.vo.UserPointLogVO;
import com.example.demo.vo.UserPointVO;

@Repository
public interface PointMapper {

	UserPointVO selectMemberPoint(String userId);

	List<UserPointLogVO> selectMemberPointLog(String userId);

}
