package builder;

public class Test {
    public static void main(String[] args) {
        Director d = new Director();
        Product productA = d.getProductA();
        Product productB = d.getProductB();

        productA.show();
        productB.show();
    }
}
