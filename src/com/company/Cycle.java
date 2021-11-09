package com.company;

public class Cycle extends Vehicle{
    String tubeType;
    String brake_Type;
    boolean gearbox;
    public Cycle(){
        super();
    }
    public Cycle(String tubeType, String brake_Type,boolean gearbox, int NoOfWheels, int reg_no, boolean is_engine_powered){
        super.Vehicle(reg_no,"Cycle",is_engine_powered);
        this.brake_Type=brake_Type;
        this.tubeType=tubeType;
        this.gearbox=gearbox;
    }
    public void Cycle(String tubeType,String brake_Type,boolean gearbox){
        this.gearbox=gearbox;
        this.tubeType=tubeType;
        this.brake_Type=brake_Type;
    }
    @Override
    public void print(){
        super.print();
        System.out.println("its a Bicyle! lets Ride!!");
    }
    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("TubeType: " + this.tubeType + "BreakType: " + this.brake_Type+" Gearbox: " +this.gearbox);
    }
    public void printVehicleSpeciality(){
        System.out.println("TubeType: " + this.tubeType + "BreakType: " + this.brake_Type+" Gearbox: " +this.gearbox);

    }
    public String getTubeType(){return tubeType;}
    public String getBrake_Type(){return brake_Type;}
    public boolean isGearbox(){return gearbox;}
}
