package com.company;

import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.Date;

public class Main {

   /* public static void main3(String[] args) {
	// write your code here
        Vehicle car = new Car(1298, "Saga", 4, 9653, true);
        Rickshaw r = new Rickshaw();
        Vehicle bi=new Cycle("tubeless","Disc",false,2,11,false);
        bi.print();
        bi.printVehicleSpeciality();
        car.print();
        car.printDetails();
    }*/

    public static void main(String[] args) throws SQLException {
      /*  PM emp=new PM();
        emp.workedOnProjects();
        emp.benefits();
        emp.takeInterview();
        SoftwareEngineer emp1=new SoftwareEngineer();
        emp1.benefits();
        emp1.workedOnProjects();
        emp1.takeInterview();

        Internee emp3=new Internee();
        emp3.takeInterview();
        emp3.workedOnProjects();
         emp3.benefits();//comment has been added


*/
        System.out.println("hello world");
        Board obj= new Board(10,10);
        DB_DAL ahmad = new DB_DAL();
        ahmad.delete_saved_state(20);
    }
}
