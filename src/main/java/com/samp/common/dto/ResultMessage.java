package com.samp.common.dto;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResultMessage {

    private String successYn;  // 성공/실패 여부
    private String statusCode; // HttpStatus code
    private String code; // 업무별  코드
    private Object obj;	 // 전달할 Data Pojo 객체
    private String message;
    private String devMessage; // 디버그용 에러 메세지
}
