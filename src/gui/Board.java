package gui;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.GridLayout;

class Board extends JPanel
{
	private final int aRows = 8;
	private final int aCols = 8;
	private final int aSquareBorder = 1;
	private final Color BLACK = new Color(0, 0, 0);

	private Color aGridColour;
	private ColourButton[] aArrayButtons = new ColourButton[aRows * aCols];

	public Board(Color gridColour)
	{
		this.aGridColour = gridColour;
		this.setLayout(new GridLayout(aRows, aCols));

		// Populate aArrayButtons and add them to the panel:
		for(int i = 0; i < (aRows * aCols); ++i)
		{
			aArrayButtons[i] = new ColourButton(gridColour, aSquareBorder, BLACK);
			this.add(aArrayButtons[i]);
		}
	}

	public void setGridColour(Color gridColour)
	{
		this.aGridColour = gridColour;
	}

	public Color  getGridColour()
	{
		return this.aGridColour;
	}
}

