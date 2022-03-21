package gui;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;

public class GUIManager
{

	private final int aHeight = 500;
	private final int aWidth = 450;
	private final Color GREEN = new Color(150, 255, 150);

	private JFrame frame1 = new JFrame();
	private Board board1 = new Board(GREEN, false);
	private StatusLabel topLabel1 = new StatusLabel(24);
	private GreedyButton AIButton1 = new GreedyButton(24);

	private JFrame frame2 = new JFrame();
	private Board board2 = new Board(GREEN, true);
	private StatusLabel topLabel2 = new StatusLabel(24, Players.BLACK, false);
	private GreedyButton AIButton2 = new GreedyButton(24, Players.BLACK);

	public void createGUI()
	{
		// White player's frame:
		frame1.setTitle("Reversi - White player");

		frame1.getContentPane().setLayout(new BorderLayout());
		frame1.getContentPane().add(board1, BorderLayout.CENTER);
		frame1.getContentPane().add(topLabel1, BorderLayout.PAGE_START);
		frame1.getContentPane().add(AIButton1, BorderLayout.PAGE_END);

		createGUIHelper(frame1);

		// Black player's frame:
		frame2.setTitle("Reversi - Black player");

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
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
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

