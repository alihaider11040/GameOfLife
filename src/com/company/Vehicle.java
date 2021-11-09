package com.company;

    public abstract class Vehicle {
        private int reg_no;
        public String type;
        public boolean is_engine_powered;

        public Vehicle()
        {

        }
        public Vehicle(int reg_no, String type, boolean is_engine_powered)
        {
            this.reg_no = reg_no;
            this.type = type;
            this.is_engine_powered = is_engine_powered;
        }

        public void Vehicle(int reg_no, String type, boolean is_engine_powered)
        {
            this.reg_no = reg_no;
            this.type = type;
            this.is_engine_powered = is_engine_powered;
        }

        public void printDetails() {
            System.out.println("RegNo: " + this.reg_no + "Type: " + this.type + "Is Engine Powered? : " + this.is_engine_powered);
        }

        public abstract void printVehicleSpeciality();
        public int getReg_no() {
            return reg_no;
        }

        public void print() {
            System.out.println("This is a Vehicle");
        }
    }


