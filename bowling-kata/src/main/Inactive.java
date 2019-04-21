package main;

public class Inactive extends FrameState {

	public Inactive(Frame frame) {
		super(frame);
	}

	@Override
	public void throwBall(int pinsFelled) {
		
	}
	
	@Override
	public void nextState() {
		frame.setState(new Active(frame));
	}

}
