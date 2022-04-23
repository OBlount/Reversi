package game;

class Move
{
	final private int aBoardSize = 8 * 8;
	final private int aOrigin;
	final private int aXDirection;
	final private int aYDirection;
	final private int aPiecesCaptured;
	final private int aNextSpace;
	final private boolean aIsValid;

	public Move(int spaceID, int xOffset, int yOffset, int pieces)
	{
		aOrigin = spaceID;
		aXDirection = xOffset;
		aYDirection = yOffset;
		aPiecesCaptured = pieces;
		aNextSpace = computeNextSpace();
		aIsValid = computeValidity();
	}

	public int getOrigin()
	{
		return this.aOrigin;
	}

	public int getXDirection()
	{
		return this.aXDirection;
	}

	public int getYDirection()
	{
		return this.aYDirection;
	}

	public int getPiecesCaptured()
	{
		return this.aPiecesCaptured;
	}

	public int getNextSpace()
	{
		return this.aPiecesCaptured;
	}

	public boolean isValid()
	{
		return this.aIsValid;
	}

	private int computeNextSpace()
	{
		int nextSpace;

		try
		{
			nextSpace = getOrigin() + (getXDirection()) + (getYDirection() * ((int) Math.sqrt(aBoardSize)));
		}

		catch(ArrayIndexOutOfBoundsException err)
		{
			nextSpace = Integer.MIN_VALUE;
		}

		return nextSpace;
	}

	private boolean computeValidity()
	{
		if(getPiecesCaptured() != 0)
			return true;

		else
			return false;
	}
}

