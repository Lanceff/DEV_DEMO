package com.hui.service;

import com.hui.entity.TbPermission;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbPermissionService extends IService<TbPermission> {

    List<String> selectPermissionByUserId(Integer userId);
}
