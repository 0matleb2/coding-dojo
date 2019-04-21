package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
		game.throwBall(3);
		
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
		
		assertEquals(27, actual);
	}
	
	@Test
	void givenAStrikeOnFrame1_andBall2Fells8Pins_andBall3Fells1Pin_whenGetScore_thenReturn27() {
		
		game.throwBall(10);
		game.throwBall(8);
		game.throwBall(1);
		
		int actual = game.getScore();
		
		assertEquals(28, actual);
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
	
	@Test
	void givenAPerfectGame_whenGetScore_thenReturn300() {
		
		for (int i = 0; i < 12; ++i) {			
			game.throwBall(10);
		}
		
		int actual = game.getScore();
		
		assertEquals(300, actual);
	}
	
	@Test
	void givenGameIsOnLastFrame_andPerfectScoreSoFar_whenThrow10Fells9_andThrow11Fells1_andBonusThrow1Fells8_thenReturn277() {
		
		// 30, 30, 30, 30, 30, 30, 30, 29, 20, 18 
		
		for (int i = 0; i < 9; ++i) {	
			game.throwBall(10);
		}
		game.throwBall(9);
		game.throwBall(1);
		game.throwBall(8); // Bonus throw
		
		int actual = game.getScore();
		
		assertEquals(277, actual);
	}
	
	@Test
	void givenAFinishedGame_whenABallIsThrown_thenNoChangeInScore() {
		
		for (int i = 0; i < 12; ++i) {			
			game.throwBall(10);
		}
		
		int finalScore = game.getScore();
		
		game.throwBall(1);
		
		int actual = game.getScore();
		
		assertEquals(finalScore, actual);
	}

}
