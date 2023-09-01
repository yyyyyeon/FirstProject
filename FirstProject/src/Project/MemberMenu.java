package Project;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class MemberMenu implements ActionListener {
	private JFrame f2;
	private JButton btmy, btwork, btsd, btime, bafter, blogout, btclear, btclear2;
	private JDialog btatt, btatt2, btatt3, btatt4;
	private SimpleDateFormat format2, format3;
	private JLabel ltime, ltime2, ltime3, ltime4, ltime5, ltime6;
	private String format_time2, format_time3, name, hnum, gender, pnumber, adress, mbship,pass;
	

	public MemberMenu(String name, String hnum, String gender, String pnumber, String adress, String mbship, String pass) {
		
		this.name = name;
		this.hnum = hnum;
		this.gender = gender;
		this.pnumber = pnumber;
		this.adress = adress;
		this.mbship = mbship;
		this.pass = pass;
		
		f2 = new JFrame("회원 메뉴");
		f2.setSize(400, 500);
		f2.setLayout(null);
		f2.setVisible(true);

		btmy = new JButton("나의 정보 확인");
		btmy.setBounds(100, 50, 200, 30);
		btmy.setBackground(Color.YELLOW);
		btmy.addActionListener(this);

		btwork = new JButton("금일 추천 운동");
		btwork.setBounds(100, 100, 200, 30);
		btwork.setBackground(Color.YELLOW);
		btwork.addActionListener(this);

		btsd = new JButton("나의 스케줄 확인");
		btsd.setBounds(100, 150, 200, 30);
		btsd.setBackground(Color.YELLOW);
		btsd.addActionListener(this);

		btime = new JButton("출석 시간");
		btime.setBounds(100, 200, 200, 30);
		btime.setBackground(Color.YELLOW);
		btime.addActionListener(this);

		bafter = new JButton("퇴장 시간");
		bafter.setBounds(100, 250, 200, 30);
		bafter.setBackground(Color.YELLOW);
		bafter.addActionListener(this);

		blogout = new JButton("로그아웃");
		blogout.setBounds(100, 300, 200, 30);
		blogout.setBackground(Color.YELLOW);
		blogout.addActionListener(this);


		// 출석시간//
		btatt = new JDialog(f2, "출석완료", true);
		btatt.setLayout(null);
		btatt.setSize(300, 300);
		btatt.setLocation(50, 50);
		btatt3 = new JDialog(f2, "이미 완료된 출석", true);
		btatt3.setLayout(null);
		btatt3.setSize(200, 200);
		btatt3.setLocation(50, 50);
		btclear = new JButton("출석 완료!");
		btclear.setBounds(95, 100, 100, 50);
		btclear.setBackground(Color.YELLOW);
		btclear.addActionListener(this);
		btatt.add(btclear);
		btatt.setLocationRelativeTo(null);
		ltime = new JLabel();
		ltime.setBounds(105, 150, 150, 50);
		ltime3 = new JLabel("이미 출석처리 되었습니다.");
		ltime3.setBounds(20, 40, 150, 50);
		ltime4 = new JLabel();
		ltime4.setBounds(50, 90, 150, 50);
		btatt.add(ltime);
		btatt3.add(ltime3);
		btatt3.add(ltime4);
		btatt3.setLocationRelativeTo(null);
		btatt3.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		

		// 출석시간//

		// 퇴장시간//
		btatt2 = new JDialog(f2, "퇴장", true);
		btatt2.setLayout(null);
		btatt2.setSize(300, 300);
		btatt2.setLocation(50, 50);
		btatt4 = new JDialog(f2, "이미 완료된 퇴장", true);
		btatt4.setLayout(null);
		btatt4.setSize(200, 200);
		btatt4.setLocation(50, 50);
		btclear2 = new JButton("맛있는 득근 완료!");
		btclear2.setBounds(70, 70, 150, 50);
		btclear2.setBackground(Color.YELLOW);
		btclear2.addActionListener(this);
		btatt2.add(btclear2);
		btatt2.setLocationRelativeTo(null);
		ltime2 = new JLabel();
		ltime2.setBounds(100, 120, 150, 50);
		ltime5 = new JLabel("이미 퇴장 처리 됐습니다.");
		ltime5.setBounds(30, 50, 150, 50);
		ltime6 = new JLabel();
		ltime6.setBounds(50, 100, 150, 50);	
		btatt2.add(ltime2);
		btatt4.add(ltime5);
		btatt4.add(ltime6);
		btatt4.setLocationRelativeTo(null);
		btatt2.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		// 퇴장시간//

		f2.add(btmy);
		f2.add(btwork);
		f2.add(btsd);
		f2.add(btime);
		f2.add(bafter);
		f2.add(blogout);
		f2.setLocationRelativeTo(null);
		f2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btmy) {
			new MyInformation(name, hnum, gender, pnumber, adress, mbship, pass);
		}
		if (e.getSource() == btwork) {
			new Exercise();
		}
		if (e.getSource() == btsd) {
			new MainCalendar();
		}
		if (e.getSource() == btime) {
			if(ltime.getText() == "") {
			format2 = new SimpleDateFormat("HH시mm분ss초");
			format_time2 = format2.format(System.currentTimeMillis());
			ltime.setText(format_time2);
			btatt.setVisible(true);
			} else {
				ltime4.setText(ltime.getText());
				btatt3.setVisible(true);
				
			}
		}
		if (e.getSource() == btclear) {
			btatt.dispose();

		}
		if (e.getSource() == bafter) {
			if(ltime2.getText() == "") {
			format3 = new SimpleDateFormat("HH시mm분ss초");
			format_time3 = format3.format(System.currentTimeMillis());
			ltime2.setText(format_time3);		
			btatt2.setVisible(true);
		} else {
			ltime6.setText(ltime2.getText());
			btatt4.setVisible(true);
		}
		

	}
		if (e.getSource() == btclear2) {
			btatt2.dispose();
		}
		if(e.getSource() == blogout) {
			new Login();
			f2.dispose();
		}
}
}