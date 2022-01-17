package tptty.example01;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class MyFrame extends JFrame {
	
	JPanel panel1, panel2;
	
	String[] str = {"빨강", "초록", "파랑", "노랑", "핑크", "회색"};
	Color[] color = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.PINK, Color.GRAY};
	
	public MyFrame() {
		this("202110547 황윤선");
	}

	public MyFrame(String title) {
		super(title);
		this.setSize(500,500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		init();
		this.setVisible(true);
	}

	public void init() {
		Container frame = this.getContentPane();
		panel1 = new JPanel(new GridLayout(1, str.length,10,10)); //panel1 = new JPanel(); : 기본은 FlowLayout
		//(행, 열, 수평갭, 수직갭)
		panel2 = new JPanel();
		panel2.setBackground(Color.RED);
		
		for(int i=0;i<str.length;i++) {
			final int idx = i;
			//i값이 바뀌면서 idx의 값을 계속 변경하는 것이 아니라, 반복문이 실행될때마다 idx를 생성하므로 final사용가능
			JButton btn = new JButton(str[i]);
			//ctrl+shift+O : 자동으로 import
			btn.setBackground(color[i]);
			btn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
//					panel2.setBackground(color[i]);
					//오류발생 : i변수 사용불가능
					//오류원인 : new ActionListener()하면서 암묵적으로 새로운 클래스가 생성
					//->actionPerformed 메소드는 ActionListener클래스의 멤버 vs i는 MyFrame클래스의 init메소의 멤버
					//해결방법 : final 상수로 설정(idx)
					panel2.setBackground(color[idx]);
					
					
				}
				
			});
			//반드시 생성된 버튼을 패널에 추가
			panel1.add(btn);
		}
		
		frame.add(panel1, BorderLayout.NORTH);
		frame.add(panel2, BorderLayout.CENTER);
		
	}
}
