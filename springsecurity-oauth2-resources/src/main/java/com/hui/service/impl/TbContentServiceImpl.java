package com.hui.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hui.entity.TbContent;
import com.hui.mapper.TbContentMapper;
import com.hui.service.TbContentService;
import org.springframework.stereotype.Service;

@Service
public class TbContentServiceImpl extends ServiceImpl<TbContentMapper, TbContent> implements TbContentService {

}

