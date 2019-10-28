package cn.com.pingtech.vo;

import lombok.Data;

/**
 * @author PingTech
 * @desc
 * @create 2019-08-30 14:22
 **/
@Data
public class SearchVehicleVo {

    /**
     * 页码数，从1开始
     */
    private int pageNo;
    /**
     * 每页返回的条数，从1开始，最大值200
     */
    private int pageSize;
    /**
     * 开始时间。格式为：yyyy-MM-dd HH:mm:ss
     */
    private String startTime;
    /**
     * 结束时间。格式为：yyyy-MM-dd HH:mm:ss
     */
    private String endTime;
    /**
     * 卡口ID。支持多条件，以”,”分隔，最多支持500个卡口
     */
    private String crossingIds;
}

