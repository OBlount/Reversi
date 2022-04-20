package gui;

import game.Players;

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

	public void drawBoard(Players[] boardState)
	{
		int j = 0;

		for(int i = 0; i < (aRows * aCols); ++i)
			aArrayButtons[i].removeAll();

		for(Players state : boardState)
		{
			if(state == Players.NONE)
			{
				j++;
				continue;
			}

			else
				aArrayButtons[j++].add(new Checker(state));
		}
	}

	public void listen(ActionListener main)
	{
		for(ColourButton butt : aArrayButtons)
		{
			butt.addActionListener(main);
		}
	}

	public int getButtonIDFromEventSource(JComponent source)
	{
		for(ColourButton butt : aArrayButtons)
		{
			if(source == butt)
				return butt.getID();
		}

		return -1;
	}

	private void populateButtonsArray(int i)
	{
		aArrayButtons[i] = new ColourButton(getGridColour());
		aArrayButtons[i].setID(i);
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

