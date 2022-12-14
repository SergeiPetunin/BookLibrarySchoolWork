/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jktv21library;

import entity.Book;
import entity.History;
import entity.Reader;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import managers.BookManager;
import managers.DataManager;
import managers.HistoryManager;
import managers.ReaderManager;

/**
 *
 * @author pupil
 */
public class App {
    private final Scanner scanner;
    private final BookManager bm;
    private final ReaderManager rm;
    private final HistoryManager hm;
    private DataManager dm;
    private Book[] books;
    private Reader[] readers;
    private History[] historyes;
    
    public App() {
        scanner = new Scanner(System.in);
        bm = new BookManager();
        rm = new ReaderManager();
        hm = new HistoryManager();
        dm = new DataManager();
        books = dm.loadBooksFromFile(); //new Book[0];
        readers = dm.loadReadersFromFile();
        historyes = dm.loadHistoryFromFile();
//        testAddBook();
//        testAddReader();
    }
    
    public void run(){
        DataManager dm = new DataManager();
        boolean repeat = true;
        do{
            try {
                System.out.println("Функции приложения:");
                System.out.println("0. Закрыть приложение");
                System.out.println("1. Добавить книгу" );
                System.out.println("2. Добавить читателя");
                System.out.println("3. Выдать книгу");
                System.out.println("4. Вернуть книгу");
                System.out.println("5. Список книг");
                System.out.println("6. Список читателей");
                System.out.println("7. История");
                System.out.println("8. Изменить читателя");
                System.out.println("9. Изменить книгу");
                System.out.println("10. История возврата");
                System.out.print("Выберете функцию:");

                int task = scanner.nextInt();
                scanner.nextLine();
                switch (task){
                    case 0:
                        repeat = false;
                        break;
                    case 1:
                        //Добавить книгу
                        addBook(bm.createBook());
                        dm.saveBookToFile(books);
                        break;
                    case 2:
                        //Добавить читателя
                        addReader(rm.createReader());
                        dm.saveReaderToFile(readers);
                        break;
                    case 3:
                        //Выдать книгу
                        addHistoryes(hm.takeOnBook(readers, books));
                        dm.saveBookHistory(historyes);
                        break;
                    case 4:
                        //Вернуть книгу
                        historyes = hm.returnBook(historyes);
                        dm.saveBookHistory(historyes);
                        break;
                    case 5:
                        //Список книг
                        bm.printListBooks(books);
                        break;
                    case 6:
                        //Список читателей
                        rm.printListReaders(readers);
                        break;
                    case 7:
                        //История
                        hm.printHistoryList(historyes);
                        break;
                    case 8:
                        //Изменить читателя
                        readers = rm.changeReader(readers);
                        break;
                    case 9:
                        //Изменить книгу
                        books = bm.changeBook(books);
                        break;
                    case 10:
                        //История возврата
                        hm.printReturnHistoryList(historyes);
                        break;
                    default:
                        System.out.println("Введите номер функции!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Введите номер функции!");
                System.out.println(e);
                scanner.nextLine();
            }
            
        }while(repeat);
        System.out.println("Пока!");
    }
    
    private void addBook(Book book){
        books = Arrays.copyOf(books, books.length+1);
        books[books.length-1] = book;
    };
    
    private void addReader(Reader reader){
        readers = Arrays.copyOf(readers, readers.length+1);
        readers[readers.length-1] = reader;
    };
    
    private void addHistoryes(History history){
        historyes = Arrays.copyOf(historyes, historyes.length+1);
        historyes[historyes.length-1] = history;
    };
    
    
    
//    private void testAddBook() {
//        Book book = new Book();
//        book.setTitle("Voina i mir");
//        Author author = new Author("Lev","Tolstoi");
//        book.addAuthor(author);
//        this.books = Arrays.copyOf(books, books.length+1);
//        this.books[this.books.length - 1] = book;
//    }
//    
//    private void testAddReader() {
//        Reader reader = new Reader("Ivan", "Ivanov","515151");
//        readers = Arrays.copyOf(readers, readers.length + 1);
//        readers[readers.length - 1] = reader;
//    }

}
