package tptty.example04;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

//WindowAdapter 상속받기
public class MyWindowAdapter extends WindowAdapter {

	MyFrame frame;
	public MyWindowAdapter(MyFrame f) {
		this.frame = f;
	}
	
	//구현하고 싶은 것만 override
	@Override
	public void windowOpened(WindowEvent e) {
		String name = JOptionPane.showInputDialog("닉네임을 입력하세요");
		if(frame!=null) {
			frame.setTitle(name+"님 환영합니다.");
		}
	}
	
	
}
