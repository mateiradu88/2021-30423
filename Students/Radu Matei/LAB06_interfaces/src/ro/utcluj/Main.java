package ro.utcluj;

import ro.utcluj.model.Movie;
import ro.utcluj.model.Product;
import ro.utcluj.model.Book;
import ro.utcluj.service.ArraysService;

public class Main {

    public static void main(final String[] args) {
        Book[] library = new Book[10];
        for (int i = 0; i < library.length; i++) {
            library[i] = new Book((int)(Math.random()*100));
            System.out.print(library[i].getNumberOfPages()+" ");
        }
        System.out.println();
        ArraysService.sort(library);
        for (int i = 0; i < library.length; i++) {
            System.out.print(library[i].getNumberOfPages()+" ");
        }
        System.out.println();

    }
}
