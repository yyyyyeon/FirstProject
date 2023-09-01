package Project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Exercise implements ActionListener {
	private JFrame f7;
	private JComboBox<String> work;
	private String[] bwork = { "팔 운동", "등 운동", "하체 운동", "가슴 운동" };
	private MemberDAO dao;
	private JTextArea gym1;

	public Exercise() {
		dao = new MemberDAO();
		f7 = new JFrame("금일 추천 운동");
		f7.setSize(400, 400);

		// 콤보 박스//
		
		work = new JComboBox<String>(bwork);
		work.setBounds(145, 50, 100, 30);
		work.addActionListener(this);
		
		// 콤보 박스//

		gym1 = new JTextArea();
		gym1.setBounds(45, 100, 300, 200);
		f7.add(gym1);
		gym1.setFocusable(false);

		// 텍스트 아리아//
		
		
		
		
		
		
		
		
		
		

		// 콤보 박스//

		f7.add(work);

		// 콤보 박스//

		f7.setLayout(null);
		f7.setVisible(true);
		f7.setLocationRelativeTo(null);
		f7.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}

	public void actionPerformed(ActionEvent e) {
		JComboBox<?> jcb = (JComboBox<?>) e.getSource();
		gym1.setText("");
		int index = jcb.getSelectedIndex();
		ArrayList<MemberVo> list = dao.worktable(index);
		for(int i=0; i<list.size(); i++) {
			MemberVo data = (MemberVo) list.get(i);
			String a= data.getPwd();
			gym1.append(a + "\n"+"\n");
			
		}
	}
}