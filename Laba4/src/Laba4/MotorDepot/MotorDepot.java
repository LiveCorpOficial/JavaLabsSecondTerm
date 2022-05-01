package Laba4.MotorDepot;

import java.util.ArrayList;
import java.util.Objects;
import Laba4.Car.Car;

public class MotorDepot {
    private static final class Slot {
        enum Status {
            Base,
            Flight,
            Repair,
        }

        final private Car car;
        private Status carStatus;
        private boolean isBroken;
        private Slot(Car car) {
            this.car = car;
            carStatus = Status.Base;
            isBroken = false;
        }
    }

    final int maxSize;
    final ArrayList<Slot> slots;

    public MotorDepot(int maxSize) {
        this.maxSize = maxSize;
        slots = new ArrayList<Slot>(maxSize);
    }

    final public void add(Car car) {
        if(slots.size() >= maxSize) {
            System.out.println("Автобаза заполнена");
            return;
        }
        slots.add(new Slot(car));
        System.out.println("Машина " + car.getBrand() + " добавлена на базу");
    }

    final public void removeBySerialNumber(String serialNumber) {
        int prevSize = slots.size();
        slots.removeIf(slot -> slot.car.getRegisterCode() == serialNumber);
        if(slots.size() == prevSize) System.out.println("Нет машины с серийным номером " + serialNumber);
        else System.out.println("Машина с серийным номером " + serialNumber + " удалена с базы");
    }

    final public void printOnBase() {
        System.out.println("Машины на базе:");
        for(int i = 0; i < slots.size(); i++) {
            if(slots.get((i)).carStatus != Slot.Status.Base) continue;
            Slot slot = slots.get(i);
            System.out.printf("Машина: %8s | Цвет: %-10s | Номер: %-10s | " +
                    "Статус: %11s | Сломана: %b\n", slot.car.getBrand(), slot.car.getColor(), slot.car.getRegisterCode(), slot.carStatus, slot.isBroken);
        }
    }
    final public void printOnFlight() {
        System.out.println("Машины в рейсе:");
        for(int i = 0; i < slots.size(); i++) {
            if(slots.get((i)).carStatus != Slot.Status.Flight) continue;
            Slot slot = slots.get(i);
            System.out.printf(i+1 + ") Машина: %8s | Цвет: %-10s | S/N: %-15s\n" +
                    "Статус: %11s | Сломана: %b\n", slot.car.getBrand(), slot.car.getColor(), slot.car.getRegisterCode(), slot.carStatus, slot.isBroken);
        }
    }
    final public void printOnRepair() {
        System.out.println("Машины в ремонте:");
        for(int i = 0; i < slots.size(); i++) {
            if(slots.get((i)).carStatus != Slot.Status.Repair) continue;
            Slot slot = slots.get(i);
            System.out.printf(i+1 + ") Машина: %8s | Цвет: %-10s | S/N: %-15s\n" +
                    "Статус: %11s | Сломана: %b\n", slot.car.getBrand(), slot.car.getColor(), slot.car.getRegisterCode(), slot.carStatus, slot.isBroken);
        }
    }

    final public void breakCar(String serialNumber) {
        int index = getCarIndexBySerialNumber(serialNumber);
        if(index == -1) {
            System.out.println("Машина не найдена");
            return;
        }
        Slot slot = slots.get(index);
        String brand = slot.car.getBrand();
        if(slot.isBroken) System.out.println("Машина " + brand + " уже сломана");
        else if(slot.carStatus == Slot.Status.Flight) {
            slot.carStatus = Slot.Status.Base;
            slot.isBroken = true;
            System.out.println("Машина " + brand + " сломалась и была отправлена на базу");
        }
        else if(slot.carStatus == Slot.Status.Repair) System.out.println("Машина " + brand + " в ремонте и не может сломаться");
        else System.out.println("Машина " + brand + " находиться на базе, как она может сломаться?");
    }

    final public void toFlight(String serialNumber) {
        int index = getCarIndexBySerialNumber(serialNumber);
        if(index == -1) {
            System.out.println("Машина не найдена");
            return;
        }
        Slot slot = slots.get(index);
        String brand = slot.car.getBrand();
        if (slot.carStatus == Slot.Status.Flight) System.out.println("Машина " + brand + " уже в рейсе");
        else if (slot.carStatus == Slot.Status.Repair) System.out.println("Машина " + brand + " в ремонте и не может отправиться в рейс");
        else if(slot.isBroken) System.out.println("Машина " + brand + " сломана, отремонтируйте её перед отправкой в рейс");
        else {
            slot.carStatus = Slot.Status.Flight;
            System.out.println("Машина " + brand + " отправлена в рейс");
        }
    }

    final public void toRepair(String serialNumber) {
        int index = getCarIndexBySerialNumber(serialNumber);
        if(index == -1) {
            System.out.println("Машина не найдена");
            return;
        }
        Slot slot = slots.get(index);
        String brand = slot.car.getBrand();
        if(!slot.isBroken) System.out.println("Машина " + brand + " не сломана");
        else if(slot.carStatus == Slot.Status.Flight) System.out.println("Машина " + brand + " в рейсе");
        else if(slot.carStatus == Slot.Status.Repair) System.out.println("Машина " + brand + " уже в ремонте");
        else {
            slot.carStatus = Slot.Status.Repair;
            System.out.println("Машина " + brand + " отправлена в ремонт");
        }
    }

    final public void toBase(String serialNumber) {
        int index = getCarIndexBySerialNumber(serialNumber);
        if(index == -1) {
            System.out.println("Машина не найдена");
            return;
        }
        Slot slot = slots.get(index);
        String brand = slot.car.getBrand();
        if(slot.carStatus == Slot.Status.Flight) {
            slot.carStatus = Slot.Status.Base;
            System.out.println("Машина " + brand + " вернулась на базу");
        } else if(slot.carStatus == Slot.Status.Repair) {
            slot.carStatus = Slot.Status.Base;
            slot.isBroken = false;
            System.out.println("Машину " + brand + " починили и вернули на базу");
        } else System.out.println("Машина " + brand + " уже находится на базе");
    }

    private int getCarIndexBySerialNumber(String serialNumber) {
        for(int i = 0; i < slots.size(); i++)
            if(Objects.equals(slots.get(i).car.getRegisterCode(), serialNumber)) return i;
        return -1;
    }
}