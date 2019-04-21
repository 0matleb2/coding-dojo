package main;

public class BowlingGame {
	
	int score;
	
	public BowlingGame() {
		score = 0;
	}
	
	public int getScore() {
		return score;
	}
	
	public void throwBall(int pinsFelled) {
		score += pinsFelled;
	}
}
