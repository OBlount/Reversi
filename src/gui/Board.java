package gui;

import javax.swing.JPanel;
import javax.swing.JComponent;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class Board extends JPanel implements ActionListener
{
	private final int aRows = 8;
	private final int aCols = 8;

	private Color aGridColour;
	private ColourButton[] aArrayButtons = new ColourButton[aRows * aCols];

	public Board(Color gridColour, boolean reverseLook)
	{
		this.aGridColour = gridColour;
		this.setLayout(new GridLayout(aRows, aCols));

		// Populate aArrayButtons and add them to the panel:
		if(!(reverseLook))
		{
			for(int i = 0; i < (aRows * aCols); ++i)
			{
				this.populateButtonsArray(i);
			}
		}

		else
		{
			for(int i = 63; i >= 0; --i)
			{
				this.populateButtonsArray(i);
			}
		}
	}

	public void setGridColour(Color gridColour)
	{
		this.aGridColour = gridColour;
	}

	public Color getGridColour()
	{
		return this.aGridColour;
	}

	private void populateButtonsArray(int i)
	{
		aArrayButtons[i] = new ColourButton(getGridColour());
		aArrayButtons[i].setID(i);

		// Create the starting board:
		if(aArrayButtons[i].getID() == 27 || aArrayButtons[i].getID() == 36)
			aArrayButtons[i].add(new Checker(Players.WHITE));

		if(aArrayButtons[i].getID() == 28 || aArrayButtons[i].getID() == 35)
			aArrayButtons[i].add(new Checker(Players.BLACK));

		aArrayButtons[i].addActionListener(this);
		this.add(aArrayButtons[i]);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		JComponent source = (JComponent) e.getSource();
		for(ColourButton butt : aArrayButtons)
		{
			if(source == butt)
				System.out.println("Square ID: " + butt.getID());
		}
	}
}

