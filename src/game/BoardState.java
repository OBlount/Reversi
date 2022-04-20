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

	public void addChecker(int ID)
	{
		aBoardStateArray[ID] = getToPlay();
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

