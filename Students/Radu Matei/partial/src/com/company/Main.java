package com.company;

public class Main {

    public static void main(String[] args) {
        PropretyService propretyService = new PropretyService();
        House house = new House(1L, 1010.1,"Alberta",12.0,13.0);
        Apartament apartament =new Apartament(null,1000.0,"Cluj-Napoca",100.0,2);
        Apartament apartament2 =new Apartament(null,2000.0,"Cluj-Napoca",120.0,2);
        System.out.println(propretyService.register(house));
        System.out.println(propretyService.register(apartament));
        System.out.println(propretyService.register(apartament2));
        Property[] removeProps = new Property[1];
        propretyService.printReport();
        System.out.println();
        removeProps[0] = apartament2;
        propretyService.remove(removeProps);
        propretyService.printReport();
    }
}
