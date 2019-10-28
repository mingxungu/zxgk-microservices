package cn.com.pingtech.senseFace.pojo;

/**
 * @Auther: psf
 * @Date: 2019/9/2 13:23
 * @Description:
 */
public class Image1 {
    private String format;
    private String data;

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Image1(String format, String data) {
        this.format = format;
        this.data = data;
    }

    public Image1() {
    }
}
