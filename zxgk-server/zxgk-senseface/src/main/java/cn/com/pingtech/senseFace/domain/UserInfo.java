package cn.com.pingtech.senseFace.domain;

import java.io.Serializable;

/**
 * @Auther: psf
 * @Date: 2019/9/3 16:19
 * @Description: 静态人脸比中服务返回的人员信息
 */
public class UserInfo implements Serializable {
    private static final long serialVersionUID = -4804651685619718476L;

    private String  key;//核查比对接口返回的key（人脸核查返回的是身份证，人脸登录返回的是警号）
    private String  extraInfo;
    private String  id_number;//身份证号
    private String  name;//姓名
    private String  sex;//性别
    private String  nation;//民族
    private String  birthday;//生日
    private String  address;//地址
    private String  certificate_image;//身份证证件照

    public String getId_number() {
        return id_number;
    }

    public void setId_number(String id_number) {
        this.id_number = id_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCertificate_image() {
        return certificate_image;
    }

    public void setCertificate_image(String certificate_image) {
        this.certificate_image = certificate_image;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id_number='" + id_number + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", nation='" + nation + '\'' +
                ", birthday='" + birthday + '\'' +
                ", address='" + address + '\'' +
                ", certificate_image='" + certificate_image + '\'' +
                '}';
    }
}
