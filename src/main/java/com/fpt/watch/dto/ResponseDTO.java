package com.fpt.watch.dto;


import com.fpt.watch.enums.BaseEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.poi.ss.formula.functions.T;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO {
    private int code;

    private String message;

    private Object data;

    private String token;

    public ResponseDTO(int code, String message){
        this.code = code;
        this.message = message;
    }

    public ResponseDTO(int code, String message, Object data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResponseDTO(BaseEnum<T> e){
        this.code = e.getCode();
        this.message = e.getMessage();
    }

    public ResponseDTO(BaseEnum<T> e, Object data){
        this.code = e.getCode();
        this.message = e.getMessage();
        this.data = data;
    }

    public ResponseDTO(BaseEnum<T> e, Object data, String token){
        this.code = e.getCode();
        this.message = e.getMessage();
        this.data = data;
        this.token = token;
    }

}
