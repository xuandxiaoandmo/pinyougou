package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.pojo.TbBrandExample;
import com.pinyougou.sellergoods.service.BrandService;
import com.pinyougou.mapper.TbBrandMapper;
import entity.ResponseResult;
import entity.ResultPage;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.util.StringUtil;

import java.util.Arrays;
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
    public ResultPage findAll(ResponseResult responseResult) {
        PageHelper.startPage(responseResult.getPageNum(),responseResult.getPageSize());
        TbBrandExample tbBrandExample=null;
        if (responseResult.getDrand()!=null){
            tbBrandExample= new TbBrandExample();
            TbBrandExample.Criteria criteria = tbBrandExample.createCriteria();
            TbBrand drand = responseResult.getDrand();
            if (StringUtil.isNotEmpty(drand.getName())){
                criteria.andNameLike("%"+drand.getName()+"%");
            }
            if (StringUtil.isNotEmpty(drand.getFirstChar())){
                criteria.andFirstCharLike(drand.getFirstChar());
            }
        }
        List<TbBrand> tbBrands = tbBrandMapper.selectByExample(tbBrandExample);
        Page page=  (Page)tbBrands;
        return new ResultPage(page.getTotal(),page.getResult());
    }

    @Override
    public TbBrand findOne(Long id) {
        TbBrand tbBrand = tbBrandMapper.selectByPrimaryKey(id);
        return tbBrand;
    }

    @Override
    public void update(TbBrand tbBrand) {
        tbBrandMapper.updateByPrimaryKey(tbBrand);
    }

    @Override
    public void add(TbBrand tbBrand) {
        tbBrandMapper.insert(tbBrand);
    }

    @Override
    public void delete(Long [] ids) {

        List<Long> longs = Arrays.asList(ids);
        TbBrandExample tbBrandExample=new TbBrandExample();
        TbBrandExample.Criteria criteria = tbBrandExample.createCriteria();
        criteria.andIdIn(longs);
        tbBrandMapper.deleteByExample(tbBrandExample);

    }


}
