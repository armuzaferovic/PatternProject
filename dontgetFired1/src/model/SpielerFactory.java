package model;

import java.util.Random;

import static java.lang.Thread.*;

public class SpielerFactory {

    private int[] list = {-5,-4,-3,-2,-1,0,1,2,3,4,5};
    private int[] vlist = {-2,-1,0,1,2,3,4,5};
    private int[] rlist = {-10,-7,-5,-2,-1,0,4,5,6,7,8,9};
    private NameGenerator x = new NameGenerator();
    private int max = 2;
    private int min = 0;
    private int range = max - min + 1;
    private int ran;
    private String typex;
    public Spieler createSpieler() throws InterruptedException {
        Spieler s = new Spieler();
        s.setName(x.generateName());
        s.setTypex(this.typex);
        Thread.sleep(200);

        s.setRating(list[rand().nextInt(list.length)]);
        return s;
    }
    public Spieler createSpieler(char v) throws InterruptedException {

            Spieler s = new Spieler();
            s.setName(x.generateName());
            s.setTypex(this.typex);
            Thread.sleep(200);
        if (v == 'v') {
            s.setRating(vlist[rand().nextInt(vlist.length)]);}
        else{
            s.setRating(rlist[rand().nextInt(rlist.length)]);
        }

            return s;
        }



    private static Random rand(){
        return new Random();
    }
    public void typeSet(){
        ran = (int)(Math.random() * range) + min;
        switch(ran) {
            case 0:
                this.typex = "Shooter" ;
                break;
            case 1:
                this.typex = "Defender" ;
                break;
            case 2:
                this.typex="Scrub";
                break;
            default: this.typex="Scrub";
        }

    }

    }

