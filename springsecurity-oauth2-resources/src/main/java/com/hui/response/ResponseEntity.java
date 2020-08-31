package com.hui.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Lance
 * @Date: 2020-08-31 14:06
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseEntity<T> {
    private Integer code;
    private String message;
    private T data;
}
