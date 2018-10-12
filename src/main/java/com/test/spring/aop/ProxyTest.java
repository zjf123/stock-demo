package com.test.spring.aop;

import com.test.spring.aop.cglib.CGlibProxyFactory;
import com.test.spring.aop.cglib.TeacherServiceBean;
import com.test.spring.aop.jdk.JDKProxyFactory;
import com.test.spring.aop.jdk.StudentService;
import com.test.spring.aop.jdk.StudentServiceImpl;

/**
 * TODO 描述
 *
 * @author lei.liu on 2018/9/29.
 */
public class ProxyTest {
//    public static void main(String[] args) {
////        proxyTest();
//        cglibProxyTest();
//    }

    public static void proxyTest() {
        JDKProxyFactory factory = new JDKProxyFactory();
        StudentService studentService = (StudentService) factory.createProxyInstance(new StudentServiceImpl("zzz"));
        try {

            if (studentService.getUser() != null && !"".equals(studentService.getUser())) {
                studentService.save("dddd");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }

    public static void cglibProxyTest() {
        CGlibProxyFactory factory = new CGlibProxyFactory();
        TeacherServiceBean bean = (TeacherServiceBean) factory.createProxyInstance(new TeacherServiceBean());
        try {
            bean.save();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //
        }
    }
}
