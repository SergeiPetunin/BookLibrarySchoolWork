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
        reader.setPhone(scanner.nextLine());
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

    public Reader[] changeReader(Reader[] readers) {
        System.out.println("Список читателей: ");
        this.printListReaders(readers);
        System.out.println("Выберете номер читателя из списка: ");
        int numberReader = scanner.nextInt(); scanner.nextLine();
        System.out.println("Имя: " + readers[numberReader - 1].getFirstname());
        System.out.println("Заменить? (y/n): ");
        String task = scanner.nextLine();
        if("y".equals(task)) {
            System.out.println("Введите новое имя");
            readers[numberReader - 1].setFirstname(scanner.nextLine());
        }
        System.out.println("Фамилия: " + readers[numberReader - 1].getLastname());
        System.out.println("Заменить? (y/n): ");
        task = scanner.nextLine();
        if("y".equals(task)) {
            System.out.println("Введите новоую фамилию");
            readers[numberReader - 1].setLastname(scanner.nextLine());
        }
        System.out.println("Телефон: " + readers[numberReader - 1].getPhone());
        System.out.println("Заменить? (y/n): ");
        task = scanner.nextLine();
        if("y".equals(task)) {
            System.out.println("Введите новый телефон");
            readers[numberReader - 1].setPhone(scanner.nextLine());
        }
        System.out.println("Изменённый читатель: " + readers[numberReader - 1].toString());
        
        
        return readers;
    }
    
}
