package gui;

import javax.swing.JButton;

import java.awt.Color;
import java.awt.Graphics;

class ColourButton extends JButton
{
	Color aDrawColour; 
	Color aBorderColour;
	int aBorderSize; 

	public ColourButton(Color colour, int borderWidth, Color borderColour)
	{
		aBorderSize = borderWidth;
		aDrawColour = colour;
		aBorderColour = borderColour;
	}

	public Color getDrawColour()
	{
		return aDrawColour;
	}

	public void setDrawColour(Color drawColour)
	{
		this.aDrawColour = drawColour;
	}

	public Color getBorderColour()
	{
		return aBorderColour;
	}

	public void setBorderColour(Color borderColour)
	{
		this.aBorderColour = borderColour;
	}

	public int getBorderSize()
	{
		return aBorderSize;
	}

	public void setBorderSize(int borderSize)
	{
		this.aBorderSize = borderSize;
	}

	protected void paintComponent(Graphics grph)
	{
		if (aBorderColour != null)
		{
			grph.setColor(aBorderColour);
			grph.fillRect(0, 0, getWidth(), getHeight());
		}
		if (aDrawColour != null)
		{
			grph.setColor(aDrawColour);
			grph.fillRect(aBorderSize, aBorderSize, getWidth() - aBorderSize * 2, getHeight() - aBorderSize * 2);
		}
	}
}

