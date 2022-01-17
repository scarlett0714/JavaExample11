package tptty.example04;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class MyFrame extends JFrame {
	public MyFrame() {
		this("202110547 황윤선");
	}

	public MyFrame(String title) {
		super(title);
		this.setSize(500,500);
		this.setLocationRelativeTo(null);
//		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		init();
		this.setVisible(true);
	}

	public void init() {
//		this.addWindowListener(new MyWindowListener(this)); //MyFrame의 정보를 넘김
//		this.addWindowListener(new MyWindowAdapter(this));
		this.addWindowListener(new MyWindowAdapter2());
		
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				System.exit(0); //<-this.setDefaultCloseOperation(EXIT_ON_CLOSE); (생성자)
				
				
			}
			
			
		});
	}

	// 내부클래스로 adapter만들기
	class MyWindowAdapter2 extends WindowAdapter {

		@Override
		public void windowOpened(WindowEvent e) {
			String name = JOptionPane.showInputDialog("닉네임을 입력하세요");
			setTitle(name + "님 환영합니다.");

		}
	}
}
