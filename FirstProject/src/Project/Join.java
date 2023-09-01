package Project;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Join implements ActionListener {
	private MemberDAO dao;
	private JFrame f4;
	private JTextField tfname, tfnumber, tfadress, tfid, tfpwd;
	private Checkbox jrmale, jrfemale, jrmbso, jrmbsx, jrpts1, jrpts2, jrpts3, jrpts4;
	private JButton duplication, check, jok, btok,btno;
	private Dialog ok,dupok,dupno;
	public Join() {
		dao = new MemberDAO();
		f4 = new JFrame("회원가입");
		f4.setSize(500, 600);
		f4.setLayout(null);
		f4.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		check = new JButton("회원가입");
		check.setBounds(300, 400, 100, 30);
		check.addActionListener(this);
		
		

		Label lname = new Label("성명 :");
		lname.setBounds(60, 50, 50, 40);

		Label lgender = new Label("성별 :");
		lgender.setBounds(60, 100, 50, 40);

		Label lnumber = new Label("전화번호 :");
		lnumber.setBounds(60, 150, 60, 40);

		Label ladress = new Label("주소 :");
		ladress.setBounds(60, 200, 60, 40);

		Label lid = new Label("아이디 :");
		lid.setBounds(60, 250, 60, 40);

		Label lpwd = new Label("비밀번호 :");
		lpwd.setBounds(60, 300, 60, 40);
		

		Label lmembership = new Label("멤버십 :");
		lmembership.setBounds(60, 350, 60, 40);

		Label lptpass = new Label("이용권 :");
		lptpass.setBounds(60, 400, 60, 40);

		CheckboxGroup group2 = new CheckboxGroup();
		jrmbso = new Checkbox("O", group2, true);
		jrmbsx = new Checkbox("X", group2, true);

		jrmbso.setBounds(130, 355, 30, 30);
		jrmbsx.setBounds(210, 355, 100, 30);

		CheckboxGroup group3 = new CheckboxGroup();
		jrpts1 = new Checkbox("3개월", group3, true);
		jrpts2 = new Checkbox("6개월", group3, true);
		jrpts3 = new Checkbox("1년", group3, true);
		jrpts4 = new Checkbox("선택 안 함", group3, true);

		jrpts1.setBounds(130, 390, 50, 30);
		jrpts2.setBounds(220, 390, 50, 30);
		jrpts3.setBounds(130, 420, 50, 30);
		jrpts4.setBounds(210, 420, 100, 30);

		tfname = new JTextField();
		tfname.setBounds(120, 55, 150, 30);

		CheckboxGroup group1 = new CheckboxGroup();
		jrmale = new Checkbox("남", group1, true);
		jrfemale = new Checkbox("여", group1, true);

		jrmale.setBounds(130, 105, 30, 30);
		jrfemale.setBounds(210, 105, 100, 30);


		tfnumber = new JTextField();
		tfnumber.setBounds(120, 155, 150, 30);

		tfadress = new JTextField();
		tfadress.setBounds(120, 205, 150, 30);

		tfid = new JTextField();
		tfid.setBounds(120, 255, 150, 30);

		duplication = new JButton("중복된 아이디 확인");
		duplication.setBounds(300, 255, 150, 30);
		duplication.addActionListener(this);

		tfpwd = new JTextField();
		tfpwd.setBounds(120, 305, 150, 30);
		
		// 회원가입 완료 다이얼로그
		ok = new Dialog(f4,"회원가입 완료",true);
		ok.setSize(300,300);
		ok.setLocation(50,50);
		ok.setLayout(null);		
		Label msg = new Label("회원가입이 완료되었습니다.",Label.CENTER);
		msg.setBounds(50,200,200,50);
		jok = new JButton("확인");
		jok.setBounds(90,100,150,50);
		jok.setBackground(Color.YELLOW);
		jok.addActionListener(this);
		ok.add(msg);
		ok.add(jok);
		ok.setLocationRelativeTo(null);
		//
		
		dupok = new Dialog(f4,"중복확인되었습니다.",true);
		dupok.setLayout(null);
		dupok.setSize(300,300);
		dupok.setLocation(50,50);
		btok = new JButton("확인");
		btok.setBounds(90,100,100,100);	
		btok.setBackground(Color.PINK);
		dupok.add(btok);
		btok.addActionListener(this);
		dupok.setLocationRelativeTo(null);
		
		dupno = new Dialog(f4,"중복된아이디입니다.",true);
		dupno.setLayout(null);
		dupno.setSize(300,300);
		dupno.setLocation(50,50);
		btno = new JButton("확인");
		btno.setBounds(90,100,100,100);	
		btno.setBackground(Color.PINK);
		dupno.add(btno);
		btno.addActionListener(this);
		dupno.setLocationRelativeTo(null);
		
		f4.add(lname);
		f4.add(lnumber);
		f4.add(tfname);
		f4.add(lgender);
		f4.add(ladress);
		f4.add(jrmale);
		f4.add(jrfemale);
		f4.add(tfnumber);
		f4.add(tfadress);
		f4.add(lid);
		f4.add(tfid);
		f4.add(duplication);
		f4.add(lpwd);
		f4.add(tfpwd);
		f4.add(check);
		f4.add(jrmbso);
		f4.add(jrmbsx);
		f4.add(lmembership);
		f4.add(lptpass);
		f4.add(jrpts1);
		f4.add(jrpts2);
		f4.add(jrpts3);
		f4.add(jrpts4);
		f4.setVisible(true);
		f4.setLocationRelativeTo(null);
		f4.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == duplication) {
			String strId = tfid.getText();
			ArrayList<MemberVo> list = dao.list(strId);
			if (list.size() == 1) {
				MemberVo data = (MemberVo) list.get(0);
				String id = data.getId();
				System.out.println("DB ==> " + id + " : ");
				dupno.setVisible(true);
			}else {
				dupok.setVisible(true);
			}

		}
		if(e.getSource() == btok) {
			dupok.dispose();
		}
		if(e.getSource() == btno) {
			dupno.dispose();
		}
		
		if(e.getSource() == jok) {
			ok.dispose();
		}
		
		
		if (e.getSource() == check) {
			String strId = tfname.getText();

			String gender;
			if (jrmale.getState() == true) {
				gender = "남";  
			} else {
				gender = "여";
			}
			String strnumber = tfnumber.getText();
			String stradress = tfadress.getText();
			String strId2 = tfid.getText();
			String strpwd = tfpwd.getText();
			String membship;
			if (jrmbso.getState() == true) {
				membship = "O";
			} else {
				membship = "X";
			}

			String strptp = null;
			if (jrpts1.getState() == true) {
				strptp = "3개월";
			} else if (jrpts2.getState() == true) {
				strptp = "6개월";
			} else if (jrpts3.getState() == true) {
				strptp = "1년";
			} else if (jrpts4.getState() == true) {
				strptp = "";
			}

			ArrayList<MemberVo> joinInsert = dao.joinInsert(strId, gender, strnumber, stradress, strId2, strpwd,
					membship, strptp);

			if (joinInsert.size() == 1) {
				MemberVo data = (MemberVo) joinInsert.get(0);
				String name = data.getName();
				String gender1 = data.getGender();
				String tel = data.getTel();
				String address = data.getAdress();
				String mbid = data.getId();
				String password = data.getPwd();
				String mbs = data.getMembership();
				String pass = data.getPtpass();
//				String hnum = data.getHnumber();

				System.out.println("DB ==> " + name + " : " + gender1 + " : " + tel + " : " + address + " : " + mbid
						+ " : " + password + " : " + mbs + " : " + pass);
				
				ok.setVisible(true);
				f4.dispose();
			}
						
		}

	}
}