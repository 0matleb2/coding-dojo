package main;

import java.util.Arrays;
import java.util.List;

public class BowlingGame {
	
	List<Frame> frames;
	
	public BowlingGame() {
		Frame frame10 = new Frame(null);
		Frame frame9 = new Frame(frame10);
		Frame frame8 = new Frame(frame9);
		Frame frame7 = new Frame(frame8);
		Frame frame6 = new Frame(frame7);
		Frame frame5 = new Frame(frame6);
		Frame frame4 = new Frame(frame5);
		Frame frame3 = new Frame(frame4);
		Frame frame2 = new Frame(frame3);
		Frame frame1 = new Frame(frame2);
		
		frames = Arrays.asList(
				frame1, frame2, frame3, frame4, frame5,
				frame6, frame7, frame8, frame9, frame10
				);
		
		Frame firstFrame = frames.get(0);
		firstFrame.setState(new Active(firstFrame));
	}
	
	public int getScore() {
		return frames.stream().mapToInt(frame -> frame.getScore()).sum();
	}
	
	public void throwBall(int pinsFelled) {
		for (int i = frames.size() - 1; i >= 0; --i) {
			frames.get(i).throwBall(pinsFelled);
		}
	}
}
