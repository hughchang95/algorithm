package 基础.设计模式.GOF23;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class 动态代理 {
    public static void main(String[] args) {
        //参数：代理目标的类加载器，代理目标实现的接口，实现InvocationHandler的代理类
        Dog dog= (Dog) Proxy.newProxyInstance(Teddy.class.getClassLoader(),Teddy.class.getInterfaces(),new MasterHandler(new Teddy()));
        dog.run();
    }
}

//目标接口
interface Dog{
    void run();
}

//目标类
class Teddy implements Dog{
    @Override
    public void run() {
        System.out.println("Teddy tun...");
    }
}

//代理类
class MasterHandler implements InvocationHandler{
    //传入代理对象
    private Object target;
    MasterHandler(Object target){
        this.target=target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Master Command...");
        method.invoke(target,args);
        return null;
    }
}
