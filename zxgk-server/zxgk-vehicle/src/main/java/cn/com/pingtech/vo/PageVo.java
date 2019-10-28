package cn.com.pingtech.vo;

import lombok.Data;

import java.util.List;

/**
 * @author PingTech
 * @desc
 * @create 2019-09-06 19:56
 **/
@Data
public class PageVo<T> {

    /**
     * 页码
     */
    private int pageNo;
    /**
     * 每页数量
     */
    private int pageSize;
    /**
     * 总数
     */
    private int total;
    /**
     * 结果列表
     */
    private List<T> list;
}

