package abstractproduct;

/**
 * 注意这里与工厂方法不同， 这里是一个工厂创建一族类似的产品。而工厂方法一个工厂只创建一个产品
 */
public interface IFactory {
    public IProduct1 createProduct1();
    public IProduct2 createProduct2();
}
