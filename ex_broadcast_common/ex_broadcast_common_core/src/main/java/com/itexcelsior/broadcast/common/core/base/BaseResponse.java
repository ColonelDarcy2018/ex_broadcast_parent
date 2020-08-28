package com.itexcelsior.broadcast.common.core.base;

import lombok.Data;

/**
 * @author zxw </br>
 * @create 11:17  2020/8/21 </br>
 * @description: </br>
 */
@Data
public class BaseResponse<T> {

    /**
     * 返回码
     */
    private Integer code;
    /**
     * 消息
     */
    private String msg;
    /**
     * 返回
     */
    private T data;
    // 分页

    public BaseResponse() {

    }

    public BaseResponse(Integer code, String msg, T data) {
        super();
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

}
