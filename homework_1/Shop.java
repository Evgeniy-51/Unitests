package seminars.first.hw;

import java.util.List;
import java.util.*;

public class Shop {


    private List<Product> products;

    // Геттеры, сеттеры:
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    /**
     * @return отсортированный по возрастанию и цене список продуктов
     */
    public List<Product> sortProductsByPrice() {
        var list = this.getProducts();
        Collections.sort(list, Comparator.comparing(Product::getCost));

        return list;
    }

    /**
     * @return самый дорогой продукт
     */
    public Product getMostExpensiveProduct() {
        var list = this.getProducts();
        Product mostExp = list.get(0);
        for (Product p: list) {
            if (p.getCost() > mostExp.getCost()){
                mostExp = p;
            }
        }
        return mostExp;
    }
}