package com.test.spring.aop.jdk;

/**
 * TODO 描述
 *
 * @author lei.liu on 2018/9/29.
 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/**
 * 代理详解：https://www.cnblogs.com/LCcnblogs/p/6823982.html
 */
public class JDKProxyFactory implements InvocationHandler {
    private Object targetObject;

    public JDKProxyFactory() {
    }


    public Object createProxyInstance(Object targetObject) {
        this.targetObject = targetObject;
        return Proxy.newProxyInstance(
                this.targetObject.getClass().getClassLoader(),  //类加载器
                this.targetObject.getClass().getInterfaces(),    //类中的所有接口
                this); //当前对象   此处较为重要  通过此处回调 invoke函数
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable { //--环绕通知

//        StudentService bean = (StudentService) this.targetObject;
        Object result = null;
//        if (bean.getUser() != null) {
            //---spring中的advice()---前置通知
            try {
                result = method.invoke(targetObject, args);
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

