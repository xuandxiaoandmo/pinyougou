package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 *
 * 处理商品品牌的web层
 * @author steven
 * @version 1.0
 * @description com.pinyougou.manager.controller
 * @date 2018/4/21
 */
@Controller
@RequestMapping("/brand")
public class BreanController {


    @Reference
    private BrandService brandService;


    @RequestMapping("findAll")
    @ResponseBody
    public  List<TbBrand> findAll(){
        List<TbBrand>tbBrands= brandService.findAll();
        return tbBrands;
    }





}
