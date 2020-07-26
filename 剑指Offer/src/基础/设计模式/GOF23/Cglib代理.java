package 基础.设计模式.GOF23;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class Cglib代理 {
    public static void main(String[] args) {
        //创建增强器
        Enhancer enhancer=new Enhancer();

        enhancer.setSuperclass(Cat.class);

        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("before");
                methodProxy.invokeSuper(o,objects);
                return null;
            }
        });

        Cat handlerCat = (Cat) enhancer.create();
        handlerCat.run();
    }


}

class Cat{
    void run(){
        System.out.println("cat run...");
    }
}
