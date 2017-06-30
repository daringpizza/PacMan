package Agar;

import apcs.Window;

public class Food {
	double x = Math.random() * Window.width();
	double y = Math.random() * Window.height();
	int r = Window.random(50, 255);
	int g = Window.random(50, 255);
	int b = Window.random(50, 255);
	
	int shimmer = Window.random(-50, 50);
	int ds = 15;
	public void draw() {
		Window.out.color(r+shimmer, g+shimmer, b+shimmer);
		Window.out.circle(x, y, 4);
		
		shimmer += ds;
		if(shimmer > 50 || shimmer < -50) {
			ds = -ds;
		}
	}
}
