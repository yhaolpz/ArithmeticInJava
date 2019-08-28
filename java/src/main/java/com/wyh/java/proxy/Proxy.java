package com.wyh.java.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author WangYingHao
 * @since 2019-08-27
 */
public class Proxy {

    interface Action {
        void eat();
    }


    static class ActionImpl implements Action {
        @Override
        public void eat() {
            System.out.println("吃吃吃");
        }
    }


    public static void test() {
        final Action action = new ActionImpl();
        java.lang.reflect.Proxy.newProxyInstance(action.getClass().getClassLoader(),
                Action.class.getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                        method.invoke(action);
                        System.out.println("胖胖胖");
                        return null;
                    }
                });
        action.eat();
    }


}
