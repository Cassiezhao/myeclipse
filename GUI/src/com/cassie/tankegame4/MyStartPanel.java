package com.cassie.tankegame4;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class MyStartPanel extends JPanel implements Runnable{
	int times = 0;
	public void paint(Graphics g) 
	{
		super.paint(g);
		g.fillRect(0, 0, 400, 400);
		if (times % 2 == 0) 
		{
			g.setColor(Color.yellow);
			Font myFont = new Font("华文新魏", Font.BOLD, 30);
			g.setFont(myFont);
			g.drawString("stage : 1", 140, 180);
		}
	
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while (true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			times++;
			this.repaint();
		}
	}
}
