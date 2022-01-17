package tptty.example04;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

//상속이 아니라 interface add
public class MyWindowListener implements WindowListener {
	MyFrame frame;
	public MyWindowListener(MyFrame f) {
		this.frame = f;
	}
	
	@Override
	public void windowOpened(WindowEvent e) {//윈도우 창이 켜지면
//		JOptionPane.showMessageDialog(null, "환영합니다."); //환영합니다.<-메세지 창 띄우기
		
		//독립적인 클래스지만 MyFrame의 title을 받고 싶은 경우
		String name = JOptionPane.showInputDialog("닉네임을 입력하세요");
		if(frame!=null) {
			frame.setTitle(name+"님 환영합니다.");
		}
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
