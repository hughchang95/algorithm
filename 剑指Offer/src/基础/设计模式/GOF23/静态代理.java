package 基础.设计模式.GOF23;

public class 静态代理 {
    public static void main(String[] args) {
        Studio singer=new Singer();
        Manager manager=new Manager(singer);
        manager.sing();
    }
}

//目标接口
interface Studio {
    void sing();
}

//目标类
class Singer implements Studio {
    @Override
    public void sing() {
        System.out.println("Singer sing...");
    }
}

//代理类
class Manager implements Studio{
    //持有目标对象
    Studio singer;

    //传入对象
    Manager(Studio singer) {
        this.singer = singer;
    }

    //扩展
    public void sing() {
        System.out.println("Manager Prepare");
        singer.sing();
        System.out.println("AfterSing");
    }
}