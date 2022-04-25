package gui;

import game.Players;

import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class GreedyButton extends JButton implements ActionListener
{
	final private Players aTeam;
	final private String aToPlayTxt;

	public GreedyButton(int fontSize, Players whoToPlay)
	{
		this.setFont(new Font("Serif", Font.PLAIN, fontSize));

		if(whoToPlay == Players.WHITE)
			this.aToPlayTxt = "Greedy AI (Play for White)";
		else
			this.aToPlayTxt = "Greedy AI (Play for Black)";

		this.setText(aToPlayTxt);

		this.aTeam = whoToPlay;

		addActionListener(this);
	}

	public GreedyButton(int fontSize)
	{
		this(fontSize, Players.WHITE);
	}

	public Players getTeam()
	{
		return this.aTeam;
	}

	public void listen(ActionListener main)
	{
		this.addActionListener(main);
	}

	private void onClick()
	{
		System.out.println(getTeam() + "'s Greedy AI was played...");
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// onClick();
	}
}

