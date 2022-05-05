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
		// Game start up:
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
		gm.updateBoard(gs.getBoardState());
		gs.advanceTurn();
		gm.setStatusLabel(gs.getToPlay());

		// If spaces aren't available, then check 'end game' condition:
		if(!(gs.checkIfAnySpacesAreValid()))
		{
			gs.advanceTurn();
			gm.setStatusLabel(gs.getToPlay());

			// End game if there are no valid spaces, even after an advance:
			if(!(gs.checkIfAnySpacesAreValid()))
			{
				displayScores();
				gs.endGame();
				gm.setStatusLabel(gs.getToPlay());
				gm.updateBoard(gs.getBoardState());
			}
		}
	}

	private void displayScores()
	{
		int[] results = gs.getScores();

		if(results[0] == results[1])
			gm.onEndGame(Players.NONE, results[0], results[1]);

		else if(results [0] > results[1])
			gm.onEndGame(Players.WHITE, results[0], results[1]);

		else
			gm.onEndGame(Players.BLACK, results[0], results[1]);
	}
}

