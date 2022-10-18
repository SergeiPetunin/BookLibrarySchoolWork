/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entity.Book;
import entity.Reader;
import java.util.Scanner;

/**
 *
 * @author pupil
 */
public class ReaderManager {
    private final Scanner scanner;
    
    public ReaderManager() {
        scanner = new Scanner(System.in);
    }
    
    public Reader createReader() {
        Reader reader = new Reader();
        System.out.println("Введите имя: ");
        reader.setFirstname(scanner.nextLine());
        System.out.println("Введите фамилию: ");
        reader.setLastname(scanner.nextLine());
        System.out.println("Введите : ");
        reader.setFirstname(scanner.nextLine());
        return reader;
    }
    
    
    public void printListReaders(Reader[] readers) {
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
