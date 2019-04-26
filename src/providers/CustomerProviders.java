/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package providers;
import java.util.Scanner;
import entity.Customer;

/**
 *
 * @author pupil
 */
public class CustomerProviders {
private Scanner scanner = new Scanner(System.in);
    public Customer createCustomer() {
        Customer customer = new Customer();
        System.out.println("-----Создание покупателя---------");
        String inputNumber = "";
        Long id = null;
        boolean flag = true;
        do{
        System.out.print("Индефикатор покупателя: ");
        inputNumber = scanner.nextLine();
        try {
            id=new Long(inputNumber);
            flag = false;
        }catch(Exception e){
            System.out.println("Ошибка ввода!");
        } 
        }while(flag);
        customer.setId(id);
      
        System.out.print("Имя покупателя: ");
        customer.setName(scanner.nextLine());
        System.out.print("Фамилия покупателя: ");
        customer.setSurname(scanner.nextLine());
        System.out.print("Телефон покупателя: ");
        customer.setPhone(scanner.nextLine());

        return customer;
    }
}
