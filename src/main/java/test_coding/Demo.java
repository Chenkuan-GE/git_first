package test_coding;

import test_coding.Models.Product;
import test_coding.Models.Order;
import test_coding.Models.Customer;
import test_coding.Models.ShoppingCart;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        Product product1 = new Product(10.0, "DIS_10_PRODUCT1", "product 1");
        Product product2 = new Product(20.0, "DIS_10_PRODUCT2", "product 2");
        Product product4 = new Product(30.0, "DIS_10_PRODUCT1", "product 1");

        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        //products.add(product4);

        Customer customer = new Customer("A Customer");

        ShoppingCart shoppingCart = new ShoppingCart(customer, products);
        // shoppingCart.delProduct(product2);
        Product product3 = new Product(30.0, "DIS_10_PRODUCT3", "product 3");
        shoppingCart.add_products(product3);
        // System.out.println(shoppingCart.toString());

        Order order = shoppingCart.check_out();
        System.out.println(order.print_order());
    }
}
