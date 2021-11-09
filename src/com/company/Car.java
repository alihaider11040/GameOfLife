package com.company;

public class Car extends Vehicle{

    private String Name;
    private int NoOfWheels;
    private int Engine;              //Engine Size

    public Car()
    {
        super();
    }

    public Car(int Engine, String Name, int NoOfWheels, int reg_no, boolean is_engine_powered)
    {
        super.Vehicle(reg_no, "Car", is_engine_powered);
        this.Engine = Engine;
        this.Name = Name;
        this.NoOfWheels = NoOfWheels;
    }

    public void Car(int Engine, String Name, int NoOfWheels)
    {
        this.Engine = Engine;
        this.Name = Name;
        this.NoOfWheels = NoOfWheels;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Its Type is car!");
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Name: " + this.Name + "No of Wheels: " + this.NoOfWheels + "Engine: " + this.Engine);
    }
    public void printVehicleSpeciality(){
        System.out.println("Name: " + this.Name + "No of Wheels: " + this.NoOfWheels + "Engine: " + this.Engine);


    }
    public int getRegNo() {
        return super.getReg_no();
    }

    public int NoOfWheels() {
        return this.NoOfWheels;
    }

    public int getEngineSize() {
        return this.Engine;
    }

    public String Name() {
        return this.Name;
    }

}
