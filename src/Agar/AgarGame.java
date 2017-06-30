package Agar;
import apcs.Window;
import java.util.ArrayList;

public class AgarGame {
	public static void main(String[] args) {
		Window.size(1000, 800);
		ArrayList<Agar> agarList = new  ArrayList<Agar>();
		ArrayList<Food> foodList = new ArrayList <Food> ();
		
		Agar a = new Agar();
		agarList.add(a);
		
		for(int i = 0; i< 10; i++) {
			agarList.add(new Agar());
		}
		
		for(int j = 0; j< 100; j++) {
			foodList.add(new Food());
		}
		
		// Infinite Loop
		while(true){
			Window.frame();
			
			if(Math.random() < 0.01) {
				agarList.add(new Agar());
			}
			
			a.control();
			
			for(Agar ag: agarList) {
				ag.draw();
				ag.move();
				for(int i = 0 ; i < foodList.size(); i++) {
					Food f = foodList.get(i);
				
					if(ag.isEating(f)) {
						ag.eat(f);
						foodList.remove(i);
						foodList.add(new Food());
					}
				}
			}
			for(Food food : foodList) {
				food.draw();
				
			}
		}
				
	}
}