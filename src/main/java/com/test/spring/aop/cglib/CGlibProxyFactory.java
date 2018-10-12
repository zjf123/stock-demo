package com.test.spring.aop.cglib;

/**
 * TODO 描述
 *
 * @author lei.liu on 2018/9/29.
 */

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGlibProxyFactory implements MethodInterceptor {

    private Object targetObject;

    public Object createProxyInstance(Object targetObject) {
        this.targetObject = targetObject;

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.targetObject.getClass()); //非Final
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy)
            throws Throwable { //--环绕通知
//        TeacherServiceBean teacherServiceBean = (TeacherServiceBean) this.targetObject;
        Object result = null;
//        if (teacherServiceBean.getUser() != null) {
            //---spring中的advice()---前置通知
            try {
                result = methodProxy.invoke(targetObject, args);
                //afterAdivice()-----后置通知
            } catch (Exception e) {
                // exceptionAdivce()---异常通知
            } finally {
                //finallyAdive()----后置通知
            }

//        }

        return result;
    }
}

