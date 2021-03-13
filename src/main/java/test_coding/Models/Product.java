package test_coding.Models;

public class Product {
    private final double price;
    private final String product_code;
    private final String product_name;

    public Product(double price, String productcode, String product_name){
        this.price = price;
        this.product_code = productcode;
        this.product_name = product_name;
    }

    public double getPrice() {
        return price;
    }

    public String getProductCode() {
        return product_code;
    }

    public String getName() {
        return product_name;
    }
}
