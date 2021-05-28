package product;

public class FactoryA implements IFactory {
    @Override
    public IProduct createProduct() {
        IProduct p = new ProductA();
        return p;
    }
}
