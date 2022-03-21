package gui;

import javax.swing.JButton;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Graphics;

class ColourButton extends JButton
{
	private Color aDrawColour; 
	private int aID;

	public ColourButton(Color colour)
	{
		aDrawColour = colour;

		this.setLayout(new GridLayout(1, 1));
	}

	public Color getDrawColour()
	{
		return aDrawColour;
	}

	public void setDrawColour(Color drawColour)
	{
		this.aDrawColour = drawColour;
	}

	public int getID()
	{
		return aID;
	}

	public void setID(int id)
	{
		this.aID = id;
	}

	@Override
	protected void paintComponent(Graphics grph)
	{
		if (aDrawColour != null)
		{
			grph.setColor(aDrawColour);
			grph.fillRect(1, 1, getWidth() - 2, getHeight() - 2);
		}
	}
}

