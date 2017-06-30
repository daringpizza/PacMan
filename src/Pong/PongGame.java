package Pong;
import apcs.Window;

public class PongGame{
	public static void main(String[] args) {
		Window.size(800, 600);
		
		Ball ball = new Ball();
		Paddle paddle1 = new Paddle(50, "w", "s");
		Paddle paddle2 = new Paddle(750, "up", "down");
		
		while(true) {
			Window.frame();
			
			ball.draw();
			ball.move();
			
			paddle1.draw();
			paddle1.move();
			
			paddle2.draw();
			paddle2.move();
			
			if(ball.isTouching(paddle1)) {
				ball.bounceHorizontally(paddle1);
			}
			if(ball.isTouching(paddle2)) {
				ball.bounceHorizontally(paddle2);
			}
		}
	}
}