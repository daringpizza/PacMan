package fruitNinja;

import java.util.ArrayList; 

import apcs.Window;


public class FruitNinja {
	public static void main(String[] args) {
		ArrayList <Fruit> fruits = new ArrayList <Fruit> ();
	final double gravity  = 0.8;
		fruits.add(new Fruit());
		fruits.add(new Watermelon());
		
		while(true) {
			Window.frame();
			if(Math.random() < 0.01) {
				fruits.add(new Watermelon()));
			}
			
			for(Fruit f : fruit) {
				f.draw();
				f.move();
			}
		}
	}
}
