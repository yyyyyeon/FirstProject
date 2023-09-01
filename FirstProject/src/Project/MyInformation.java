package Project;

import java.awt.Label;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class MyInformation{
	private MemberDAO dao;
	private JFrame f6;
	private JTextField namet, hnumt, sext, telnumt, inforadresst, mbst, ptpasst ;
	public MyInformation(String name, String hnum, String gender, String pnumber, String adress, String mbship, String pass) {
		
		dao = new MemberDAO();
		
		f6 = new JFrame("나의 정보 확인");
		f6.setSize(400,500);
		f6.setLayout(null);
		f6.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f6.setVisible(true);
		f6.setLocationRelativeTo(null);
		//라벨//
		Label linfoname = new Label("이름");
		linfoname.setBounds(60, 50, 50, 40);
		
		Label lhnum = new Label("회원번호");
		lhnum.setBounds(60, 100, 50, 40);
		
		Label lsex = new Label("성별");
		lsex.setBounds(60, 150, 50, 40);
		
		Label ltelnum = new Label("전화번호");
		ltelnum.setBounds(60, 200, 50, 40);
		
		Label linforadress = new Label("주소");
		linforadress.setBounds(60, 250, 50, 40);
		
		Label lmbs = new Label("회원권");
		lmbs.setBounds(60, 300, 50, 40);
		
		Label lptpass = new Label("PT이용권");
		lptpass.setBounds(60, 350, 55, 40);
		//라벨//
		
		//텍스트필드//
		namet = new JTextField();
		namet.setBounds(120, 58, 150, 20);
		namet.setFocusable(false);
		namet.setText(name);
		
		hnumt = new JTextField();
		hnumt.setBounds(120, 108, 150, 20);
		hnumt.setFocusable(false);
		hnumt.setText(hnum);
		
		sext = new JTextField();
		sext.setBounds(120, 158, 150, 20);
		sext.setFocusable(false);
		sext.setText(gender);
		
		telnumt = new JTextField();
		telnumt.setBounds(120, 208, 150, 20);
		telnumt.setFocusable(false);
		telnumt.setText(pnumber);
		
		inforadresst = new JTextField();
		inforadresst.setBounds(120, 258, 150, 20);
		inforadresst.setFocusable(false);
		inforadresst.setText(adress);
		
		
		mbst = new JTextField();
		mbst.setBounds(120, 308, 150, 20);
		mbst.setFocusable(false);
		mbst.setText(mbship);
		
		ptpasst = new JTextField();
		ptpasst.setBounds(120, 358, 150, 20);
		ptpasst.setFocusable(false);
		
		if(pass==null) {
			pass = "이용 안 함";
			ptpasst.setText(pass);
		}else{		
			ptpasst.setText(pass);
		}
		//텍스트 필드
		f6.add(linfoname);
		f6.add(lhnum);
		f6.add(lsex);
		f6.add(ltelnum);
		f6.add(linforadress);
		f6.add(lmbs);
		f6.add(lptpass);
		f6.add(namet);
		f6.add(hnumt);
		f6.add(sext);
		f6.add(telnumt);
		f6.add(inforadresst);
		f6.add(mbst);
		f6.add(ptpasst);
		f6.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	
	}
	

}