package tptty.example06;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class MouseEventAllEx extends JFrame {
	JLabel la = new JLabel("Move Me");
	
	MouseEventAllEx() {
		setTitle("MouseListener와 MouseMotionListener예제");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container c = this.getContentPane();
		MyMouseListener listener = new MyMouseListener();
		c.addMouseListener(listener);
		c.addMouseMotionListener(listener);
		
		c.setLayout(null);
		
		la.setSize(80,20);
		la.setLocation(100,80);
		c.add(la);
		
		this.setSize(300,200);
		this.setVisible(true);
		
		
	}
	
	class MyMouseListener implements MouseListener, MouseMotionListener{

		@Override
		public void mouseDragged(MouseEvent e) {
			la.setLocation(e.getX(), e.getY());
			setTitle("mouseDragged("+e.getX()+","+e.getY()+")");
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			la.setLocation(e.getX(), e.getY());
			setTitle("mouseMoved("+e.getX()+","+e.getY()+")");
			
		}

		@Override
		public void mouseClicked(MouseEvent e) {}

		@Override
		public void mousePressed(MouseEvent e) {
			la.setLocation(e.getX(), e.getY());
			setTitle("mousePressed("+e.getX()+","+e.getY()+")");
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			la.setLocation(e.getX(), e.getY());
			setTitle("mouseReleased("+e.getX()+","+e.getY()+")");
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			Component comp = (Component) e.getSource();
			comp.setBackground(Color.CYAN);
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			Component comp = (Component) e.getSource();
			comp.setBackground(Color.YELLOW);
			
		}
		
	}
	
	
	public static void main(String[] args) {
		new MouseEventAllEx();

	}

}
