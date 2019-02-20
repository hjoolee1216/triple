package com.example.demo.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class MemberResponse extends ResponseResult {
    private String code;
    private String msg;
}
