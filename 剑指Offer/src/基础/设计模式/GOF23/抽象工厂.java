package 基础.设计模式.GOF23;

public class 抽象工厂 {
}

//抽象产品
//interface Product{}
//具体产品
class AbstractProduct1 implements Product {
}

class AbstractProduct2 implements Product {
}

//抽象工厂
interface AFactory {
    AbstractProduct1 getProduct1();

    AbstractProduct2 getProduct2();
}

//具体工厂
class AbstractFactory1 implements AFactory {
    @Override
    public AbstractProduct1 getProduct1() {
        System.out.println("f1 p1");
        return new AbstractProduct1();
    }

    @Override
    public AbstractProduct2 getProduct2() {
        System.out.println("f1 p2");
        return new AbstractProduct2();
    }
}

class AbstractFactory2 implements AFactory {
    @Override
    public AbstractProduct1 getProduct1() {
        System.out.println("f2 p1");
        return new AbstractProduct1();
    }

    @Override
    public AbstractProduct2 getProduct2() {
        System.out.println("f2 p2");
        return new AbstractProduct2();
    }
}

class AbstractClient {
    public static void main(String[] args) {
        AFactory factory1 = new AbstractFactory1();
        AFactory factory2 = new AbstractFactory2();
        factory1.getProduct1();
        factory1.getProduct2();
        factory2.getProduct1();
        factory2.getProduct2();
    }
}
