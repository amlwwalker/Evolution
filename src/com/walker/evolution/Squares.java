package com.walker.evolution;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

class Squares extends JPanel {
   private static final int PREF_W = 500;
   private static final int PREF_H = PREF_W;
   private List<Rectangle> squares = new ArrayList<Rectangle>();
   private Color tempColor;
   public void addSquare(int x, int y, int width, int height, Color color) {
	   tempColor = color;
      Rectangle rect = new Rectangle(x, y, width, height);
      squares.add(rect);
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      for (Rectangle rect : squares) {
    	  g2.setColor(tempColor);
//         g2.draw(rect);
         g2.fillRect(rect.x, rect.y, rect.width, rect.height);
      }
   }

}