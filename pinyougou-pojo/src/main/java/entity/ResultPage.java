package entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author steven
 * @version 1.0
 * @description entity
 * @date 2018/4/23
 */
public class ResultPage implements Serializable {
    private long total;
    private List rows;

    @Override
    public String toString() {
        return "ResultPage{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }

    public ResultPage() {
    }

    public ResultPage(long total, List rows) {

        this.total = total;
        this.rows = rows;
    }
}
