package seminars.first.hw;

import seminars.first.model.Calculator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.awt.*;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

public class ShopTest {
    /*
     1. Проверить, что магазин хранит верный список продуктов (количество продуктов, состав корзины)
     2. Проверить, что магазин возвращает верный самый дорого продукт getMostExpensiveProduct
     3. Проверить, что магазин возвращает верный отсортированный по цене список продуктов
    */
    public static void main(String[] args) {
        // Создание списка продуктов
        int RANGE = 15;
        List<Product> productList = new ArrayList<>();
        for (int i = 1; i < RANGE + 1; i++) {
            Product prod = new Product();
            prod.setTitle("Product #" + i);
            int cost = (int) (Math.random() * 999);
            prod.setCost(cost);
            productList.add(prod);
        }

        Shop shop = new Shop();
        shop.setProducts(productList);

        // Сортировка и вывод списка
        shop.sortProductsByPrice();
        for (Product prod : shop.getProducts()) {
            System.out.println(prod.getInfo());
        }

        // Вывод наименования самого дорогого продукта
        System.out.println("Самый дорогой продукт - " + shop.getMostExpensiveProduct().getTitle());

        // Тестирование
        int count = 0;
        int max_price = shop.getMostExpensiveProduct().getCost();
        for (int i = 0; i < RANGE; i++) {
            Product prod = shop.getProducts().get(i);

            // 2. Проверить, что магазин возвращает верный самый дорогой продукт getMostExpensiveProduct
            assertThat(prod.getCost()).isLessThanOrEqualTo(max_price);

            // 3. Проверить, что магазин возвращает верный отсортированный по цене список продуктов
            if (i != 0){
                assertThat(shop.getProducts().get(i - 1).getCost()).isLessThanOrEqualTo(prod.getCost());
            };

            count++;
        }
        // Проверка на верное количество продуктов
        assertThat(shop.getProducts().size()).isEqualTo(count);
    }
}




