package cn.com.pingtech.vo;

import lombok.Data;

/**
 * @author PingTech
 * @desc
 * @create 2019-09-07 17:32
 **/
@Data
public class PassVehicleVo {
    /**
     * 车辆品牌
     */
    private String autoBrand;
    /**
     * 过车时间。格式为：yyyy-MM-dd HH:mm:ss
     */
    private String passTimeStr;
    /**
     * 车辆图片路径
     */
    private String picAbbreviate;
    /**
     * 车牌颜色
     */
    private String plateColor;
    /**
     * 车牌号码
     */
    private String plateInfo;
    /**
     * 车牌类型
     */
    private String plateType;
    /**
     * 车辆颜色
     */
    private String vehicleColor;
    /**
     * 车头方向。0未知 1正向 2背向
     */
    private String vehicleHead;
    /**
     * 车辆速度
     */
    private String vehicleSpeed;
    /**
     * 车辆子品牌
     */
    private String vehicleSublogo;
    /**
     * 车辆类型
     */
    private String vehicleType;
}

