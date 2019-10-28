package cn.com.pingtech.user.vo;

/**
 * @author gumx
 * @className: JsonResult
 * @description: 公共返回对象
 * @date 2019/9/2 13:45
 */
public class JsonResult {

    private Object result;
    private String status;

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
