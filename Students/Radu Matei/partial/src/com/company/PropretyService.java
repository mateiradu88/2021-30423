package com.company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.Random;

public class PropretyService implements ReportService{

    private Property[] properties;
    private Integer noProprieties ;
    private final static Integer MAXnoProprieties = 100;

    public PropretyService() {
        this.properties = new Property[MAXnoProprieties];
        this.noProprieties =0;
    }

    @Override
    public void printReport() {
        int j =0;
        int old =0;
        for (int i = 1; j < MAXnoProprieties && properties[j] != null ; i++) {
            int noHouses =0;
            int noApartments =0;
            while (Objects.equals(properties[j].getCity(), properties[old].getCity())&&properties[j]!=null){
                if(properties[j] instanceof Apartament){
                    noApartments++;
                }
                if(properties[j] instanceof House){
                    noHouses++;
                }
                j++;
                if(j>=MAXnoProprieties){
                    break;
                }
                if(properties[j]==null){
                    break;
                }
            }
            System.out.println(i+". "+properties[old].getCity()+" - " + noHouses + " houses, " + noApartments + " apartments");
            j=old;
            while (Objects.equals(properties[j].getCity(), properties[old].getCity())&&properties[j]!=null){
                System.out.println(properties[j].getDescription());
                j++;
                if(j>=MAXnoProprieties){
                    break;
                }
                if(properties[j]==null){
                    break;
                }
            }
            old = j;
        }

    }

    private void sortArrayDefault(){
        Comparator<Property> comparator = Comparator.nullsLast(Comparator.comparing(Property::getCity).thenComparing(Property::getPrice));
        Arrays.sort(properties, comparator);
    }
    private void sortArrayByPrice(){
        Comparator<Property> comparator = Comparator.nullsLast(Comparator.comparing(Property::getPrice).reversed());
        Arrays.sort(properties, comparator);
    }
    private boolean idNumInArray(Long idNum){
        for (Property property : this.properties) {
            if (property != null) {
                if (Objects.equals(idNum, property.getIdentificationNumber())) {
                    return true;
                }
            }
        }

        return false;
    }

    public String register(Property property){
        Long idNum = 0L;
        if(property.getCity()==null){
            return "Invalid data";
        }
        if(property.getPrice()==null){
            return "Invalid data";
        }
        if(property.getSurface()==null){
            return "Invalid data";
        }
        if(property.getIdentificationNumber()!=null){
            if(idNumInArray(property.getIdentificationNumber())){
                return "Identification Number already assigned";
            }
            idNum = property.getIdentificationNumber();
        }
        else{
            Long generatedLong = new Random().nextLong();
            while(idNumInArray(generatedLong)){
                generatedLong = new Random().nextLong();
            }
            idNum = generatedLong;
        }
        property.setIdentificationNumber(idNum);
        if(noProprieties==MAXnoProprieties){
            sortArrayByPrice();
            properties[this.noProprieties-1] =property;
        }
        else{
            properties[this.noProprieties] =property;
            this.noProprieties++;
        }
        sortArrayDefault();
        return null;
    }

    public Property[] findAllByPricePerSqmBetween(Double from, Double to){
        Property[] propertiesInRange = new Property[MAXnoProprieties];
        int propIndex=0;
        for (Property propriety:properties) {
            if(propriety!=null){
                if(from!=null && to!=null){
                    if(propriety.getPricePerSqm()>=from&&propriety.getPricePerSqm()<=to){
                        propertiesInRange[propIndex] = propriety;
                        propIndex++;
                    }
                }
                if(from==null && to!=null){
                    if(propriety.getPricePerSqm()<=to){
                        propertiesInRange[propIndex] = propriety;
                        propIndex++;
                    }
                }
                if(from!=null && to==null){
                    if(propriety.getPricePerSqm()>=from){
                        propertiesInRange[propIndex] = propriety;
                        propIndex++;
                    }
                }
                if(from==null && to==null){
                        propertiesInRange[propIndex] = propriety;
                        propIndex++;
                }
            }
        }
        return propertiesInRange;
    }

    public Property[] remove(Property[] properties){
        Property[] remaining_proprieties = new Property[MAXnoProprieties];
        int array_index = 0;
            for (Property property:this.properties) {
                boolean flag = true;
                for (Property propretyID:properties) {
                    if(property!=null && property.getIdentificationNumber() == propretyID.getIdentificationNumber()){
                        flag = false;
                    }
                }
                if(flag){
                    remaining_proprieties[array_index] = property;
                    array_index++;
                }
            }
        this.properties = remaining_proprieties;
        return remaining_proprieties;
    }

}