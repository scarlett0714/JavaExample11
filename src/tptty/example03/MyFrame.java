package tptty.example03;

import java.awt.*;


import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class MyFrame extends JFrame {

	JPanel panel1, panel2;
	JLabel imgChar = new JLabel(); //보통 문자열 출력 시 사용, 간단한 이미지 출력 가능
	ImageIcon img = new ImageIcon("img/char1.png");
	int xpos = 100, ypos = 100; //(x,y)

	public MyFrame() {
		this("202110547 황윤선");
	}

	public MyFrame(String title) {
		super(title);
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		init();
		this.setVisible(true);
	}

	public void init() {
		Container frame = this.getContentPane();
		initPanel1();
		initPanel2();

		frame.add(panel1, BorderLayout.NORTH);
		frame.add(panel2, BorderLayout.CENTER);

	}

	public void initPanel1() {
		panel1 = new JPanel(new GridLayout(1, 3, 10, 10)); // panel1 = new JPanel(); : 기본은 FlowLayout
		// (행, 열, 수평갭, 수직갭)

		JButton btn1 = new JButton("<<");
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (xpos >= 10) {
					xpos -= 10;
					imgChar.setBounds(xpos, ypos, img.getIconWidth(), img.getIconHeight());
				}

			}

		});

		JButton btn2 = new JButton("Home");
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				xpos = 100;
				ypos = 100;
				imgChar.setBounds(xpos, ypos, img.getIconWidth(), img.getIconHeight());
			}

		});

		JButton btn3 = new JButton(">>");
		btn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (xpos <= (panel2.getWidth()-img.getIconWidth()-10)) {
					//스크린의 크기가 아니라 패널의 크기를 가져와서 그것을 벗어나지 않도록 설정
					xpos += 10;
					imgChar.setBounds(xpos, ypos, img.getIconWidth(), img.getIconHeight());
				}
			}

		});

		panel1.add(btn1);
		panel1.add(btn2);
		panel1.add(btn3);
	}

	public void initPanel2() {
		panel2 = new JPanel();
		panel2.setLayout(null);
		imgChar.setIcon(img); //레이블에 이미지 설정
		panel2.add(imgChar);
		//배치관리자가 없다면, 크기, 위치정보가 없어 화면에 출력되지 않음
		imgChar.setBounds(xpos, ypos, img.getIconWidth(), img.getIconHeight()); //이미지 크기 만큼만 화면에 원하는 위치에 출력
		
		
	}
}
