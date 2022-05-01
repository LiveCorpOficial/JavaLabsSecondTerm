package Laba4.Car;

import Laba4.Engine.Engine;

public class Bus extends Car{
    private int seat; // сиденья

    public Bus(String registerCode, String brand, ColorsCar color, Engine engine, int wheels, int seat) {
        super(registerCode, brand, color, engine, wheels);
        this.seat = seat;
    }

    public Bus(String brand, ColorsCar color, Engine engine, int wheels, int seat) {
        super(brand, color, engine, wheels);
        this.seat = seat;
    }

    public double getSeat() { return seat; }

    public void setSeat(int seat) { this.seat = seat; }
}
