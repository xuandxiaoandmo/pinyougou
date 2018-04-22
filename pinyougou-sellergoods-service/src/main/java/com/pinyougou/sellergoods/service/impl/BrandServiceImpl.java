package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;
import com.pinyougou.mapper.mapper.TbBrandMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author steven
 * @version 1.0
 * @description com.pinyougou.sellergoods.service.impl
 * @date 2018/4/22
 */

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private TbBrandMapper tbBrandMapper;
    @Override
    public List<TbBrand> findAll() {
        return tbBrandMapper.selectByExample(null);
    }
}
