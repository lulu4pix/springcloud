package builder;

public class Director {
    public Product getProductA() {
        ConcreteBuilder c1 = new ConcreteBuilder();
        c1.setPart("a", "typeA");
        Product product = c1.getProduct();
        return product;
    }

    public Product getProductB() {
        ConcreteBuilder c2 = new ConcreteBuilder();
        c2.setPart("b", "typeB");
        Product product = c2.getProduct();
        return product;
    }
}
