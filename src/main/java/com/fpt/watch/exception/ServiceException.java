package com.fpt.watch.exception;

import com.fpt.watch.enums.BaseEnum;

import lombok.Getter;
import org.apache.poi.ss.formula.functions.T;


@Getter
public class ServiceException extends RuntimeException {
    private int code;

    public ServiceException(int code,String message){
        super(message);
        this.code = code;
    }

    public ServiceException(BaseEnum<T> e){
        super(e.getMessage());
        this.code = e.getCode();
    }


}
