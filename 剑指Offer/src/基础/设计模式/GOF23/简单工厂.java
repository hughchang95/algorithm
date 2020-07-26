package 基础.设计模式.GOF23;

public class 简单工厂 {
}

interface Product {
}

class CreateProduct1 implements Product {
}

class CreateProduct2 implements Product {
}

class DefaultProduct implements Product {
}

//简单工厂：在创建一个对象时不向客户暴露内部细节，并提供一个创建对象的通用接口。
//把实例化的操作单独放到一个类中，这个类就成为简单工厂类；
//让简单工厂类来决定应该用哪个具体子类来实例化。
class SimpleFactory {
    public Product createProduct(int type) {
        if (type == 1)
            return new CreateProduct1();
        else if (type == 2)
            return new CreateProduct2();
        else
            return new DefaultProduct();
    }
}

class Client {
    public static void main(String[] args) {
        SimpleFactory simpleFactory = new SimpleFactory();
        Product product = simpleFactory.createProduct(1);
        //使用product
    }
}