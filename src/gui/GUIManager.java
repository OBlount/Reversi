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

	private JFrame guiFrame = new JFrame();
	private Board board1 = new Board(GREEN);
	private StatusLabel topLabel1 = new StatusLabel(24);
	private GreedyButton AIButton1 = new GreedyButton(24);

	public void createGUI()
	{
		guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		guiFrame.setTitle("Reversi");
		guiFrame.setPreferredSize(new Dimension(aWidth, aHeight));

		guiFrame.getContentPane().setLayout(new BorderLayout());
		guiFrame.getContentPane().add(board1, BorderLayout.CENTER);
		guiFrame.getContentPane().add(topLabel1, BorderLayout.PAGE_START);
		guiFrame.getContentPane().add(AIButton1, BorderLayout.PAGE_END);

		guiFrame.pack();
		guiFrame.setLocationRelativeTo(null);
		guiFrame.setVisible(true);
	}
}

