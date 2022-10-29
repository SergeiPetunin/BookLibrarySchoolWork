/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entity.Book;
import entity.History;
import entity.Reader;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
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
        history.setReader(readers[numberReader - 1]);
        history.setTakeOnBook(new GregorianCalendar().getTime());
        return history;
    }
    
    public History[] returnBook(History[] historyes){
        //Выбрать номер книги из списка выданных книг
        //В выбранную книгу добавить дату возврата
        System.out.println("Список выданных книг: ");
        this.printHistoryList(historyes);
        System.out.print("Выберите номер книги для возврата: ");
        int numberToReturnBook = scanner.nextInt(); scanner.nextLine();
        historyes[numberToReturnBook - 1].setReturnBook(new GregorianCalendar().getTime());
        return historyes;
    }
    
    public void printHistoryList(History[] historyes) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyy");
        for(int i  = 0; i < historyes.length; i++) {
            History history = historyes[i];
            if(history.getReturnBook() == null)
            System.out.printf("%d. %s. Выдана: %s Читает:  %s %s. Telefon: %s%n"
                ,i + 1
                ,history.getBook().getTitle()
                ,sdf.format(history.getTakeOnBook())
                ,history.getReader().getFirstname()
                ,history.getReader().getLastname()
                ,history.getReader().getPhone()
                
            );
        }
    }

    public void printReturnHistoryList(History[] historyes) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyy");
        for(int i  = 0; i < historyes.length; i++) {
            History history = historyes[i];
            if(history.getReturnBook() != null)
            System.out.printf("%d. %s. Вернул: %s   %s %s. Telefon: %s%n"
                ,i + 1
                ,history.getBook().getTitle()
                ,sdf.format(history.getReturnBook())
                ,history.getReader().getFirstname()
                ,history.getReader().getLastname()
                ,history.getReader().getPhone()
                
            );
        }
    }
}
