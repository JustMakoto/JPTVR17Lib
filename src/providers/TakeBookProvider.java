/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package providers;

import entity.Book;
import entity.History;
import entity.Reader;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author pupil
 */
public class TakeBookProvider {
    Scanner scanner = new Scanner(System.in);
    public History takeBook(List<Book> listBooks, List<Reader> listReaders){
        History history = new History();
        System.out.println("'n-------Выдать книгу читателю-------");
        System.out.println("\nСписок читателей: ");
        
        for(int i=0; i<listReaders.size();i++){
            System.out.printf("%d. %s %s%n",i+1, listReaders.get(i).getName(), listReaders.get(i).getSurname());
        }
        System.out.println("\nСписок Книг: ");
        for(int i=0; i<listReaders.size();i++){
            System.out.printf("%d. %s %s%n",i+1, listBooks.get(i).getName(), listBooks.get(i).getAuthor());
        }
        System.out.print("\nВыберите номер читателя: ");
        String numberReader = scanner.nextLine();
        System.out.print("\nВыберите номер книги: ");
        String numberBook = scanner.nextLine();
        Reader reader = listReaders.get(new Integer(numberReader)-1);
        Book book = listBooks.get(new Integer(numberBook)-1);
        history.setReader(reader);
        history.setBook(book);
        Calendar c = new GregorianCalendar();
        history.setTakeBook(c.getTime());
        return history;
    }
    
}
