package tptty.example02;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class MyFrame extends JFrame {

	JPanel panel1, panel2;

	Color[] color = { Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.PINK, Color.GRAY };
	CardLayout cl = new CardLayout();
	JPanel[] card; // CardLayout으로 패널 전환 구현

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
				cl.previous(panel2); //previous : panel2의 현재 상태보다 이전 상태로
			}

		});

		JButton btn2 = new JButton("Home");
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(panel2, "3");
			}

		});

		JButton btn3 = new JButton(">>");
		btn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cl.next(panel2);
//				cl.first(panel2); //가장 처음에 등록된 card정보 보여줌
//				cl.last(panel2); //가장 나중에 등록된 card정보 보여줌
			}

		});

		panel1.add(btn1);
		panel1.add(btn2);
		panel1.add(btn3);
	}

	public void initPanel2() {
		panel2 = new JPanel(cl); // panel2의 배치관리자 CardLayout으로 변경
		card = new JPanel[color.length]; //패널을 저장할 수 있는 빈 방 생성
		for(int i=0;i<card.length;i++) {
			card[i] = new JPanel();
			card[i].setBackground(color[i]);
			panel2.add(card[i], String.valueOf(i)); //기본타입은 식별자로 들어갈 수 없음->참조타입으로 변환
		}
		cl.show(panel2, "3");
		//panel2가 보여지는 초기화면을 3번 카드로 : 설정하지 않으면 자동으로 맨 처음 카드 출력
		
		
	}
}
