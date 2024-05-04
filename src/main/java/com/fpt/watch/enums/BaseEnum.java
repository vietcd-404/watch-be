package com.fpt.watch.enums;

import java.io.Serializable;


public interface BaseEnum<T> extends Serializable {
    /**
     * Lấy mã
     * 
     * @return
     */
    Integer getCode();

    /**
     * Nội dung thông báo
     * 
     * @return
     */
    String getMessage();
}
