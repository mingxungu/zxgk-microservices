package cn.com.pingtech.senseFace.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Auther: psf
 * @Date: 2019/10/17 10:48
 * @Description: 静态人脸比对服务请求参数
 */

@ApiModel(value = "Person", description = "人脸识别请求参数")

public class RequestPerson {

    @ApiModelProperty(value = "人员照片base64", required = true)
    private String base64Image;
    @ApiModelProperty(value = "静态库类型", required = true)
    private String dbType;

    public String getBase64Image() {
        return base64Image;
    }

    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }

    public String getDbType() {
        return dbType;
    }

    public void setDbType(String dbType) {
        this.dbType = dbType;
    }
}
