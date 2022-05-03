package gui;

import game.Players;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;

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
		return this.aPlayer;
	}

	public void flipPlayerType()
	{
		if(getPlayerType() == Players.WHITE)
			this.setPlayerType(Players.BLACK);
		else
			this.setPlayerType(Players.WHITE);
	}

	@Override
	protected void paintComponent(Graphics g)
	{
		if (aPlayerColour != null)
		{
			Graphics2D grph = (Graphics2D) g;
			grph.setStroke(new BasicStroke(3));

			if(getPlayerType() == Players.WHITE)
				grph.setColor(aBlackCheckerColour);

			else
				grph.setColor(aWhiteCheckerColour);

			grph.drawOval(0, 8, 20, 20);
			grph.setColor(aPlayerColour);
			grph.fillOval(0, 8, 20, 20);
		}
	}
}

