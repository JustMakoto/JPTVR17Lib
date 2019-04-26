/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package providers;

import entity.Product;
import entity.History;
import entity.Customer;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author pupil
 */
public class TakeProductProvider {
    Scanner scanner = new Scanner(System.in);
    public History takeProduct(List<Product> listProducts, List<Customer> listCustomers){
        History history = new History();
        System.out.println("'n-------Выдать товар покупателю-------");
        System.out.println("\nСписок Покупателей: ");
        
        for(int i=0; i<listCustomers.size();i++){
            System.out.printf("%d. %s %s%n",i+1, listCustomers.get(i).getName(), listCustomers.get(i).getSurname());
        }
        System.out.println("\nСписок Товаров: ");
        for(int i=0; i<listCustomers.size();i++){
            System.out.printf("%d. %s %s Euro%n",i+1, listProducts.get(i).getName(), listProducts.get(i).getPrice());
        }
        System.out.print("\nВыберите номер покупателя: ");
        String numberCustomer = scanner.nextLine();
        System.out.print("Выберите номер товара: ");
        String numberProduct = scanner.nextLine();
        System.out.print("\n");
        Customer customer = listCustomers.get(new Integer(numberCustomer)-1);
        Product product = listProducts.get(new Integer(numberProduct)-1);
        history.setCustomer(customer);
        history.setProduct(product);
        Calendar c = new GregorianCalendar();
        history.setTakeBook(c.getTime());
        return history;
    }
    
}
