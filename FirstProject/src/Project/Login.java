package Project;

import java.awt.Graphics;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Login extends WindowAdapter implements ActionListener {
	private JFrame f;
	private TextField tfId, tfPwd, tfMsg;
	private JButton bLogin, join;
	private JButton manager;
	private MemberDAO dao;
	private BufferedImage img;
	private String name, hnum, gender, pnumber, adress, mbship, pass; 

	public Login() {
		dao = new MemberDAO();
		f = new JFrame("로그인창");
		f.setSize(550, 700);
		f.setLayout(null);
		f.addWindowListener(this);

		try {
			img = ImageIO.read(new File("C:\\kimkangyeon\\fp\\login.png"));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "이미지 불러오기 실패");
		}
		myPanel panel = new myPanel();
		panel.setBounds(15, 100, 500, 200);

		Label lid = new Label("아이디");
		lid.setBounds(60, 390, 100, 40);

		tfId = new TextField();
		tfId.setBounds(160, 400, 220, 30);

		Label lpwd = new Label("비밀번호");
		lpwd.setBounds(60, 450, 100, 40);

		tfPwd = new TextField();
		tfPwd.setBounds(160, 450, 220, 30);
		tfPwd.setEchoChar('*');

		bLogin = new JButton("로그인");
		bLogin.setBounds(400, 410, 100, 50);
		bLogin.addActionListener(this);

		tfMsg = new TextField("");
		tfMsg.setBounds(100, 500, 350, 30);
		tfMsg.setEditable(false);
		tfMsg.setFocusable(false);

		join = new JButton("회원가입");
		join.setBounds(240, 560, 100, 50);
		join.addActionListener(this);

		manager = new JButton("관리자 메뉴");
		manager.setBounds(50, 560, 100, 50);
		manager.addActionListener(this);

		f.add(panel);
		f.add(lid);
		f.add(tfId);
		f.add(lpwd);
		f.add(tfPwd);
		f.add(bLogin);
		f.add(tfMsg);
		f.add(join);
		f.add(manager);
		f.setVisible(true);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	@SuppressWarnings("serial")
	class myPanel extends JPanel {
		public void paint(Graphics g) {
			g.drawImage(img, 0, 0, null);

		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bLogin) {
			System.out.println(tfId.getText());
			System.out.println(tfPwd.getText());

			String strId = tfId.getText();

			ArrayList<MemberVo> list = dao.list(strId);

			if (list.size() == 1) {
				MemberVo data = (MemberVo) list.get(0);
				String id = data.getId();
				String pwd = data.getPwd();
				name = data.getName();
				hnum = data.getHnumber();
				gender = data.getGender();
				pnumber = data.getTel();
				adress = data.getAdress();
				mbship = data.getMembership();
				pass = data.getPtpass();
				
				

				System.out.println("DB ==> " + id + " : " + pwd + " : " + name+ " : " + hnum + " : " + gender + " : " + pnumber + " : " +  adress + " : " + mbship + " : " + pass);

				if (tfPwd.getText().equals(pwd)) {
					tfMsg.setText("로그인에 성공했습니다!");
					new MemberMenu(name,hnum,gender,pnumber,adress,mbship,pass);
					f.dispose();
				} else {
					tfMsg.setText("아이디 또는 비밀번호를 잘못 입력했습니다. 다시 확인해주세요");
				}
			} else {
				tfMsg.setText("아이디 또는 비밀번호를 잘못 입력했습니다. 다시 확인해주세요");
			}

		}
		if (e.getSource() == manager) {
			new Manager();

		}

		if (e.getSource() == join) {
			new Join();

		}

	}

	public void windowClosing(WindowEvent e) {
		f.dispose();

	}

}