/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jptvr17library;

import entity.Book;
import entity.Reader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Melnikov
 */
public class StoregeInFile {

    void saveBooks(List<Book> listBooks) {
        
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("Books.txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(listBooks);
            oos.flush();
            oos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(StoregeInFile.class.getName())
               .log(Level.SEVERE, "Нет такого файла", ex);
        } catch (IOException ex) {
            Logger.getLogger(StoregeInFile.class.getName())
               .log(Level.SEVERE, "Не могу записать", ex);
        }
       
    }

    List<Book> loadBookFromFile() {
            List<Book> books = new ArrayList<>();
            FileInputStream fis = null;
            ObjectInputStream oin = null;
         try {   
            fis = new FileInputStream("Books.txt");
            oin = new ObjectInputStream(fis);
            books = (List<Book>) oin.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(StoregeInFile.class.getName())
                .log(Level.SEVERE, "Нет такого файла", ex);
        } catch (IOException ex) {
            Logger.getLogger(StoregeInFile.class.getName())
                .log(Level.SEVERE, "Не могу читать из файла", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StoregeInFile.class.getName())
                .log(Level.SEVERE, "Нет такого класса", ex);
        }
        return books;
    }

    List<Reader> loadReaderFromFile() {
             List<Reader> readers = new ArrayList<>();
            FileInputStream fis = null;
            ObjectInputStream oin = null;
         try {   
            fis = new FileInputStream("Readers.txt");
            oin = new ObjectInputStream(fis);
            readers = (List<Reader>) oin.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(StoregeInFile.class.getName())
                .log(Level.SEVERE, "Нет такого файла", ex);
        } catch (IOException ex) {
            Logger.getLogger(StoregeInFile.class.getName())
                .log(Level.SEVERE, "Не могу читать из файла", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StoregeInFile.class.getName())
                .log(Level.SEVERE, "Нет такого класса", ex);
        }
        return readers;
    }

    void saveReaders(List<Reader> listReaders) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("Readers.txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(listReaders);
            oos.flush();
            oos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(StoregeInFile.class.getName())
               .log(Level.SEVERE, "Нет такого файла", ex);
        } catch (IOException ex) {
            Logger.getLogger(StoregeInFile.class.getName())
               .log(Level.SEVERE, "Не могу записать", ex);
        }
    }
    
}
