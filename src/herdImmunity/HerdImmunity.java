package herdImmunity;

import apcs.Window;

public class HerdImmunity {
	// # of people
	public final static int herdSize = 1000;
	// % are immunized
	public static final double immunized = 0.95;
	// how contagious is an immunized person
	public static final double immunizedContagious = 0.001;
	// how contagious is a diseased person
	public static final double contagious = 0.1;
	public static final int recoveryTime = 300;
	
	public static void main(String[] args) {
		Window.setFrameRate(10000);
		Window.size(800, 600);
		Person[] people = new Person[herdSize];
		
		for(int i=0; i< people.length; i++) {
			people[i] = new Person();
		}
		
		people[0].infected = true;
			
		while(true) {
			Window.frame();
				
			for(Person p : people) {
				p.update();
				p.move();
				for(Person other : people) {
					if(p != other && p.isTouching(other)) {
						p.contactWith(other);
					}
				}
			}
		}
	}
}