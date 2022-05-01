package Laba4.Engine;

public class Engine {

    private String serialNumber;
    private String typeOfFuel;
    private int power;
    private int workingVolume;
    private int numberCylinders;
    private double consumption;

    public Engine (int power, String serialNumber, int workingVolume, int consumption, String typeOfFuel, int numberCylinders) {
        this.power = power;
        this.serialNumber = serialNumber;
        this.workingVolume = workingVolume;
        this.consumption = consumption;
        this.typeOfFuel = typeOfFuel;
        this.numberCylinders = numberCylinders;
    }
    public void print() {
        System.out.println("-----------------------------");
        System.out.println("\tМощность: " + this.power);
        System.out.println("\tСерийный номер: " + this.serialNumber);
        System.out.println("\tРабочий объем: " + this.workingVolume);
        System.out.println("\tРасход топлива: " + this.consumption);
        System.out.println("\tВид топлива: " + this.typeOfFuel);
        System.out.println("\tЧисло цилинров: " + this.numberCylinders);
        System.out.print("-----------------------------\n\n");
    }

    public void setPower(int power) { this.power = power; }
    public void setSerialNumber(String serialNumber) { this.serialNumber = serialNumber; }
    public void setWorkingVolume(int workingVolume) { this.workingVolume = workingVolume; }
    public void setConsumption(double consumption) { this.consumption = consumption; }
    public void setNumberCylinders(int numberCylinders) { this.numberCylinders = numberCylinders; }
    public void setTypeOfFuel(String typeOfFuel) { this.typeOfFuel = typeOfFuel; }

    public int getPower() { return power; }
    public double getConsumption() { return consumption; }
    public int getNumberCylinders() { return numberCylinders; }
    public int getWorkingVolume() { return workingVolume; }
    public String getSerialNumber() { return serialNumber; }
    public String getTypeOfFuel() { return typeOfFuel; }

}
