import game.BoardState;
import game.Players;
import gui.GUIManager;

import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class Main implements ActionListener
{
	private BoardState gs = new BoardState();
	private GUIManager gm = new GUIManager();

	public static void main(String[] args)
	{
		Main program = new Main();
	}

	public Main()
	{
		gm.listen(this);
		gm.createGUI();
		gm.updateBoard(gs.getBoardState());
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		int ID;
		Players whoJustPlayed;

		try
		{
			ID = gm.getButtonIDFromEventSource((JComponent) e.getSource());
		}

		catch(Exception err)
		{
			System.out.println("[ERROR] Something went wrong when trying to find an ID");
			return;
		}

		try
		{
			whoJustPlayed = gm.getInteractedBoard((JComponent) e.getSource());
		}

		catch(Exception err)
		{
			System.out.println("[ERROR] Something went wrong getting whose turn");
			return;
		}

		if(!(gs.addChecker(ID, whoJustPlayed)))
			return;

		gm.updateBoard(gs.getBoardState());
		gs.advanceTurn();
		gm.setStatusLabel(gs.getToPlay());
	}
}

