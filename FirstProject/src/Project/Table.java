package Project;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Table {
	   public Table() {
		   MemberDAO dao = new MemberDAO();
	      ArrayList<MemberVo> list = dao.list2();
	      System.out.println("listSize : " + list.size());

	      JFrame frame = new JFrame("전 회원 정보");
	      frame.setSize(800,400);
	      JPanel panel = new JPanel();
	      JTable table = new JTable();
	      JScrollPane ScrollPane = new JScrollPane(table);
	      String[] headings = new String[] { "아이디", "비밀번호", "이름", "전화번호", "성별", "주소", "회원번호", "멤버십", "회원권" };
	      DefaultTableModel rec = new DefaultTableModel(headings, 0);

	      for (MemberVo vo : list) {
	         Object[] row = { vo.getId(), vo.getPwd(), vo.getName(), vo.getTel(), vo.getGender(), vo.getAdress(), vo.getHnumber(), vo.getMembership(), vo.getPtpass() };

	         rec.addRow(row);
	      }
	      table.setModel(rec);
	      frame.add(ScrollPane);
	      ScrollPane.add(panel);
	      frame.setVisible(true);
	      frame.setLocationRelativeTo(null);
	      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	   }
}