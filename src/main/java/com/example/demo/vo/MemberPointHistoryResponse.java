package com.example.demo.vo;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class MemberPointHistoryResponse extends ResponseResult {
	private List<UserPointLogVO> pointLogList;
	
}
