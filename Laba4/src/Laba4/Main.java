package Laba4;

import Laba4.Car.*;
import Laba4.Engine.*;
import Laba4.Match.Complex;
import Laba4.MotorDepot.MotorDepot;


public class Main {
    public static void main(String[] args) {

        Engine OneEngine = new Engine(150, "122544", 36, 4, "дизель", 6);
        Engine TwoEngine = new Engine(180, "850032", 32, 6, "газ", 6);
        Engine ThreeEngine = new Engine(210, "2146022", 42, 4, "газ", 8);

        PassengerCar Legkaya = new PassengerCar("А 256 ЕЕ 211 RUS","Mazda", Car.ColorsCar.Red, OneEngine, 4);
        Legkaya.setTrunkContents("Аптечка, Инструменты");
        Legkaya.print();

        TruckCar Gryzovik = new TruckCar("В 113 ЕН 121 RUS","Maz", Car.ColorsCar.Green, TwoEngine, 6);
        Gryzovik.setLoad_capacity(1000);
        Gryzovik.print();

        Bus OldAvtobus = new Bus("П 332 НК 121 RUS","Икарус", Car.ColorsCar.Green, OneEngine, 7, 36);
        Bus NewAvtobus = new Bus("C 777 CC 666 RUS","Икарус", Car.ColorsCar.Yellow, ThreeEngine, 4, 36);
        OldAvtobus.print();

        FireCar Pozharka = new FireCar("2В 51ЕЕ 04 SPE", "Volvo", Car.ColorsCar.Red, TwoEngine, 4);
        Pozharka.setRegisterCode("4А 12ВЕ 55 SPE");
        Pozharka.setQuantityWater(100);
        Pozharka.print();

        MotorDepot Base = new MotorDepot(5);
        Base.add(Legkaya);
        Base.add(OldAvtobus);
        Base.add(NewAvtobus);
        Base.add(Pozharka);

        Base.toFlight("C 777 CC 666 RUS");
        Base.toFlight("4А 12ВЕ 55 SPE");
        Base.removeBySerialNumber("А 256 ЕЕ 211 RUS");
        Base.toRepair("4А 12ВЕ 55 SPE");
        Base.breakCar("C 777 CC 666 RUS");
        Base.toRepair("C 777 CC 666 RUS");

        Base.printOnFlight();
        Base.printOnBase();
        Base.printOnRepair();
/*
          Complex z1 = new Complex(5, 4);
          z1.printAlgebraic();
          Complex z2 = new Complex(5, 0);
          z2.printAlgebraic();
          Complex z3 = new Complex(-5, -18);
          z3.printAlgebraic();

          z1 = Complex.add(z1, z2);
          z1.printAlgebraic();
          z1 = Complex.add(z1, 5);
          z1.printAlgebraic();
          z1 = Complex.multiply(z1, z3);
          z1.printAlgebraic();
          z1.printTrigonometric();

 */
    }
}
