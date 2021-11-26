package com.company.BL;
import java.util.Timer;
public class counter {
    int count;
    Timer time;
    int speed;

    public counter() {
        count = 0;
        time = new Timer();
        speed = 5000;
    }

    public int getCount() {
        return count;
    }

    void updateCount() {
        count++;
    }

    void Waiter()
    {
        try {
            time.wait(speed);
        } catch (InterruptedException e) {
            System.out.println("speed not found");
            e.printStackTrace();
        }
    }
    void speedChange(int x)
    {
        speed = x;
    }

}
