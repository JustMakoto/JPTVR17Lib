/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jptvr17shop;

import providers.TakeProductProvider;
import providers.CustomerProviders;
import entity.Product;
import entity.History;
import entity.Customer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import providers.ProductProvider;

/**
 *
 * @author Melnikov
 */
public class App {

    private List<Product> listProducts = new ArrayList<>();
    private List<Customer> listCustomers = new ArrayList<Customer>();
    private List<History> listHistories = new ArrayList<History>();
    private StoregeInFile storegeInFile;

    public App() {

        storegeInFile = new StoregeInFile();

        try {
            listProducts = storegeInFile.loadProductFromFile();
        } catch (Exception e) {
            System.out.println("Нет файла Product.txt");
        }

        try {
            listCustomers = storegeInFile.loadCustomerFromFile();
        } catch (Exception e) {
            System.out.println("Нет файла Customer.txt");
        }

        try {
            listHistories = storegeInFile.loadHistoriesFromFile();
        } catch (Exception e) {
            System.out.println("Нет файла Histories.txt");
        }
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---- Магазин ----");
        String repeat = "r";
        int operation;
        do {
            System.out.println("Выберите действие:");
            System.out.println("1. Создать товар");
            System.out.println("2. Создать покупателя");
            System.out.println("3. Выдать товар покупателю");
            System.out.println("4. Вывести список товаров");
            operation = scanner.nextInt();
            scanner.nextLine();
            switch (operation) {
                case 1:
                    ProductProvider productProvider = new ProductProvider();
                    listProducts.add(productProvider.createProduct());
                    storegeInFile.saveProducts(listProducts);
                    System.out.println(
                                    "Список товаров: ");
                    for (int i = 0; i < listProducts.size(); i++) {
                        System.out.println((i+1)+") "+ listProducts.get(i).getName());
                    }
                    break;
                case 2:
                    CustomerProviders customerProvider = new CustomerProviders();

                    System.out.println(
                                "Создан покупатель: "
                                + customerProvider.toString()
                    );
                    listCustomers.add(customerProvider.createCustomer());
                    storegeInFile.saveCustomers(listCustomers);
                    for (int i = 0; i < listCustomers.size(); i++) {
                        System.out.println(
                                    "Создан покупатель: " + listCustomers.get(i).getName());
                    }
                    break;
                case 3:
                    TakeProductProvider takeProductProvider = new TakeProductProvider();
                    listHistories.add(takeProductProvider.takeProduct(listProducts, listCustomers));

                    storegeInFile.saveHistory(listHistories);
                    break;
                case 4:
                    System.out.println("Список товаров: ");
                    for (int i = 0; i < listProducts.size(); i++) {
                        System.out.println(listProducts.get(i));
                    }
                    break;
                default:
                    System.out.println("Такое действие неподдерживается");
                    continue;
            }
            System.out.println("Для продолжения программы");
            System.out.println("введите \"r\"");
            System.out.println("Для окончания \"q\"");
            repeat = scanner.nextLine();
        } while ("r".equals(repeat));
        System.out.println("Программа закрывается");
    }

}
