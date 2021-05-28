package builder;

public interface IBuilder {
    public Product getProduct();
    public void setPart(String name, String type);
}
