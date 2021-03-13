package test_coding.Models;

import java.util.List;
import java.util.stream.Collectors;

public class ShoppingCart {
    private List<Product> product_list;
    private Customer customer;

    public ShoppingCart(Customer customer_name, List<Product> product_list){
        this.customer = customer_name;
        this.product_list = product_list;
    }

    public void add_products(Product product){
        this.product_list.add(product);
    }

    public void delProduct(Product product) {
        for (Product exist_product: product_list){
            if (product.equals(exist_product)){
                product_list.remove(product);
                break;
            }
        }
    }

    public Order check_out(){
        double totalPrice = 0;

        int loyaltyPointsEarned = 0;
        for (Product product : product_list) {
            double discount = 0;
            int discount_type = 0;
            if (product.getProductCode().startsWith("DIS_10")){
                discount_type = 1;
            }
            else if (product.getProductCode().startsWith("DIS_15")){
                discount_type = 2;
            }

            switch (discount_type){
                case 1:
                    discount = (product.getPrice() * 0.1);
                    loyaltyPointsEarned += (product.getPrice() / 10);
                    break;
                case 2:
                    discount = (product.getPrice() * 0.15);
                    loyaltyPointsEarned += (product.getPrice() / 15);
                    break;
                default:
                    loyaltyPointsEarned += (product.getPrice() / 5);
                    break;
            }

            totalPrice += product.getPrice() - discount;
        }

        return new Order(customer, product_list, totalPrice, loyaltyPointsEarned);
    }


    @Override
    public String toString() {
        return "Customer: " + customer.getName() + "\n" + "Bought:  \n" + product_list.stream().map(p -> "- " + p.getName()+ ", "+p.getPrice()).collect(Collectors.joining("\n"));
    }


}
