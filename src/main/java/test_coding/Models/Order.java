package test_coding.Models;

import java.util.List;
import java.util.stream.Collectors;

public class Order {
    private Customer customer_name;
    private List<Product> productList;
    private double total_price;
    private int Loyal_point;

    public Order(Customer customer_name, List<Product> product_list,double total_price, int Loyal_point){
        this.customer_name = customer_name;
        this.productList = product_list;
        this.total_price = total_price;
        this.Loyal_point = Loyal_point;
    }

    public double getTotal_price(){ return this.total_price;}

    public int getLoyal_point(){
        return this.Loyal_point;
    }

    public String print_order(){
        StringBuilder sb = new StringBuilder();
        sb.append("Customer: " + customer_name.getName() + "\n");
        sb.append("Bought Product List: " + "\n");
        sb.append(productList.stream().map(pro -> "- " + pro.getName() + ", " + pro.getPrice()).collect(Collectors.joining("\n")));
        sb.append("\nTotal Price: " + total_price);
        sb.append("\nLoyal Point: You can win " + Loyal_point + " points");

        return sb.toString();
    }

}
