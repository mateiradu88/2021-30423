package com.company;

abstract class Property {

    private Long identificationNumber;
    private Double price;
    private String city;
    private Double surface;
    private Double pricePerSqm;

    public Property() {

    }

    public Property(Long identificationNumber, Double price, String city, Double surface) {
        this.identificationNumber = identificationNumber;
        this.price = price;
        this.city = city;
        this.surface = surface;
        this.pricePerSqm = price/surface;
    }

    public Double getPricePerSqm() {
        return pricePerSqm;
    }

    public Long getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(Long identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getSurface() {
        return surface;
    }

    public void setSurface(Double surface) {
        this.surface = surface;
    }

    public String getDescription(){
        return "desc";
    }

}
