package builder;

/**
 * 为了简洁这里的产品没有用接口，这里可以像上面一样用接口
 */
public class Product {
    private String name;
    private String type;

    public void show() {
        System.out.println(name + " " + type);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }
}
