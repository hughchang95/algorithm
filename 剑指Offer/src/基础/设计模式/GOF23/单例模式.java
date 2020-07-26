package 基础.设计模式.GOF23;

public class 单例模式 {
}

//饿汉式：类初始化时实例化，调用时返回对象，线程安全，但失去了延迟加载的优势
class Singleton_Hungry {
    private static Singleton_Hungry instance = new Singleton_Hungry();

    private Singleton_Hungry() {
    }

    public static Singleton_Hungry getInstance() {
        return instance;
    }
}

//懒汉式：调用方法时实例化对象，线程不安全
class Singleton_Lazy {
    private static Singleton_Lazy instance;

    private Singleton_Lazy() {
    }

    public static Singleton_Lazy getInstance() {
        if (instance == null)
            instance = new Singleton_Lazy();
        return instance;
    }
}

//懒汉式：线程安全版本
class Singleton_SafeLazy {
    private static Singleton_SafeLazy instance;

    private Singleton_SafeLazy() {
    }

    public synchronized static Singleton_SafeLazy getInstance() {
        if (instance == null)
            instance = new Singleton_SafeLazy();
        return instance;
    }

}

//双重检查锁
class Singleton_DoubleCheck {
    //加入volatile关键字防止指令重排序
    private static volatile Singleton_DoubleCheck instance;

    private Singleton_DoubleCheck() {
    }

    public static Singleton_DoubleCheck getInstance() {
        if (instance == null) {
            synchronized (Singleton_DoubleCheck.class) {
                if (instance == null) {
                    //这一步分三步：分配空间，创建对象，指向引用
                    instance = new Singleton_DoubleCheck();
                }
            }
        }
        return instance;
    }
}

//静态内部类实现
class Singleton_Static {
    private Singleton_Static() {
    }

    //静态内部类只在被调用时加载一次
    private static class UniqueInstance {
        private static final Singleton_Static INSTANCE = new Singleton_Static();
    }

    public Singleton_Static getInstance(){
        return UniqueInstance.INSTANCE;
    }
}

//枚举实现：枚举对象由JVM保证只实例化一次，可以防止反射攻击
enum Singleton_Enum{
    INSTANCE;
}


