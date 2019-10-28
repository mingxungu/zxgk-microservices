package cn.com.pingtech.vo;

import lombok.Data;

/**
 * @author PingTech
 * @desc
 * @create 2019-08-30 14:21
 **/
@Data
public class ReceiveVehicleVo {

    /**
     * 过车时间。格式为yyyy-MM-dd HH:mm:ss.SSS
     */
    private String pass_time;
    /**
     * 卡口编号或id
     */
    private String crossing_id;
    /**
     * 车牌号码
     */
    private String plate_no;
    /**
     * 车辆图片路径。可正常访问的图片地址
     */
    private String vehiclepicurl;
}

