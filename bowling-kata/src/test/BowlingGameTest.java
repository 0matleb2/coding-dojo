package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BowlingGameTest {
	
	BowlingGame game; 

	@BeforeEach
	void setUp() throws Exception {
		game = new BowlingGame();
	}

	@Test
	void given0BallsThrown_whenGetScore_return0() {
		fail("Not yet implemented");
	}

}
