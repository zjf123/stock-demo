package com.test.spring.aop.cglib;

/**
 * TODO 描述
 *
 * @author lei.liu on 2018/9/29.
 */
public class TeacherServiceBean {

    private String user;
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void save() throws Exception{
        System.out.println(this.getClass().getName() + "====>save()");
    }
}
