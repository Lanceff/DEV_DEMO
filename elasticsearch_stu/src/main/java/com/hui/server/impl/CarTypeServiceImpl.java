package com.hui.server.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hui.mapper.CarTypeMapper;
import com.hui.pojo.CarType;
import com.hui.server.CarTypeService;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: Lance
 * @create: 2020-07-23 20:48
 **/
@Service
public class CarTypeServiceImpl extends ServiceImpl<CarTypeMapper,CarType> implements CarTypeService {

}
