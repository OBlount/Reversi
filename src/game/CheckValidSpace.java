package game;

class CheckValidSpace
{
	protected boolean spaceIsTaken(Players[] boardState, int spaceID)
	{
		if(boardState[spaceID] != Players.NONE)
			return true;

		else
			return false;
	}
}

