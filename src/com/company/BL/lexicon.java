package com.company.BL;

import com.company.BL.shape;

public class lexicon {
    public shape[] Lexicon;
    public int size;
    public int count;

    public lexicon(int s)
    {
        Lexicon = new shape[s];
        size = s;
        count = 0;
    }
    void AddShape(shape x)
    {
        Lexicon[count] = x;
    }
    void List()
    {
        for(int i =0;i<count;i++)
        {
            System.out.println(Lexicon[i].getName());
        }
    }
}
