package com.company;

public class Rickshaw extends Vehicle{
    int capacity;
    int mileAage;
    public Rickshaw(){// constructor
        super();
    }
    public Rickshaw(int capacity, int mileAage, int reg_no, boolean is_engine_powered){
        super.Vehicle(reg_no,"Rickshaw",is_engine_powered);
        this.capacity=capacity;
        this.mileAage=mileAage;

    }
    public void Rickshaw(int capacity,int mileAage){
        this.mileAage=mileAage;
        this.capacity=capacity;
    }

    @Override
    public void print(){
        super.print();
        System.out.println("its a rickshaw Yupee!!");
    }
    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Capacity: " + this.capacity + "Milleage: " + this.mileAage);
    }
    public void printVehicleSpeciality(){
        System.out.println("Capacity: " + this.capacity + "Milleage: " + this.mileAage);

    }
public int getCapacity(){return this.capacity;}
public int getMileAage(){return  this.mileAage;}
}
