package game;

public class BoardState
{
	private final int aBoardSize = 8 * 8;

	private Players[] aBoardStateArray = new Players[aBoardSize];
	private Players aToPlay = Players.WHITE;

	public BoardState()
	{
		for(int i = 0; i < aBoardSize; ++i)
			aBoardStateArray[i] = Players.NONE;

		// Prepare the board with the starting pieces:
		aBoardStateArray[27] = Players.WHITE;
		aBoardStateArray[28] = Players.BLACK;
		aBoardStateArray[35] = Players.BLACK;
		aBoardStateArray[36] = Players.WHITE;
	}

	public Players[] getBoardState()
	{
		return aBoardStateArray;
	}

	public Players getToPlay()
	{
		return this.aToPlay;
	}

	// Returns TRUE if the checker was added, FALSE if not valid:
	public boolean addChecker(int ID, Players whoPlayed)
	{
		CheckValidSpace checker = new CheckValidSpace();

		// Check if it's player's turn to play:
		if(whoPlayed != getToPlay())
			return false;

		// Check if the space is already taken:
		if(checker.spaceIsTaken(getBoardState(), ID))
			return false;

		aBoardStateArray[ID] = getToPlay();
		return true;
	}

	public void advanceTurn()
	{
		if(aToPlay == Players.WHITE)
			aToPlay = Players.BLACK;

		else
			aToPlay = Players.WHITE;
	}

	private void clearBoard()
	{
		for(int i = 0; i < aBoardSize; ++i)
			aBoardStateArray[i] = Players.NONE;
	}
}

