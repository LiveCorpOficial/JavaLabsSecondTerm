package Laba4.Car;

import Laba4.Engine.Engine;

public class TruckCar extends Car{

    private int load_capacity;

    public TruckCar(String registerCode, String brand, ColorsCar color, Engine engine, int wheels) {
        super(registerCode, brand, color, engine, wheels);
    }
    TruckCar(String brand, ColorsCar color, Engine engine, int wheels) {
        super(brand, color, engine, wheels);
    }

    public void setLoad_capacity(int load_capacity) {
        this.load_capacity = load_capacity;
    }

    public void print() {
        System.out.println("Грузоподемность: " + this.load_capacity);
        this.printDefault();
    }
}
