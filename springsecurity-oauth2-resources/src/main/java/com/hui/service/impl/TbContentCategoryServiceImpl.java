package com.hui.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hui.entity.TbContentCategory;
import com.hui.mapper.TbContentCategoryMapper;
import com.hui.service.TbContentCategoryService;
@Service
public class TbContentCategoryServiceImpl extends ServiceImpl<TbContentCategoryMapper, TbContentCategory> implements TbContentCategoryService{

}
