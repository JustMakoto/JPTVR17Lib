/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package providers;
import java.util.Scanner;
import entity.Reader;

/**
 *
 * @author pupil
 */
public class ReaderProviders {
private Scanner scanner = new Scanner(System.in);
    public Reader createReader() {
        Reader reader = new Reader();
        System.out.println("-----Создание читателя---------");
        String inputNumber = "";
        Long id = null;
        boolean flag = true;
        do{
        System.out.print("Индефикатор читателя: ");
        inputNumber = scanner.nextLine();
        try {
            id=new Long(inputNumber);
            flag = false;
        }catch(Exception e){
            System.out.println("Ошибка ввода!");
        } 
        }while(flag);
        reader.setId(id);
      
        System.out.print("Имя читателя: ");
        reader.setName(scanner.nextLine());
        System.out.print("Фамилия читателя: ");
        reader.setSurname(scanner.nextLine());
        System.out.print("Телефон читателя: ");
        reader.setPhone(scanner.nextLine());

        return reader;
    }
}
