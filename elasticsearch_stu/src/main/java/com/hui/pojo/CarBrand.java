package com.hui.pojo;

import lombok.Data;

@Data
public class CarBrand {
    private Integer id;

    private Integer uniacid;

    private Integer parentId;

    /**
    * 首字母
    */
    private String initials;

    private String name;

    private String picUrl;

    private Boolean status;

    private Integer sort;

    private Boolean isHot;

    private Integer createTime;

}