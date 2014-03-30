package com.walker.evolution;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Frame extends JFrame{

	JPanel panel;
	List<JLabel> labels;
	private Squares squares;
	public Frame(){
		panel = new JPanel();
		labels = new ArrayList<JLabel>();
		this.add(panel);
		
		 squares = new Squares();
	      getContentPane().add(squares);
//	      for (int i = 0; i < 15; i++) {
//	         squares.addSquare(i * 10, i * 10, 100, 100);
//	      }
	}
	
	public void addSquare(Color color, int x){
		squares.addSquare(x,20, 20, 20, color);
		repaint();
	}
	
	public void addBestSquare(Color color){
		squares.addSquare(100,100, 50, 50, color);
		repaint();
	}
}
