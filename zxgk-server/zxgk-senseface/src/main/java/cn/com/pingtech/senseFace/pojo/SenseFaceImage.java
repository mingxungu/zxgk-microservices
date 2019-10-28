package cn.com.pingtech.senseFace.pojo;

import java.util.List;

/**
 * @Auther: psf
 * @Date: 2019/9/2 11:34
 * @Description: 1:N 人脸比对接口请求参数
 */
public class SenseFaceImage  {
    private Image image;
    private List<DB> dbs;
    private String type;

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public List<DB> getDbs() {
        return dbs;
    }

    public void setDbs(List<DB> dbs) {
        this.dbs = dbs;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }





}
