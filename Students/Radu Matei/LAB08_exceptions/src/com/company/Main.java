package com.company;

/**
 * Create the following classes:
 * --------------------
 * PrintingService
 * --------------------
 * - inkAmount: Double
 * - paperAmount: Integer
 * --------------------
 * + print(document: Document)
 * --------------------
 *
 * --------------------
 * Document
 * --------------------
 * - text: String
 * - numberOfPages: Integer
 * --------------------
 * --------------------
 *
 * Create 2 exceptions: OutOfInkException (unchecked) and OutOfPaperException (checked)
 * - print method consumes 0.001 * document.text.length * numberOfPages ink for each
 * document that's being printed
 * - print method consumes numberOfPages for each document that's being printed
 * - throw one of the exceptions depending on the situation
 */

public class Main {

    public static void main(String[] args){
        Document document = new Document("I'm a new document!",10);
        PrintingService printingService = new PrintingService();

        printingService.safePrint(document);

        document.setNumberOfPages(1000);

        printingService.safePrint(document);
        printingService.setPaperAmount(10000);

        printingService.safePrint(document);
        printingService.setInkAmount(1000.0);

        printingService.safePrint(document);
    }

}
