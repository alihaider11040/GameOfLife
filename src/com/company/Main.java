package com.company;

import java.sql.SQLOutput;
import java.util.Date;

public class Main {

    public static void main3(String[] args) {
	// write your code here
        Vehicle car = new Car(1298, "Saga", 4, 9653, true);
        Rickshaw r = new Rickshaw();
        Vehicle bi=new Cycle("tubeless","Disc",false,2,11,false);
        bi.print();
        bi.printVehicleSpeciality();
        car.print();
        car.printDetails();
    }

    public static void main(String[] args){
        PM emp=new PM();
        emp.workedOnProjects();
        emp.benefits();
        emp.takeInterview();
        SoftwareEngineer emp1=new SoftwareEngineer();
        emp1.benefits();
        emp1.workedOnProjects();
        emp1.takeInterview();

        Internee emp2=new Internee();
        emp2.takeInterview();
        emp2.workedOnProjects();
         emp2.benefits();//comment has been added



    }
}
