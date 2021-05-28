package builder;

public class ConcreteBuilder implements IBuilder {
    Product p = new Product();
    @Override
    public Product getProduct() {
        return p;
    }

    @Override
    public void setPart(String name, String type) {
        p.setName(name);
        p.setType(type);
    }
}
