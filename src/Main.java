import game.BoardState;
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

		try
		{
			ID = gm.getButtonIDFromEventSource((JComponent) e.getSource());
		}

		catch(Exception err)
		{
			System.out.println("[ERROR] Something went wrong when trying to find an ID");
			return;
		}

		gs.addChecker(ID);
		gm.updateBoard(gs.getBoardState());
		gs.advanceTurn();
	}
}

