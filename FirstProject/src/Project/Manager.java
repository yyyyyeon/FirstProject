package Project;

import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Manager implements ActionListener {
	private TextField tfPwd2;
	private JFrame f3;
	private JButton bLogin2;
	private MemberDAO dao;
	
	public Manager() {
		dao = new MemberDAO();
		f3 = new JFrame("관리자 메뉴");
		f3.setSize(400, 400);
		f3.setLayout(null);
		f3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		Label lpwd2 = new Label("비밀번호 :");
		lpwd2.setBounds(30, 155, 100, 40);

		bLogin2 = new JButton("로그인");
		bLogin2.setBounds(280, 150, 100, 50);
		bLogin2.addActionListener(this);

		tfPwd2 = new TextField();
		tfPwd2.setBounds(130, 160, 130, 30);
		tfPwd2.setEchoChar('*');
		
		
		
		
		
				
		f3.add(lpwd2);
		f3.add(tfPwd2);
		f3.add(bLogin2);
		

		f3.setVisible(true);
		f3.setLocationRelativeTo(null);
		f3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bLogin2) {
			String strpwd = tfPwd2.getText();
			ArrayList<MemberVo> list = dao.ManagerLogin(strpwd);
			
			if(list.size() == 1) {
				MemberVo data = (MemberVo) list.get(0);
				String pwd = data.getPwd();
				System.out.println("DB ==> " + " : "+ pwd);
			
				new Table();
				f3.dispose();
			}
		}

	}
}