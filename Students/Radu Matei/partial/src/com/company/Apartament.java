package com.company;

public class Apartament extends Property{
    private int floor;

    public Apartament(Long identificationNumber, Double price, String city, Double surface,int floor) {
        super(identificationNumber, price, city, surface);
        this.floor = floor;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }
    public String getDescription(){
        return ("APARTMENT - "+this.getSurface()+" sqm. - " + this.getPrice()+" - floor " + this.getFloor());
    }
}
