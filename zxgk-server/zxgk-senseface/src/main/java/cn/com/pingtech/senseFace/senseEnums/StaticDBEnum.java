package cn.com.pingtech.senseFace.senseEnums;

/**
 * @Auther: psf
 * @Date: 2019/9/6 10:49
 * @Description:商汤人脸 静态库枚举类
 */
public enum StaticDBEnum {
    LOGIN("人员核查库", "db_id_check"), CHECK("民警登录库", "db_id_login");

    String name;
    String value;

    StaticDBEnum(String name, String value) {
        this.value = value;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
