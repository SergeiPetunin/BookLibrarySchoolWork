/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entity.Book;
import entity.History;
import entity.Reader;
import java.util.Scanner;

/**
 *
 * @author pupil
 */
public class HistoryManager {
    private ReaderManager rm;
    private BookManager bm;
    private final Scanner scanner;
    
    public HistoryManager() {
        scanner = new Scanner(System.in);
        rm = new ReaderManager();
        bm = new BookManager();
    }
    
    public History takeOnBook(Reader[] readers, Book[] books) {
        //из списка читателей выбрать номер читателя
        //из списка книг выбрать номер книги
        //инициировать поля History
        //добавить дату выдачи книги
        System.out.println("Список читателей");
        rm.printListReaders(readers);
        System.out.println("Выберете номер читателя из списка");
        int numberReader = scanner.nextInt(); scanner.nextLine();
        
        System.out.println("Список книг");
        bm.printListBooks(books);
        System.out.println("Выберете номер книги из списка");
        int numberBook = scanner.nextInt(); scanner.nextLine();
        
        History history = new History();
        history.setBook(books[numberBook - 1]);
        history.setReader(reader[numberReader - 1]);
        history.set(reader[numberReader - 1]);
    }
    
    
    public void printListHistoryes(Reader[] readers) {
        for(int i  = 0; i < readers.length; i++) {
                        System.out.printf("%d. %s %s %s%n"
                                ,i+1
                                ,readers[i].getFirstname()
                                ,readers[i].getLastname()
                                ,readers[i].getPhone()
                        );
                    }
    }
}
