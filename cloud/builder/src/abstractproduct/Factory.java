package abstractproduct;

import product.IProduct;

public class Factory implements IFactory {
    @Override
    public IProduct1 createProduct1() {
        IProduct1 p = new Product1ImplA();
        return p;
    }

    @Override
    public IProduct2 createProduct2() {
        IProduct2 p = new Product2ImplA();
        return p;
    }
}
