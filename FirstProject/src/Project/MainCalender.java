package Project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class MainCalendar extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	MemberDAO dao = new MemberDAO();

	String[] days = { "일", "월", "화", "수", "목", "금", "토" };
	int year, month, day, todays, memoday = 0;

	Font f;
	Color bc, fc;
	Calendar today, cal;
	JButton btnBefore, btnAfter, btnAdd, btnDel;
	JButton[] calBtn = new JButton[49];

	JLabel thing, time;

	JPanel panWest, panSouth, panEast, panNorth;

	JTextField txtMonth, txtYear, txtWrite, txtTime;
	BorderLayout bLayout = new BorderLayout();

	public MainCalendar() {
		today = Calendar.getInstance();
		cal = new GregorianCalendar();
		year = today.get(Calendar.YEAR);
		month = today.get(Calendar.MONTH) + 1;// 1월의 값이 0

		panNorth = new JPanel();
		panNorth.add(btnBefore = new JButton("Before"));
		panNorth.add(txtYear = new JTextField(year + "년"));
		panNorth.add(txtMonth = new JTextField(month + "월"));
		txtYear.setEnabled(false);
		txtMonth.setEnabled(false);

		panNorth.add(btnAfter = new JButton("After"));
		f = new Font("Sherif", Font.BOLD, 24);
		txtYear.setFont(f);
		txtMonth.setFont(f);
		panNorth.add(btnAdd = new JButton("메모추가"));
		panNorth.add(btnDel = new JButton("메모삭제"));

		add(panNorth, "North");

		// 달력
		panWest = new JPanel(new GridLayout(7, 7));// 격자나,눈금형태의 배치관리자
		f = new Font("Sherif", Font.BOLD, 12);

		gridInit();
		calSet();
		hideInit();
		add(panWest, "West");

		panEast = new JPanel();
		panEast.add(time = new JLabel("메모"));
		panEast.add(txtWrite = new JTextField());
		txtWrite.setPreferredSize(new Dimension(350, 300));
		add(panEast, "East");

		btnBefore.addActionListener(this);
		btnAfter.addActionListener(this);
		btnAdd.addActionListener(this);
		btnDel.addActionListener(this);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("스케줄");
		setBounds(600, 400, 800, 400);
		setVisible(true);
	}

	public void calSet() {
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, (month - 1));
		cal.set(Calendar.DATE, 1);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

		/*
		 * get 및 set 를 위한 필드치로, 요일을 나타냅니다. 이 필드의 값은
		 * SUNDAY,MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY, 및 SATURDAY get()메소드의 의해 요일이
		 * 숫자로 반환
		 */

		int j = 0;
		int hopping = 0;
		calBtn[0].setForeground(new Color(255, 0, 0));// 일요일 "일"
		calBtn[6].setForeground(new Color(0, 0, 255));// 토요일 "토"
		for (int i = cal.getFirstDayOfWeek(); i < dayOfWeek; i++) {
			j++;
		}
		// 일요일부터 그달의 첫시작 요일까지 빈칸으로 셋팅하기 위해
		hopping = j;
		for (int kk = 0; kk < hopping; kk++) {
			calBtn[kk + 7].setText("");
		}
		for (int i = cal.getMinimum(Calendar.DAY_OF_MONTH); i <= cal.getMaximum(Calendar.DAY_OF_MONTH); i++) {
			cal.set(Calendar.DATE, i);
			if (cal.get(Calendar.MONTH) != month - 1) {
				break;
			}
//         dbConnect();
			todays = i;
//         checkday();
			if (memoday == 1) {
				calBtn[i + 6 + hopping].setForeground(new Color(0, 255, 0));
			} else {
				calBtn[i + 6 + hopping].setForeground(new Color(0, 0, 0));
				if ((i + hopping - 1) % 7 == 0) {// 일요일
					calBtn[i + 6 + hopping].setForeground(new Color(255, 0, 0));
				}
				if ((i + hopping) % 7 == 0) {// 토요일
					calBtn[i + 6 + hopping].setForeground(new Color(0, 0, 255));
				}
			}

			/*
			 * 요일을 찍은 다음부터 계산해야 하니 요일을 찍은 버튼의 갯수를 더하고 인덱스가 0부터 시작이니 -1을 해준 값으로 연산을 해주고 버튼의
			 * 색깔을 변경해준다.
			 */
			calBtn[i + 6 + hopping].setText((i) + "");
		}
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == btnBefore) {
			this.panWest.removeAll();
			calInput(-1);
			gridInit();
			panelInit();
			calSet();
			hideInit();
			this.txtYear.setText(year + "년");
			this.txtMonth.setText(month + "월");
		} else if (ae.getSource() == btnAfter) {
			this.panWest.removeAll();
			calInput(1);
			gridInit();
			panelInit();
			calSet();
			hideInit();
			this.txtYear.setText(year + "년");
			this.txtMonth.setText(month + "월");
		} else if (ae.getSource() == btnAdd) {
//         dbConnect();
//         add();
			calSet();
			txtWrite.setText("");
		} else if (ae.getSource() == btnDel) {
//         dbConnect();
//         del();
			calSet();
			txtWrite.setText("");
		} else if (Integer.parseInt(ae.getActionCommand()) >= 1 && Integer.parseInt(ae.getActionCommand()) <= 31) {
			day = Integer.parseInt(ae.getActionCommand());
			// 버튼의 밸류 즉 1,2,3.... 문자를 정수형으로 변환하여 클릭한 날짜를 바꿔준다.
			System.out.println(day);
//         dbConnect();
			calSet();
		}
	}

	public void hideInit() {
		for (int i = 0; i < calBtn.length; i++) {
			if ((calBtn[i].getText()).equals(""))
				calBtn[i].setEnabled(false);
			// 일이 찍히지 않은 나머지 버튼을 비활성화 시킨다.
		}
	}

	public void gridInit() {
		// jPanel3에 버튼 붙이기
		for (int i = 0; i < days.length; i++)
			panWest.add(calBtn[i] = new JButton(days[i]));
		for (int i = days.length; i < 49; i++) {
			panWest.add(calBtn[i] = new JButton(""));
			calBtn[i].addActionListener(this);
		}
	}

	public void panelInit() {
		GridLayout gridLayout1 = new GridLayout(7, 7);
		panWest.setLayout(gridLayout1);
	}

	public void calInput(int gap) {
		month += (gap);
		if (month <= 0) {
			month = 12;
			year = year - 1;
		} else if (month >= 13) {
			month = 1;
			year = year + 1;
		}
	}
}