package game;

class GreedyAI extends Validator
{
	final private Players aTeam;

	public GreedyAI(Players team)
	{
		aTeam = team;
	}

	public Players getTeam()
	{
		return this.aTeam;
	}

	public Move[] computeBestMove(Players[] boardState1D, Players[][] boardState2D, int boardSize) throws Exception
	{
		Move[] bestMoveSet = null;
		Move[] currentMoveSet;
		int bestMoveCaptures = 0;
		int currentMoveCaptures = 0;

		for(int i = 0; i < boardSize; ++i)
		{
			// Skip if there is a checker already placed:
			if(spaceIsTaken(boardState1D, i))
				continue;

			currentMoveSet = compileDirections(i, boardState2D, getTeam());

			// Work out how many pieces total this move captures:
			currentMoveCaptures = 0;
			for(int j = 0; j < 8; ++j)
			{
				currentMoveCaptures += currentMoveSet[j].getPiecesCaptured();
			}

			if(currentMoveCaptures > bestMoveCaptures)
			{
				bestMoveCaptures = currentMoveCaptures;
				bestMoveSet = currentMoveSet;
			}
		}

		// Throw an error if move could not be found:
		if(bestMoveSet == null)
			throw new Exception();

		return bestMoveSet;
	}
}

