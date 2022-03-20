package gui;

import javax.swing.JLabel;

import java.awt.Font;

class StatusLabel extends JLabel
{
	private final String aPlayerWhite = "White";
	private final String aPlayerBlack = "Black";
	private final String aToPlay = "Click a place to put a piece";
	private final String aNotToPlay = "Not your turn";

	private String aPrefix;
	private String aSuffix;

	public StatusLabel(int fontSize, Players preSel, boolean sufSel)
	{
		this.setFont(new Font("Serif", Font.PLAIN, fontSize));
		this.setPrefix(preSel);
		this.setSuffix(sufSel);

		this.setText(getPrefix() + " - " + getSuffix());
	}

	public StatusLabel(int fontSize)
	{
		this(fontSize, Players.WHITE, true);
	}

	public void setPrefix(Players selection)
	{
		if(selection == Players.WHITE)
			this.aPrefix = aPlayerWhite;
		else
			this.aPrefix = aPlayerBlack;
	}

	public String getPrefix()
	{
		return aPrefix;
	}

	public void setSuffix(boolean selection)
	{
		if(selection)
			this.aSuffix = aToPlay;
		else
			this.aSuffix = aNotToPlay;
	}

	public String getSuffix()
	{
		return aSuffix;
	}
}

