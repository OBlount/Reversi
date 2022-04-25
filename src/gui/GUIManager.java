package gui;

import game.Players;

import javax.swing.JFrame;
import javax.swing.JComponent;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;

public class GUIManager
{

	private final int aHeight = 500;
	private final int aWidth = 450;
	private final Color GREEN = new Color(150, 255, 150);

	private JFrame frame1 = new JFrame();
	private Board board1 = new Board(GREEN, true);
	private StatusLabel topLabel1 = new StatusLabel(24, Players.WHITE, false);
	private GreedyButton AIButton1 = new GreedyButton(24);

	private JFrame frame2 = new JFrame();
	private Board board2 = new Board(GREEN, false);
	private StatusLabel topLabel2 = new StatusLabel(24);
	private GreedyButton AIButton2 = new GreedyButton(24, Players.BLACK);

	public void createGUI()
	{
		// White player's frame:
		frame1.setTitle("Reversi - White player");
		frame1.setLocation(500, 300);

		frame1.getContentPane().setLayout(new BorderLayout());
		frame1.getContentPane().add(board1, BorderLayout.CENTER);
		frame1.getContentPane().add(topLabel1, BorderLayout.PAGE_START);
		frame1.getContentPane().add(AIButton1, BorderLayout.PAGE_END);

		createGUIHelper(frame1);

		// Black player's frame:
		frame2.setTitle("Reversi - Black player");
		frame2.setLocation(1000, 300);

		frame2.getContentPane().setLayout(new BorderLayout());
		frame2.getContentPane().add(board2, BorderLayout.CENTER);
		frame2.getContentPane().add(topLabel2, BorderLayout.PAGE_START);
		frame2.getContentPane().add(AIButton2, BorderLayout.PAGE_END);

		createGUIHelper(frame2);
	}

	private void createGUIHelper(JFrame frame)
	{
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(aWidth, aHeight));
		frame.pack();
		frame.setVisible(true);
	}

	private void forceRefresh(JFrame frame)
	{
		frame.invalidate();
		frame.validate();
		frame.repaint();
	}

	public void listen(ActionListener main)
	{
		// Add listners to all game squares:
		board1.listen(main);
		board2.listen(main);

		// Add listeners to greedy buttons:
		AIButton1.listen(main);
		AIButton2.listen(main);
	}

	public void updateBoard(Players[] state)
	{
		board1.drawBoard(state);
		board2.drawBoard(state);
		forceRefresh(frame1);
		forceRefresh(frame2);
	}

	public int getButtonIDFromEventSource(JComponent source) throws Exception
	{
		int ID = board1.getButtonIDFromEventSource(source);

		if(ID != -1)
			return ID;

		else
			ID = board2.getButtonIDFromEventSource(source);

		if(ID != -1)
			return ID;

		else
			throw new Exception();
	}

	public Players getInteractedBoard(JComponent source) throws Exception
	{
		int ID = board1.getButtonIDFromEventSource(source);

		if(ID != -1)
			return Players.WHITE;

		else
			ID = board2.getButtonIDFromEventSource(source);

		if(ID != -1)
			return Players.BLACK;

		else
			throw new Exception();
	}

	public void setStatusLabel(Players toPlay)
	{
		if(toPlay == Players.WHITE)
		{
			topLabel1.setSuffix(true);
			topLabel2.setSuffix(false);
		}

		else
		{
			topLabel1.setSuffix(false);
			topLabel2.setSuffix(true);
		}
	}

	public Players greedyButtonIsPlayed(JComponent source)
	{
		if(source == AIButton1)
			return AIButton1.getTeam();

		if(source == AIButton2)
			return AIButton2.getTeam();

		else
			return Players.NONE;
	}

	public int getHeight()
	{
		return aHeight;
	}

	public int getWidth()
	{
		return aWidth;
	}
}

