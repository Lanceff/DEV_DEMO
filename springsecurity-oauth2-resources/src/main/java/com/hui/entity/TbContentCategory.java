package com.hui.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
    * 内容分类
    */
@Data
@AllArgsConstructor
@TableName(value = "tb_content_category")
public class TbContentCategory {
    /**
     * 类目ID
     */
    @TableId(value = "id", type = IdType.INPUT)
    private Long id;

    /**
     * 父类目ID=0时，代表的是一级的类目
     */
    @TableField(value = "parent_id")
    private Long parentId;

    /**
     * 分类名称
     */
    @TableField(value = "`name`")
    private String name;

    /**
     * 状态。可选值:1(正常),2(删除)
     */
    @TableField(value = "`status`")
    private Integer status;

    /**
     * 排列序号，表示同级类目的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数
     */
    @TableField(value = "sort_order")
    private Integer sortOrder;

    /**
     * 该类目是否为父类目，1为true，0为false
     */
    @TableField(value = "is_parent")
    private Boolean isParent;

    /**
     * 创建时间
     */
    @TableField(value = "created")
    private LocalDateTime created;

    /**
     * 创建时间
     */
    @TableField(value = "updated")
    private LocalDateTime updated;

    public static final String COL_ID = "id";

    public static final String COL_PARENT_ID = "parent_id";

    public static final String COL_NAME = "name";

    public static final String COL_STATUS = "status";

    public static final String COL_SORT_ORDER = "sort_order";

    public static final String COL_IS_PARENT = "is_parent";

    public static final String COL_CREATED = "created";

    public static final String COL_UPDATED = "updated";
}