package game;

import java.lang.Math;

public class BoardState
{
	private final int aBoardSize = 8 * 8;

	private Players[] aBoardStateArray = new Players[aBoardSize];
	private Players aToPlay = Players.BLACK;

	public BoardState()
	{
		setBoard();
	}

	public Players[] getBoardState()
	{
		return aBoardStateArray;
	}

	public int getBoardSize()
	{
		return this.aBoardSize;
	}

	public Players getToPlay()
	{
		return this.aToPlay;
	}

	public void setToPlay(Players toPlay)
	{
		this.aToPlay = toPlay;
	}

	// Returns TRUE if the checker was added, FALSE if space was invalid:
	public boolean addChecker(int spaceID, Players whoPlayed)
	{
		boolean captured = false;
		Validator validator = new Validator();
		Move[] moveSets;

		// Check if it's player's turn to play:
		if(whoPlayed != getToPlay())
			return false;

		// Check if the space is already taken:
		if(validator.spaceIsTaken(getBoardState(), spaceID))
			return false;

		// Capture appropriate checkers:
		moveSets = validator.compileDirections(spaceID, convertTo2D(), getToPlay());
		for(int i = 0; i < 8; ++i)
		{
			if(!(moveSets[i].isValid()))
				continue;

			for(int j = 0; j <= moveSets[i].getPiecesCaptured(); ++j)
			{
				int offset = ((moveSets[i].getXDirection() * j) + (((int) Math.sqrt(aBoardSize) * moveSets[i].getYDirection()) * j));
				aBoardStateArray[spaceID + offset] = getToPlay();
				captured = true;
			}
		}

		return captured;
	}

	public void advanceTurn()
	{
		if(aToPlay == Players.WHITE)
			aToPlay = Players.BLACK;

		else
			aToPlay = Players.WHITE;
	}

	public boolean checkIfAnySpacesAreValid()
	{
		Validator validator = new Validator();

		return validator.checkIfAnySpacesAreValid(getBoardState(), convertTo2D(), getToPlay(), getBoardSize());
	}

	// Returns an array where: arr[0] is White's score | arr[1] is Black's score:
	public int[] getScores()
	{
		int[] scores = new int[2];
		Players[] state = getBoardState();
		int whiteScore = 0;
		int blackScore = 0;

		for(int i = 0; i < getBoardSize(); ++i)
		{
			if(state[i] == Players.WHITE)
				whiteScore++;

			else if(state[i] == Players.BLACK)
				blackScore++;
		}

		scores[0] = whiteScore;
		scores[1] = blackScore;

		return scores;
	}

	public void endGame()
	{
		setBoard();
		setToPlay(Players.BLACK);
	}

	public boolean playGreedyAI(Players whoPlayed)
	{
		boolean isPlayed;
		GreedyAI AI;
		Move selectedMove[];

		// Skip if it isn't their turn:
		if(whoPlayed != getToPlay())
			return false;

		AI = new GreedyAI(whoPlayed);

		try
		{
			selectedMove = AI.computeBestMove(getBoardState(), convertTo2D(), getBoardSize());
		}

		catch(Exception err)
		{
			System.out.println("[ERROR] Could not find best move");
			return false;
		}

		// Try to add this best move:
		isPlayed = addChecker(selectedMove[0].getOrigin(), whoPlayed);
		return isPlayed;
	}

	protected Players[][] convertTo2D()
	{
		int sqrt = (int) Math.sqrt(aBoardSize);
		Players[] boardState1D = getBoardState();
		Players[][] boardState2D = new Players[sqrt][sqrt];

		for(int i = 0; i < sqrt; ++i)
		{
			for(int j = 0; j < sqrt; ++j)
			{
				boardState2D[i][j] = boardState1D[((i * sqrt) + j)];
			}
		}

		return boardState2D;
	}

	private void setBoard()
	{
		for(int i = 0; i < aBoardSize; ++i)
		{
			aBoardStateArray[i] = Players.NONE;
		}

		// Prepare the board with the starting pieces:
		aBoardStateArray[27] = Players.WHITE;
		aBoardStateArray[28] = Players.BLACK;
		aBoardStateArray[35] = Players.BLACK;
		aBoardStateArray[36] = Players.WHITE;
	}

	private void printBoard2D()
	{
		int sqrt = (int) Math.sqrt(aBoardSize);
		Players[][] boardState2D = convertTo2D();

		for(int i = 0; i < sqrt; ++i)
		{
			for(int j = 0; j < sqrt; ++j)
			{
				System.out.print("\t" + boardState2D[i][j]);
			}

			System.out.print("\n\r");
		}
	}
}

