package model;

public class LossObserver extends Observer {
    private StateVerloren s = new StateVerloren();
    public LossObserver(Spiel s){
        this.sub = s;
        this.sub.attach(this);
    }
    @Override

    public void update() {
        if(sub.getLossStreak()> sub.getLosesToGetFired()){
            s.nochImSpiel();
            System.out.println("GEFEUERT");
            System.exit(1);
        }
    }
}
