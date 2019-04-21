package main;

public class Active extends FrameState {
	
	int throwsRemaining = 2;
	int pinsFelled = 0;
	
	public Active(Frame frame) {
		super(frame);
	}

	@Override
	public void throwBall(int pinsFelled) {
		--throwsRemaining;
		this.pinsFelled += pinsFelled;
		frame.addToScore(pinsFelled);
		nextState();
	}
	
	@Override
	public void nextState() {
		if (throwsRemaining == 0 && pinsFelled == 10) {			
			frame.setState(new Spare(frame));
			frame.activateNextFrame();
		}
	}
}
