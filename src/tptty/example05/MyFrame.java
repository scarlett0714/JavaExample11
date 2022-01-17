package tptty.example05;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class MyFrame extends JFrame {
	String[] imgpath = { "img/Down.png", "img/Left.png", "img/Right.png", "img/Up.png" };
	ImageIcon[] icons; // 방향에 따라 보여줄 icon담기
	JLabel player; // player를 출력해야함
	int imgWidth, imgHeight; // 배치관리자가 없는 상태이므로 위치지정변수
	Point pos = new Point(100, 100); // Point클래스 : (x,y)멤버 가짐

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
		icons = new ImageIcon[imgpath.length]; // 빈 방 생성
		for (int i = 0; i < icons.length; i++) {
			icons[i] = new ImageIcon(imgpath[i]); // 4개의 이미지 아이콘 생성
		}

		player = new JLabel(icons[0]); // 첫번째 이미지로 player생성

		// 배치관리자가 없으므로 이미지의 크기 설정
		imgWidth = icons[0].getIconWidth();
		imgHeight = icons[0].getIconHeight();

		this.setLayout(null); // 배치관리자 삭제
		player.setSize(imgWidth, imgHeight);
		player.setLocation(pos);

		this.getContentPane().add(player); // container변수 만들어 add하는 방법과 동일
//		this.add(player); (o) //this : JFrame -> contentpane에 추가됨
		this.getContentPane().setBackground(Color.WHITE);
//		this.setBackground(Color.WHITE); (x) 

		initKeyListener();
		initMouseListener();
	}

	public void initMouseListener() {
		this.addMouseListener(new MYMouseListener());

	}

	class MYMouseListener extends MouseAdapter {

		@Override
		public void mouseEntered(MouseEvent e) {

			super.mouseEntered(e);
			setSize(500, 500); // setSize는 outer
			// this.setSize (x) : inner
			// MyFrame.this.setSize (o) : outer (클래스이름.this)
			getContentPane().setBackground(Color.GREEN);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			super.mouseExited(e);
			setSize(300, 300);
			getContentPane().setBackground(Color.ORANGE);
		}

	}

	public void initKeyListener() {
		this.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				super.keyPressed(e);
				switch (e.getKeyCode()) {
				case KeyEvent.VK_DOWN:
					pos.y += 10;
					player.setIcon(icons[0]);
					break;
				case KeyEvent.VK_LEFT:
					pos.x -= 10;
					player.setIcon(icons[1]);
					break;
				case KeyEvent.VK_RIGHT:
					pos.x += 10;
					player.setIcon(icons[2]);
					break;
				case KeyEvent.VK_UP:
					pos.y -= 10;
					player.setIcon(icons[3]);
					break;
				}
				player.setLocation(pos);
			}

			@Override
			public void keyTyped(KeyEvent e) { // UNICODE값을 가지고 있는 키에 대해서만 작동
				super.keyTyped(e);
				switch (e.getKeyChar()) {
				case 's':
					pos.y += 10;
					player.setIcon(icons[0]);
					break;
				case 'a':
					pos.x -= 10;
					player.setIcon(icons[1]);
					break;
				case 'd':
					pos.x += 10;
					player.setIcon(icons[2]);
					break;
				case 'w':
					pos.y -= 10;
					player.setIcon(icons[3]);
					break;
				}
				player.setLocation(pos);

			}

		});

	}
}
