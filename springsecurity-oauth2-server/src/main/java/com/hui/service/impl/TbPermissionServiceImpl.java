package com.hui.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hui.entity.TbPermission;
import com.hui.mapper.TbPermissionMapper;
import com.hui.service.TbPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbPermissionServiceImpl extends ServiceImpl<TbPermissionMapper, TbPermission> implements TbPermissionService {
    @Autowired
    private TbPermissionMapper tbPermissionMapper;

    @Override
    public List<String> selectPermissionByUserId(Integer userId) {
        return tbPermissionMapper.selectPermissionByUserId(userId);
    }
}
