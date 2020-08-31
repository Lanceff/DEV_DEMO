package com.hui.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hui.entity.TbPermission;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TbPermissionMapper extends BaseMapper<TbPermission> {

    @Select("SELECT  p.enname\n" +
            "FROM tb_user AS u\n" +
            "  LEFT JOIN tb_user_role AS ur ON u.id = ur.user_id\n" +
            "  LEFT JOIN tb_role AS r ON r.id = ur.role_id\n" +
            "  LEFT JOIN tb_role_permission AS rp ON r.id = rp.role_id\n" +
            "  LEFT JOIN tb_permission AS p ON p.id = rp.permission_id\n" +
            "WHERE u.id = #{userId}")
    List<String> selectPermissionByUserId(@Param("userId") Integer userId);
}