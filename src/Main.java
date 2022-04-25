import game.BoardState;
import gui.GUIManager;
import game.Players;

import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class Main implements ActionListener
{
	private BoardState gs = new BoardState();
	private GUIManager gm = new GUIManager();

	public static void main(String[] args)
	{
		Main game = new Main();
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
		Players isGreedyPlaying;

		// If greedyAI is played:
		isGreedyPlaying = gm.greedyButtonIsPlayed((JComponent) e.getSource());
		if(isGreedyPlaying != Players.NONE)
		{
			if(gs.playGreedyAI(isGreedyPlaying))
				advanceTurn();

			return;
		}

		try
		{
			ID = gm.getButtonIDFromEventSource((JComponent) e.getSource());
			whoJustPlayed = gm.getInteractedBoard((JComponent) e.getSource());
		}

		catch(Exception err)
		{
			System.out.println("[ERROR] Something went wrong when trying to find an ID and/or whose turn");
			return;
		}

		// Check if the space selected is invalid:
		if(!(gs.addChecker(ID, whoJustPlayed)))
			return;

		advanceTurn();
	}

	private void advanceTurn()
	{
		this.gm.updateBoard(gs.getBoardState());
		this.gs.advanceTurn();
		this.gm.setStatusLabel(gs.getToPlay());

		// If spaces aren't available, then check 'end game' condition:
		if(!(gs.checkIfAnySpacesAreValid()))
		{
			gs.advanceTurn();

			// End game if there are no valid spaces, even after an advance:
			if(!(gs.checkIfAnySpacesAreValid()))
				gs.endGame();
		}
	}
}

