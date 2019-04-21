package main;

public class Spare extends FrameState {

	public Spare(Frame frame) {
		super(frame);
	}

	@Override
	public void throwBall(int pinsFelled) {
		frame.addToScore(pinsFelled);
		nextState();
	}
	
	@Override
	public void nextState() {
		frame.setState(new Inactive(frame));
	}
}
