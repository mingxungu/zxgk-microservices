package cn.com.pingtech.vo;

import lombok.Data;

/**
 * @author PingTech
 * @desc
 * @create 2019-09-06 19:23
 **/
@Data
public class ResultVo<T> {

    public static final String SUCCESS = "0";
    public static final String FAIL = "-1";

    /**
     * 返回状态码: 0成功 -1失败
     */
    private String code;
    /**
     *
     * 操作结果信息
     */
    private String msg;
    /**
     * 返回数据
     */
    private T data;

    /**
     * 失败
     * @return
     */
    public static ResultVo<Object> fail(String msg){
        ResultVo<Object> resultVo = new ResultVo<Object>();
        resultVo.setCode(FAIL);
        resultVo.setMsg(msg);
        return resultVo;
    }

    /**
     * 失败
     * @return
     */
    public static ResultVo<Object> fail(){
        ResultVo<Object> resultVo = new ResultVo<Object>();
        resultVo.setCode(FAIL);
        resultVo.setMsg("请求失败");
        return resultVo;
    }

    /**
     * 成功
     * @param data
     * @return
     */
    public static ResultVo<Object> success(Object data){
        ResultVo<Object> resultVo = new ResultVo<Object>();
        resultVo.setCode(SUCCESS);
        resultVo.setMsg("请求成功");
        resultVo.setData(data);
        return resultVo;
    }
}

