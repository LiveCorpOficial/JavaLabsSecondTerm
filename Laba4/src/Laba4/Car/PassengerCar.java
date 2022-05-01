package Laba4.Car;

import Laba4.Engine.Engine;

public class PassengerCar extends Car{

    private String TrunkContents;

    public PassengerCar(String registerCode, String brand, ColorsCar color, Engine engine, int wheels) {
        super(registerCode, brand, color, engine, wheels);
    }
    public PassengerCar(String brand, ColorsCar color, Engine engine, int wheels) {
        super(brand, color, engine, wheels);
    }

    public void print() {
        System.out.println("Что под задним капотом: " + this.TrunkContents);
        this.printDefault();
    }

    public void setTrunkContents(String TrunkContents) {
        this.TrunkContents = TrunkContents;
    }

}
