package com.hui.server.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hui.mapper.CarBrandMapper;
import com.hui.pojo.CarBrand;
import com.hui.server.CarBrandService;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: Lance
 * @create: 2020-07-23 20:53
 **/
@Service
public class CarBrandServiceImpl extends ServiceImpl<CarBrandMapper, CarBrand> implements CarBrandService {
}
