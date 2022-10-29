/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entity.Book;
import entity.History;
import entity.Reader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author pupil
 */
public class DataManager {
    private String FILENAMEBOOK = "files/MyBooks";
    private String FILENAMEREADER = "files/MyReaders";
    private String FILENAMETAKEHISTORY = "files/MyTakeHistory";
    private String FILENAMERETURNHISTORY = "files/MyReturnHistory";
    private File file;
    public DataManager() {
        file = new File("files");
        file.mkdirs();
    }
    
    
    
    public void saveBookToFile(Book[] books) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(FILENAMEBOOK);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(books);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Нет такого файла", ex);
        } catch (IOException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Ошибка ввода / вывода", ex);
        }
    }
    
    public Book[] loadBooksFromFile() {
        Book[] books = new Book[0];
        try {
            FileInputStream fileInputStream = new FileInputStream(FILENAMEBOOK);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            books = (Book[]) objectInputStream.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Нет такого файла", ex);
        } catch (IOException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Ошибка ввода / вывода", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Нет такого класса", ex);
        }
        
        return books;
    }

    public void saveReaderToFile(Reader[] readers) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(FILENAMEREADER);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(readers);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Нет такого файла", ex);
        } catch (IOException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Ошибка ввода / вывода", ex);
        }
    }

    public Reader[] loadReadersFromFile() {
        Reader[] readers = new Reader[0];
        try {
            FileInputStream fileInputStream = new FileInputStream(FILENAMEREADER);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            readers = (Reader[]) objectInputStream.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Нет такого файла", ex);
        } catch (IOException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Ошибка ввода / вывода", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Нет такого класса", ex);
        }
        
        return readers;
    }

    public void saveBookHistory(History[] historyes) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(FILENAMETAKEHISTORY);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(historyes);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Нет такого файла", ex);
        } catch (IOException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Ошибка ввода / вывода", ex);
        }
    }

    public History[] loadHistoryFromFile() {
        History[] historyes = new History[0];
        try {
            FileInputStream fileInputStream = new FileInputStream(FILENAMETAKEHISTORY);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            historyes = (History[]) objectInputStream.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Нет такого файла", ex);
        } catch (IOException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Ошибка ввода / вывода", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "Нет такого класса", ex);
        }
        
        return historyes;
    }

    
}
