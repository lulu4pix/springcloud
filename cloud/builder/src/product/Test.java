package product;

public class Test {
    public static void main(String[] args) {
        //这里只是自己创建工厂A, 工厂B。对于工厂模式，写其中一个就可以。
        IFactory factoryA = new FactoryA();
        IProduct p1 = factoryA.createProduct();

        IFactory factoryB = new FactoryB();
        IProduct p2 = factoryB.createProduct();

        p1.show();
        p2.show();
    }
}
