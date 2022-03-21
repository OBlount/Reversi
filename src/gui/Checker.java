package gui;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Graphics;

class Checker extends JLabel
{
	private final Color aWhiteCheckerColour = new Color(255, 255, 255);
	private final Color aBlackCheckerColour = new Color(0, 0, 0);

	private Players aPlayer;
	private Color aPlayerColour;

	public Checker(Players playerType)
	{
		this.setPlayerType(playerType);
	}

	public void setPlayerType(Players playerType)
	{
		this.aPlayer = playerType;

		if(getPlayerType() == Players.WHITE)
			this.aPlayerColour = aWhiteCheckerColour;
		else
			this.aPlayerColour = aBlackCheckerColour;
	}

	public Players getPlayerType()
	{
		return aPlayer;
	}

	public void flipPlayerType()
	{
		if(getPlayerType() == Players.WHITE)
			this.setPlayerType(Players.BLACK);
		else
			this.setPlayerType(Players.WHITE);
	}

	@Override
	protected void paintComponent(Graphics grph)
	{
		if (aPlayerColour != null)
		{
			grph.setColor(aPlayerColour);
			grph.fillOval(0, 8, 20, 20);
		}
	}
}

