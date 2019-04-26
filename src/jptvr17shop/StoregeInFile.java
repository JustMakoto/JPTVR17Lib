/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jptvr17shop;

import entity.Product;
import entity.History;
import entity.Customer;
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

    void saveProducts(List<Product> listProducts) {
        
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("Product.txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(listProducts);
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

    List<Product> loadProductFromFile() {
            List<Product> products = new ArrayList<>();
            FileInputStream fis = null;
            ObjectInputStream oin = null;
         try {   
            fis = new FileInputStream("Product.txt");
            oin = new ObjectInputStream(fis);
            products = (List<Product>) oin.readObject();
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
        return products;
    }

    List<Customer> loadCustomerFromFile() {
             List<Customer> customers = new ArrayList<>();
            FileInputStream fis = null;
            ObjectInputStream oin = null;
         try {   
            fis = new FileInputStream("Customer.txt");
            oin = new ObjectInputStream(fis);
            customers = (List<Customer>) oin.readObject();
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
        return customers;
    }

    void saveCustomers(List<Customer> listCustomers) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("Customer.txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(listCustomers);
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
    
    
        List<History> loadHistoriesFromFile() {
             List<History> customers = new ArrayList<>();
            FileInputStream fis = null;
            ObjectInputStream oin = null;
         try {   
            fis = new FileInputStream("Histories.txt");
            oin = new ObjectInputStream(fis);
            customers = (List<History>) oin.readObject();
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
        return customers;
    }

    void saveHistory(List<History> listHistories) {
                FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("Histories.txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(listHistories);
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
