/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package providers;

import entity.Product;
import java.util.Scanner;

/**
 *
 * @author Melnikov
 */
public class ProductProvider {
    private Scanner scanner = new Scanner(System.in);
    public Product createProduct() {
        Product product = new Product();
        System.out.println("-------Создание продукта--------");
        String inputNumber = "";
        Long id = null;
        boolean flag = true;
        do{
           System.out.print("Идентификатор продукта: ");
           inputNumber = scanner.nextLine();
           try {
              id=new Long(inputNumber);
              flag = false;
           }catch (Exception e){
               System.out.println("Ошибка ввода!");
           }
        }while(flag);
        product.setId(id);
        System.out.print("Название товара: ");
        product.setName(scanner.nextLine());
        
        int inputPrice = 0;
        int price = 0;
        boolean flagPrice = true;
        do{
           System.out.print("Цена товара: ");
           inputPrice = scanner.nextInt();
           try {
              price=inputPrice;
              flagPrice = false;
           }catch (Exception e){
               System.out.println("Ошибка ввода!");
           }
        }while(flagPrice);
        product.setPrice(price);
        return product;
}


}
