package game;

class Validator
{
	protected boolean spaceIsTaken(Players[] boardState, int spaceID)
	{
		if(boardState[spaceID] != Players.NONE)
			return true;

		else
			return false;
	}

	protected Move[] compileDirections(int spaceID, Players[][] boardState, Players toPlay)
	{
		Move[] moveSets = new Move[8];
		int index = 0;
		int pieces;
		int x = spaceID % 8;
		int y = spaceID / 8;
		Players capturingPiece;

		// Compute which piece type is for capture:
		if(toPlay == Players.WHITE)
			capturingPiece = Players.BLACK;

		else
			capturingPiece = Players.WHITE;

		// Cycle through all directions:
		for(int yOffset = -1; yOffset <= 1; ++yOffset)
		{
			for(int xOffset = -1; xOffset <= 1; ++xOffset)
			{
				// Skip offset (0, 0):
				if(xOffset == 0 && yOffset == 0)
					continue;

				pieces = countPiecesTaken(x, y, boardState, xOffset, yOffset, capturingPiece, x, y);
				Move mv = new Move(spaceID, xOffset, yOffset, pieces);
				moveSets[index++] = mv;
			}
		}

		return moveSets;
	}

	private int countPiecesTaken(int x, int y, Players[][] boardState, int xDirection, int yDirection, Players capture, int originX, int originY)
	{
		int pieces = 0;
		int nextX = x + xDirection;
		int nextY = y + yDirection;
		Players nextSpace;

		// If at the edge of the board:
		try
		{
			nextSpace = boardState[nextY][nextX];
		}

		catch(ArrayIndexOutOfBoundsException err)
		{
			nextSpace = Players.NONE;
		}

		// If valid capture, call itself:
		if(nextSpace == capture)
		{
			pieces++;
			pieces += countPiecesTaken(nextX, nextY, boardState, xDirection, yDirection, capture, originX, originY);
		}

		// Once found friendly counter, return itself back:
		else if(nextSpace != Players.NONE)
			return pieces;

		// If invalid capture, return 0;
		else
		{
			int distance = findDistance(x, y, originX, originY, -(xDirection), -(yDirection));
			return -(distance);
		}

		return pieces;
	}

	private int findDistance(int currentX, int currentY, int originX, int originY, int xDirection, int yDirection)
	{
		int count = 0;

		while(currentX != originX || currentY != originY)
		{
			count++;
			currentX += xDirection;
			currentY += yDirection;
		}

		return count;
	}
}

