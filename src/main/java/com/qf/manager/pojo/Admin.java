package com.qf.manager.pojo;

/**
 * Create by it_mck 2018/10/21 12:58
 *
 * @Description:
 * @Version: 1.0
 */
public class Admin {

    private String uname;
    private String upwd;

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

    @Override
    public String toString() {
        return "Admin{" +
                "uname='" + uname + '\'' +
                ", upwd='" + upwd + '\'' +
                '}';
    }
}
