package main;

public class Frame {
	
	int score;
	FrameState state;
	Frame next;
	
	public Frame(Frame next) {
		score = 0;
		state = new Inactive(this);
		this.next = next;
	}
	
	public void addToScore(int score) {
		this.score += score;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setState(FrameState state) {
		this.state = state;
	}
	
	public void activateNextFrame() {
		if (next != null) {			
			next.setState(new Active(next));
		}
	}

	public void throwBall(int pinsFelled) {
		state.throwBall(pinsFelled);
	}	
}
