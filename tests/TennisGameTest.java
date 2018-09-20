import static org.junit.Assert.*;

import org.junit.Test;

import jdk.nashorn.internal.ir.annotations.Ignore;

public class TennisGameTest {
	
// Here is the format of the scores: "player1Score - player2Score"
// "love - love"
// "15 - 15"
// "30 - 30"
// "deuce"
// "15 - love", "love - 15"
// "30 - love", "love - 30"
// "40 - love", "love - 40"
// "30 - 15", "15 - 30"
// "40 - 15", "15 - 40"
// "player1 has advantage"
// "player2 has advantage"
// "player1 wins"
// "player2 wins"
	@Test
	public void testTennisGame_Start() {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Initial score incorrect", "love - love", score);		
	}
	
	@Test
	public void testTennisGame_even1() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		game.player1Scored();
		game.player2Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Score deuce 1-1", "15 - 15", score);		
	}
	
	@Test
	public void testTennisGame_even2() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Score even 2-2", "30 - 30", score);		
	}
	
	@Test
	public void testTennisGame_1love() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		game.player1Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Score 1-0", "15 - love", score);		
	}
	
	@Test
	public void testTennisGame_love1() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		game.player2Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Score 0-1", "love - 15", score);		
	}
	
	@Test
	public void testTennisGame_2love() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		game.player1Scored();
		game.player1Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Score 2-0", "30 - love", score);		
	}
	
	@Test
	public void testTennisGame_love2() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		game.player2Scored();
		game.player2Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Score 0-2", "love - 30", score);		
	}
	
	@Test
	public void testTennisGame_3love() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Score 3-0", "40 - love", score);		
	}
	
	@Test
	public void testTennisGame_love3() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Score 3-0", "love - 40", score);		
	}
	
	@Test
	public void testTennisGame_21() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Score 2-1", "30 - 15", score);		
	}
	
	@Test
	public void testTennisGame_12() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Score 1-2", "15 - 30", score);
	}
	
	@Test
	public void testTennisGame_13() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Score 1-3", "15 - 40", score);	
	}
	
	@Test
	public void testTennisGame_31() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Score 3-1, ", "40 - 15", score);	
	}
	
	@Test
	public void testTennisGame_43() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();

		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Score 4-3", "player1 has advantage", score);	
		}
	
	@Test	
	public void testTennisGame_34() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Score 3-4", "player2 has advantage", score);	
		}
	
	@Test	
	public void testTennisGame_deuceAfterAdvantage2() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player1Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Score 4-4", "deuce", score);	
		}
	
	@Test	
	public void testTennisGame_deuceAfterAdvantage1() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player2Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Score 4-4", "deuce", score);	
		}
		
		
	@Test
	public void testTennisGame_EahcPlayerWin4Points_Score_Deuce() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player1Scored();
		game.player2Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Tie score incorrect", "deuce", score);		
	}
	
	@Test (expected = TennisGameException.class)
	public void testTennisGame_Player1WinsPointAfterGameEnded_ResultsException() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		//Act
		// This statement should cause an exception
		game.player1Scored();
	}		
}
