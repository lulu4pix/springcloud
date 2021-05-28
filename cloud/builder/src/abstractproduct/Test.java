package abstractproduct;

public class Test {
    public static void main(String[] args) {
        IFactory f = new Factory();
        //一个工厂能创建两种产品
        IProduct1 p1 = f.createProduct1();
        IProduct2 p2 = f.createProduct2();
        p1.show();
        p2.show();
    }
}
