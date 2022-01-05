package com.company;

public class House extends Property{
    private Double gardenSurface;

    public House(Long identificationNumber, Double price, String city, Double surface, Double gardenSurface) {
        super(identificationNumber, price, city, surface);
        this.gardenSurface = gardenSurface;
    }

    public Double getGardenSurface() {
        return gardenSurface;
    }

    public void setGardenSurface(Double gardenSurface) {
        this.gardenSurface = gardenSurface;
    }
    public String getDescription(){
        return "HOUSE - "+this.getSurface()+" sqm. - " + this.getPrice()+" - " + this.getGardenSurface();
    }
}
