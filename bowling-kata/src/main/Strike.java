package main;

public class Strike extends FrameState {
	
	int throwsRemaining = 2;

	public Strike(Frame frame) {
		super(frame);
	}

	@Override
	public void throwBall(int pinsFelled) {
		--throwsRemaining;
		frame.addToScore(pinsFelled);
		nextState();
	}

	@Override
	void nextState() {
		if (throwsRemaining == 0) {			
			frame.setState(new Inactive(frame));
		}
	}

}
