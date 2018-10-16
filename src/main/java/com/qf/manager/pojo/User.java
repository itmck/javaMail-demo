package com.qf.manager.pojo;

/**
 * Create by it_mck 2018/10/14 1:42
 *
 * @Description:
 * @Version: 1.0
 */
public class User {

    private Long id;

    private String uname;//用户名

    private String upwd;//密码

    private Integer state;//在数据库中对应的状态 0--未激活 1--已经激活

    private String code;//验证码

    private String email;//邮箱

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
