package com.hui.pojo;

import lombok.Data;

@Data
public class CarType {
    private Integer id;

    private Integer uniacid;

    private Integer brandId;

    private String name;

    private String picUrl;

    private Boolean status;

    private Integer sort;

    private Integer createTime;

}