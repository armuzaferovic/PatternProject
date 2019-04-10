package model;

public class ObserverSeasonVorbei extends Observer {
    private StatePlayoffs x = new StatePlayoffs();
    public ObserverSeasonVorbei(Spiel s){
        this.sub = s;
        this.sub.attach(this);
    }
    @Override
    public void update() {
        if(sub.getGamesplayed() == 82){
        x.nochImSpiel();
        }

    }
}
