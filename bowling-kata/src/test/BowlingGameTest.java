package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.BowlingGame;

class BowlingGameTest {
	
	BowlingGame game; 

	@BeforeEach
	void setUp() throws Exception {
		game = new BowlingGame();
	}

	@Test
	void given0BallsThrown_whenGetScore_return0() {
		
		int actual = game.getScore();
		
		assertEquals(0, actual);
	}

}
