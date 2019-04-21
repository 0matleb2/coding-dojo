package main;

public abstract class FrameState {
	
	Frame frame;
	
	public FrameState(Frame frame) {
		this.frame = frame;
	}
	
	public abstract void throwBall(int pinsFelled);
	abstract void nextState();
}
