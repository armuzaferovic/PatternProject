package view;

import java.util.ArrayList;

import model.*;

import java.util.Random;
import java.util.Scanner;

public class MainDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int max = 100;
		int min = 0;
		int range = max - min + 1;
		Scanner sca = new Scanner(System.in);
		SpielerFactory sf = new SpielerFactory();
		boolean gameDavorVerloren = false;


		Random r = new Random();
		int chanceToDie;
		int gamesleft=82;
		int lossStreak=0;
		int wins=0;
		int losses=0;
		Spiel s = Spiel.getInstance();
		Spieler spi = new Spieler();
		System.out.println();
		int winchance = s.getWinPer();
		ObserverSeasonVorbei osv = new ObserverSeasonVorbei(s);
		LossObserver lo = new LossObserver(s);
		ArrayList<Spieler> kader =new ArrayList<Spieler>();
		ArrayList<Spieler> draftClass=new ArrayList<Spieler>();
		System.out.println("Your Team:" );

		for(int i = 0; i < 12; i++){

			try {
				kader.add(sf.createSpieler());

				System.out.println(kader.get(i).getName());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}


			//First Draftpick
			System.out.println("Sie sind in der letzten Season Letzter geworden \n deshalb haben Sie nun die Chance den ersten Pick des Drafts zu wählen ");
			for(int i = 0 ; i<3;i++){
				try {
					draftClass.add(sf.createSpieler());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(draftClass.get(i).getName());
			}
			System.out.println("Wen picken Sie? [1,2,3]");
			String wahl = sca.nextLine();
			char wahl1 = wahl.charAt(0);
			switch(wahl1){
					case'1':
						Spieler testi = kader.get(0);

					kader.add(testi);
					break;
				case'2':
					kader.add(draftClass.get(1));
					break;
				case'3':
					kader.add(draftClass.get(2));
					break;
				default:
					kader.add(draftClass.get(0));
			}
			s.setWin1(Math.abs(s.getWinPer() + winperRechnen(kader)));

			System.out.println("Die Season geht los!");
			for(int i = 0; i<82; i++){
				if(i%5==0 && i <= 20){
					System.out.println("Einen neuen Spieler oder einen erfahrenen Vet?[r,v, n]");
					String vetorRook = sca.nextLine();
					char x = vetorRook.charAt(0);
					if(x!= 'n'){
					kader.remove(0);
					try {
						kader.add(sf.createSpieler(x));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}}
				}
				if(game(s.getWinPer())){
					wins++;
					s.setDubs(wins);
					gameDavorVerloren = false;
					lossStreak=0;
					System.out.println("Gewonnen!");
					s.setGamesplayed(i+1);
				}
				else{
					gameDavorVerloren=true;
					lossStreak++;
					s.setLossStreak(lossStreak);
					losses++;
					System.out.println("Verloren!");
			}

				System.out.println("Standings:"+ wins+ "|" + losses);
				s.notifyAllObservers();
		//}while(lossStreak< s.getLosesToGetFired() || s.getRandomChance() < chanceToDie);
	}}
	public static int winperRechnen( ArrayList<Spieler> x){
		int o = 0;
		for(int i = 0 ; i<13;i++){


			o+= x.get(i).getRating();
		}
		return o;
	}
	public static boolean game(int x){
		boolean gewonnen = false;
		double random = Math.random() * 100;


		if(x > random){

			gewonnen=true;
		}

		return gewonnen;
	}

}
