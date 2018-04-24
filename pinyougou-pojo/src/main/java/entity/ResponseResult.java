package entity;

import com.pinyougou.pojo.TbBrand;

import java.io.Serializable;

/**
 * @author steven
 * @version 1.0
 * @description entity
 * @date 2018/4/23
 */
public class ResponseResult implements Serializable{
    private  Integer pageNum,pageSize;

    private TbBrand drand;

    public TbBrand getDrand() {
        return drand;
    }

    public void setDrand(TbBrand drand) {
        this.drand = drand;
    }

    public ResponseResult(Integer pageNum, Integer pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    } public ResponseResult() {
    }



    @Override
    public String toString() {
        return "ResponseResult{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", drand=" + drand +
                '}';
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
