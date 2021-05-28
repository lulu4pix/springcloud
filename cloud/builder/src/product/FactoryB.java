package product;

public class FactoryB implements IFactory {
    @Override
    public IProduct createProduct() {
        IProduct p2 = new ProductB();
        return p2;
    }
}
