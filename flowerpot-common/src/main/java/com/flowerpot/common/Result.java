package com.flowerpot.common;

import com.flowerpot.common.enums.CommonResultEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Result
 *
 * @author Mrhan
 * @date 2021/2/24 10:22
 */
@Data
@ApiModel
public class Result<T> {
    @ApiModelProperty("消息")
    private String message;
    @ApiModelProperty("数据")
    private T data;
    @ApiModelProperty("编码")
    private int code;

    public Result(ResultEnum resultEnum, T data) {
        setCode(resultEnum.getCode());
        setMessage(resultEnum.getMessage());
        setData(data);
    }
    public Result(){
        this(CommonResultEnum.SUCCESS, null);
    }
    public Result(T data){
        this(CommonResultEnum.SUCCESS, data);
    }

    /**
     * 创建带 success标志的Result
     * @param data      数据
     * @param <T>       数据类型
     * @return          防护success Result
     */
    public static  <T> Result<T> success(T data) {
        return new Result<>(data);
    }
    /**
     * 创建带 success标志的Result
     * @param <T>       数据类型
     * @return          防护success Result
     */
    public static  <T> Result<T> success() {
        return success(null);
    }

    /**
     * 自定义 Result
     * @param code      code
     * @param message      message
     * @param data      数据
     * @param <T>       数据类型
     * @return          Result
     */
    public static  <T> Result<T> create(int code, String message, T data) {
        Result<T> result = new Result<>(data);
        result.setCode(code);
        result.setMessage(message);
        return result;
    }
    /**
     * 自定义 Result
     * @param resultEnum      ResultEnum
     * @param data      数据
     * @param <T>       数据类型
     * @return          Result
     */
    public static  <T> Result<T> create(ResultEnum resultEnum, T data) {
        return new Result<>(resultEnum, data);
    }
    /**
     * 创建带 error标志的Result
     * @param data      数据
     * @param <T>       数据类型
     * @return          防护error Result
     */
    public static  <T> Result<T> error(T data) {
        return create(CommonResultEnum.ERROR, data);
    }

    /**
     * 创建带 error标志的Result
     * @param message   message
     * @param data      数据
     * @param <T>       数据类型
     * @return          防护error Result
     */
    public static  <T> Result<T> error(String message, T data) {
        Result<T> result = create(CommonResultEnum.ERROR, data);
        result.setMessage(message);
        return result;
    }


    /**
     * 创建带 error标志的Result
     * @param message   message
     * @param <T>       数据类型
     * @return          防护error Result
     */
    public static  <T> Result<T> error(String message) {
        Result<T> result = create(CommonResultEnum.ERROR, null);
        result.setMessage(message);
        return result;
    }



}
