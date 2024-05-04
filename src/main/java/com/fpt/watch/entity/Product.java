package com.fpt.watch.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author watch
 * @since 5/4/2024
 */
@Getter
@Setter
@TableName("product")
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("name")
    private String name;

    @TableField("status")
    private Integer status;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss", timezone = "GMT+7")
    @TableField("create_time")
    private Timestamp createTime;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss", timezone = "GMT+7")
    @TableField("update_time")
    private Timestamp updateTime;

    @TableField("is_deleted")
    @TableLogic
    private Integer deleteFlag;
}
