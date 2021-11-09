package Composition;

public class Human {
    heart humanHeart;// human is composed of heart-> lifetime are dependant
    public Human(){
        humanHeart=new heart();
    }
}
