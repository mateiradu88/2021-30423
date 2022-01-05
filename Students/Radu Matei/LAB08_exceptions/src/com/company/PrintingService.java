package com.company;

public class PrintingService {

    private Double inkAmount;
    private Integer paperAmount;

    public PrintingService() {
        this(10.0,100);
    }

    public PrintingService(Double inkAmount, Integer paperAmount) {
        this.inkAmount = inkAmount;
        this.paperAmount = paperAmount;
    }

    public Double getInkAmount() {
        return inkAmount;
    }

    public void setInkAmount(Double inkAmount) {
        this.inkAmount = inkAmount;
    }

    public Integer getPaperAmount() {
        return paperAmount;
    }

    public void setPaperAmount(Integer paperAmount){
        this.paperAmount = paperAmount;
    }

    private void print(Document document) throws OutOfPaperException {
        if(this.paperAmount < document.getNumberOfPages()){
            throw new OutOfPaperException();
        }
        if(this.inkAmount < document.getNoCharacters()*0.001){
            throw new OutOfInkException();
        }
        setPaperAmount(this.paperAmount - document.getNumberOfPages());
        setInkAmount(this.inkAmount - document.getNoCharacters()*0.001);
        System.out.println(document.getText() + " printed " + document.getNumberOfPages() + " times.");

    }

    public void safePrint(Document document){
        try {
            print(document);
        }
        catch (OutOfPaperException e){
            System.out.println("Ran out of paper. Canceling job.");
        }
        catch (OutOfInkException e){
            System.out.println("Ran out of ink. Canceling job.");
        }
    }

}
