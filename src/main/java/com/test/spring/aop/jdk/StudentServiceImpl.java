package com.test.spring.aop.jdk;

/**
 * TODO 描述
 *
 * @author lei.liu on 2018/9/29.
 */

public class StudentServiceImpl implements StudentService {

    private String user;

    @Override
    public String getUser() {
        return user;
    }

    public StudentServiceImpl() {
    }

    public StudentServiceImpl(String user) {
        this.user = user;
    }

    @Override
    public void save(String name) throws Exception {
        System.out.println(this.user + ",do save()==>" + name);
    }

    @Override
    public void update(String name) {
        System.err.println("update()==>" + name);
    }


}
