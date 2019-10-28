/*
 * Copyright (c) 2017-2019 www.pingtech.com.cn. All rights reserved
 * 注意：本内容仅限于品恩内部传阅，禁止外泄以及用于其他的商业目的
 *
 * 项目名称：zxgk-microservices
 * 文件名称：ResponseVo.java
 * 修改记录：
 * 1.2019年10月10日，PingTech：创建
 */

package cn.com.pingtech.api.entity;

import lombok.Data;

/**
 * @author : psf
 * @Date: 2019/8/30 10:27
 * @Description: 商汤代理服务统一返回值
 */
@Data
public class ResponseVo {
    /**
     * 返回值 编码定义   -1失败   0成功
     */
    private int code;
    /**
     * 返回值  消息定义
     */
    private String message;
    /**
     * 返回值 实体定义
     */
    private Object data;


    public ResponseVo(int code, String message, Object t) {
        this.code = code;
        this.message = message;
        this.data = t;
    }

    public ResponseVo() {
    }

    public static ResponseVo success() {
        ResponseVo responseVo = new ResponseVo();
        responseVo.setCode(0);
        responseVo.setMessage("操作成功");
        return responseVo;
    }

    public static ResponseVo successMsg(String message) {
        ResponseVo responseVo = new ResponseVo();
        responseVo.setCode(0);
        responseVo.setMessage(message);
        return responseVo;
    }

    public static ResponseVo success(String message, Object t) {
        ResponseVo responseVo = new ResponseVo();
        responseVo.setCode(0);
        responseVo.setMessage(message);
        responseVo.setData(t);
        return responseVo;
    }

    public static ResponseVo success(Object t) {
        return ResponseVo.success("操作成功", t);
    }

    public static ResponseVo error() {
        ResponseVo responseVo = new ResponseVo();
        responseVo.setCode(-1);
        responseVo.setMessage("操作失败");
        return responseVo;
    }

    public static ResponseVo error(String message) {
        ResponseVo responseVo = new ResponseVo();
        responseVo.setCode(-1);
        responseVo.setMessage(message);
        return responseVo;
    }
}
