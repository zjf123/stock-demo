package com.test.spring.aop.jdk;

/**
 * TODO 描述
 *
 * @author lei.liu on 2018/9/29.
 */
public interface StudentService {
    public String getUser() throws Exception;
    public void save(String name) throws Exception;
    public void update(String name) throws Exception;
}
