package com.example.demo.vo;

import lombok.Data;

@Data
public class UserPointVO {
	private String userId;
	private String current_point;
	private String accum_point;
	private String delete_point;
}
