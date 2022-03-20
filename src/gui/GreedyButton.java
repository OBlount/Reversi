package gui;

import javax.swing.JButton;

import java.awt.Font;

class GreedyButton extends JButton
{
	private String aToPlayTxt;

	public GreedyButton(int fontSize, Players whoToPlay)
	{
		this.setFont(new Font("Serif", Font.PLAIN, fontSize));

		if(whoToPlay == Players.WHITE)
			this.aToPlayTxt = "Greedy AI (Play for White)";
		else
			this.aToPlayTxt = "Greedy AI (Play for Black)";

		this.setText(aToPlayTxt);
	}
}

