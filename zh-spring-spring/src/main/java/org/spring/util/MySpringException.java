package org.spring.util;

/**
 * 自定义异常类
 *
 * @author he.zhang
 * @date 2020/2/27 13:53
 */
public class MySpringException extends RuntimeException {

    public MySpringException(String msg){
        super(msg);
    }

}
