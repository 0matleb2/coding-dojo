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
	void given0BallsThrown_whenGetScore_thenReturn0() {
		
		int actual = game.getScore();
		
		assertEquals(0, actual);
	}
	
	@Test
	void givenBall1Fells9Pins_whenGetScore_thenReturn9() {
		
		game.throwBall(9);
		
		int actual = game.getScore();
		
		assertEquals(9, actual);
	}
	
	@Test
	void givenBall1Fells3Pins_andBall2Fells5Pins_whenGetScore_thenReturn8() {
		
		game.throwBall(3);
		game.throwBall(5);
		
		int actual = game.getScore();
		
		assertEquals(8, actual);
	}
	
	@Test
	void givenBall1Fells7Pins_andBall2Fells0Pins_whenGetScore_thenReturn7() {
		
		game.throwBall(7);
		game.throwBall(0);
		
		int actual = game.getScore();
		
		assertEquals(7, actual);
	}
	
	@Test
	void givenASpareOnFrame1_whenGetScore_thenReturn10() {
		
		game.throwBall(7);
		game.throwBall(0);
		
		int actual = game.getScore();
		
		assertEquals(10, actual);
	}
	
	@Test
	void givenAStrikeOnFrame1_whenGetScore_thenReturn10() {
		
		game.throwBall(10);
		
		int actual = game.getScore();
		
		assertEquals(10, actual);
	}
	
	@Test
	void givenASpareOnFrame1_andBall3Fells8Pins_andBall4Fells1Pin_whenGetScore_thenReturn26() {
		
		game.throwBall(7);
		game.throwBall(3);
		game.throwBall(8);
		game.throwBall(1);
		
		int actual = game.getScore();
		
		assertEquals(26, actual);
	}
	
	@Test
	void givenAStrikeOnFrame1_andBall2Fells8Pins_andBall3Fells1Pin_whenGetScore_thenReturn27() {
		
		game.throwBall(10);
		game.throwBall(8);
		game.throwBall(1);
		
		int actual = game.getScore();
		
		assertEquals(27, actual);
	}
	
	@Test
	void givenAStrikeOnFrame1_andASpareOnFrame2_andBall4Fells5Pins_whenGetScore_thenReturn40() {
		
		game.throwBall(10);
		game.throwBall(8);
		game.throwBall(2);
		game.throwBall(5);
		
		int actual = game.getScore();
		
		assertEquals(40, actual);
	}
	
	@Test
	void givenAStrikeOnFrame1_andAStrikeOnFrame2_andBall3Fells5Pins_andBall4Fells4Pins_whenGetScore_thenReturn53() {
		
		game.throwBall(10);
		game.throwBall(10);
		game.throwBall(5);
		game.throwBall(4);
		
		int actual = game.getScore();
		
		assertEquals(53, actual);
	}

}
