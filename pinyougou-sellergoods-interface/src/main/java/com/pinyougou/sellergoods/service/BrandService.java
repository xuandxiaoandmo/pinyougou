package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbBrand;
import entity.ResponseResult;
import entity.ResultPage;

import java.util.List;

public interface BrandService {


    ResultPage findAll(ResponseResult responseResult);

    TbBrand findOne(Long id);

    void update(TbBrand tbBrand);

    void add(TbBrand tbBrand);

    void delete(Long [] ids);
}





