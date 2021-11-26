package com.company;

import com.company.BL.cell;

public class Main {
    public static void main(String[] args){

        System.out.println("hello world");
        cell c1 = new cell(12,13,false);
        c1.printCell();
        c1.updateStatus(false);
        c1.printCell();
    }
}
