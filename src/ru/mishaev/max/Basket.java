package ru.mishaev.max;

import java.util.Scanner;

public class Basket {
    private String[] products = {"Молоко", "Хлеб", "Гречневая крупа"};
    private int[] prices = {120, 77, 110};
    private int[] quantity = new int[products.length];

    public void addProductQty(String enter) {
        String[] tempArray = enter.split(" ");
        if (tempArray.length == 2) {
            int productNum = Integer.parseInt(tempArray[0]) - 1;
            int productQty = Integer.parseInt(tempArray[1]);
            if (productNum >= 0 && productNum < products.length) {
                quantity[productNum] += productQty;
            } else {
                System.out.println("Такого номера продукта нет в нашем магазине\n");
            }
        } else {
            System.out.println("\nНеверный формат ввода");
        }
    }

    public void printListOfProducts() {
        System.out.println("\nСписок возможных товаров для покупки:");
        for (int index = 0; index < products.length; index++) {
            System.out.printf("%d. %s: %d руб./шт.\n", (index + 1), products[index], prices[index]);
        }
    }

    public void printBasket() {
        System.out.println("\nВаша корзина:");
        int qtyZeroCount = 0;
        for (int index = 0; index < products.length; index++) {
            if (quantity[index] != 0) {
                System.out.printf(
                        "%s %d шт., %d руб./шт., %d руб. в сумме\n",
                        products[index],
                        quantity[index],
                        prices[index],
                        productQuantitySum(index)
                );
            } else {
                qtyZeroCount += 1;
            }
        }
        if (qtyZeroCount == products.length) {
            System.out.println("\nВы ничего не купили. Ваша корзина пуста.");
        } else {
            System.out.printf("\nИтого: %d руб.", basketSum());
        }
    }

    private int productQuantitySum(int index) {
        return prices[index] * quantity[index];
    }

    public int basketSum() {
        int sum = 0;
        for (int idx = 0; idx < prices.length; idx++) {
            sum += productQuantitySum(idx);
        }
        return sum;
    }
}
