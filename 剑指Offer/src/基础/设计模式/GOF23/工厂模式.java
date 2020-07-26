package 基础.设计模式.GOF23;

public class 工厂模式 {
}

//抽奖产品
//interface Product {}

//具体产品
class ConcreteProduct implements Product {
}

class ConcreteProduct2 implements Product {
}

class ConcreteProduct3 implements Product {
}

//工厂方法：定义了一个创建对象的接口，但由子类决定要实例化哪个类。工厂方法把实例化操作推迟到子类。
//抽象工厂
abstract class Factory {
    abstract public Product factoryMethod();

    public void doSomething() {
        //使用Product对象
    }
}

//具体工厂
class ConcreteFactory extends Factory {
    public Product factoryMethod() {
        return new ConcreteProduct();
    }
}

class ConcreteFactory2 extends Factory {
    public Product factoryMethod() {
        return new ConcreteProduct2();
    }
}

class ConcreteFactory3 extends Factory {
    public Product factoryMethod() {
        return new ConcreteProduct3();
    }
}

class ConcreteClient{
    public static void main(String[] args) {
        Factory factory=new ConcreteFactory();
        factory.factoryMethod();
        factory.doSomething();
    }
}