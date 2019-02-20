package com.example.demo.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class MemberPointResponse extends ResponseResult {
	private UserPointVO pointVO;
	
}
