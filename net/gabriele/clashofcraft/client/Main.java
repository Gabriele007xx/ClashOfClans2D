package net.gabriele.clashofcraft.client;

public class Main {
    public static void main(String args[])
    {
        Coc coc = new Coc();
        while(coc.RunningNow())
        {
            coc.update();
            coc.render();
        }

    }
}
