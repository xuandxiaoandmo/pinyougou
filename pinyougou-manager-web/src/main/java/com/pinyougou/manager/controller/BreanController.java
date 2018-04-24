package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;
import entity.ResponseResult;
import entity.Result;
import entity.ResultPage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 处理商品品牌的web层
 *
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


    @RequestMapping("search")
    @ResponseBody
    public ResultPage search(@RequestBody ResponseResult responseResult, ResponseResult dasdd) {
        System.out.println(responseResult);
        ResultPage tbBrands = brandService.findAll(responseResult);

        return tbBrands;
    }

    @RequestMapping("findOne")
    @ResponseBody
    public TbBrand findOne(Long id) {

        TbBrand tbBrand = brandService.findOne(id);

        return tbBrand;
    }


    @RequestMapping("update")
    @ResponseBody
    public Result update(@RequestBody TbBrand tbBrand) {
        Result result = new Result();

        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        try {

            brandService.update(tbBrand);
            result.setSuccess(true);
            result.setMessage("成功啦");
        } catch (Exception e) {

            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage("更新失败!!");
        }

        return result;
    }

    @RequestMapping("add")
    @ResponseBody
    public Result add(@RequestBody TbBrand tbBrand) {
        Result result = new Result();
        try {

            brandService.add(tbBrand);
            result.setSuccess(true);
            result.setMessage("成功啦");
        } catch (Exception e) {

            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage("保存失败");
        }

        return result;
    }

    //delete
    @RequestMapping("delete")
    @ResponseBody
    public Result delete(@RequestBody Long [] ids) {

        Result result = new Result();

        try {
            if (ids != null && ids.length > 0) {
                brandService.delete(ids);
                result.setSuccess(true);
                result.setMessage("删除成功啦");
            }else{
                int i=0/1;
            }
        } catch (Exception e) {

            e.printStackTrace();
            result.setSuccess(false);
            result.setMessage("删除失败");
        }
        return result;
    }


}
