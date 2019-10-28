package cn.com.pingtech.user.entity;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author gumx
 * @className: User
 * @description: 用户实体类
 * @date 2019/9/2 13:44
 */
public class User {
    @ApiModelProperty(notes="用户名")
    private String username;
    @ApiModelProperty(notes="年龄")
    private String age;
    @ApiModelProperty(notes="用户ID")
    private Integer id;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
