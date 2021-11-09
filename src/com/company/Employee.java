package com.company;

import java.nio.charset.StandardCharsets;

public abstract class Employee implements EmployeeMethods{



public Employee(){


}
public abstract void workedOnProjects();
public  abstract void benefits();
public void takeInterview(){
    System.out.println("Cannot take Interview");
}

}
