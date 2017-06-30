package BubblePop;

import java.util.ArrayList;

import apcs.Window;

public class BubblePopGame {
	public static void main(String[] args) {
		Window.size(600, 800);
		ArrayList <Bubbles> bubbles = new ArrayList <Bubbles> ();
		
		bubbles.add(new Bubbles());
		bubbles.add(new NormalBubble());
		bubbles.add(new StrongBubble());
		bubbles.add(new BoomBubble());
		
		while(true) {
			Window.frame();
			if(Math.random() < 0.01) {
				bubbles.add(new NormalBubble());
			}
			if(Math.random() < 0.01) {
				bubbles.add(new StrongBubble());
			}
			if(Math.random() < 0.01) {
				bubbles.add(new BoomBubble());
			}
			
			for(Bubbles b : bubbles) {
				b.draw();
				b.move();
			}
		}
	}
}