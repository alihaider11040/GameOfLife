package com.company.BL;

public class main {

    public static void main(String [] args) {
        /*shape sh1  = new shape(5,"hello");
        sh1.fillShape("C:\\Users\\shabd\\IdeaProjects\\GameOfLife\\src\\com\\company\\BL\\dice.txt",5);
        sh1.printShape();*/
       /* counter c1 = new counter();
        System.out.println(c1.getCount());
        for (int i = 0; i < 99; i++)
        {
            c1.updateCount();
        }
        System.out.println(c1.getCount());
*/
        Board b1 = new Board(5,5);
        b1.fillBoard();
        Save s1 = new Save();
        //s1.Save(b1,"newfile.txt");
        //s1.loadBoard("C:\\Users\\shabd\\IdeaProjects\\GameOfLife\\src\\com\\company\\Filing\\dice.txt",5);
       // s1.Save(b1,"gwp.txt");
    }
}
