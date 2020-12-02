package model;

import exceptions.InputException;

public abstract class Technique {
    private String modelName;
    private int price;
    private int year;
    private String country;

    public Technique(String modelName, int price, int year, String country) {
        this.modelName = modelName;
        this.price = price;
        this.year = year;
        this.country = country;
    }
    private boolean isCorrectName(String name){
        if(name.length()>2 && name!=null )
            return true;
        return false;
    }

    private boolean isCorrectPrice(int price){
        if(price>5000 && price<2000000)
            return true;
        return false;
    }

    private boolean isCorrectYear(int year){
        if(year>2006 && year<2021)
            return true;
        return false;
    }
    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        if(isCorrectName(modelName))
            this.modelName = modelName;
        else
            throw  new InputException();
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if(isCorrectPrice(price))
            this.price = price;
        else
            throw  new InputException();
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if(isCorrectYear(year))
            this.year = year;
        else
            throw  new InputException();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        if(isCorrectName(country))
            this.country = country;
        else
            throw  new InputException();
    }

    public  void printInfo(){
        System.out.println("************************");
        System.out.println("ModelName : "+ getModelName());
        System.out.println("Price : "+ getPrice());
        System.out.println("Year : "+ getYear());
        System.out.println("Country : "+ getCountry());
    }
}
