package Project;

import java.sql.*;
import java.util.*;

public class MemberDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521/xe";
	String user = "C##FIRSTPROJ";
	String password = "FIRSTPROJ";

	private Connection con;
	private Statement stmt;
	private ResultSet rs;

	public ArrayList<MemberVo> list(String id) {
		ArrayList<MemberVo> list = new ArrayList<MemberVo>();
		try {
			connDB();

			String query = "SELECT * FROM MEMBER";
			if (id != null) {
				query += " where MEMBER_ID='" + id + "'";
			}
			System.out.println("SQL : " + query);
			rs = stmt.executeQuery(query);
			rs.last();
			System.out.println("rs.getRow() : " + rs.getRow());
			if (rs.getRow() == 0) {
				System.out.println("0 row selected.....");
			} else {
				System.out.println(rs.getRow() + " rows selected.....");
				rs.previous();
				while (rs.next()) {
					String y1 = rs.getString("NAME");
					String y2 = rs.getString("GENDER");
					String y3 = rs.getString("TEL");
					String y4 = rs.getString("ADDRESS");
					String y5 = rs.getString("MEMBER_ID");
					String y6 = rs.getString("PASSWORD");
					String y7 = rs.getString("MEMBERSHIP");
					String y8 = rs.getString("PT_PASS");
					String y9 = rs.getString("H_NUMBER");
					MemberVo data = new MemberVo(y1, y2, y3, y4, y5, y6, y7, y8, y9);

					list.add(data);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<MemberVo> list2() {
		ArrayList<MemberVo> list2 = new ArrayList<MemberVo>();
		try {
			connDB();

			String query = "SELECT * FROM MEMBER ORDER BY NAME";
			System.out.println("SQL : " + query);
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				String y1 = rs.getString("NAME");
				String y2 = rs.getString("GENDER");
				String y3 = rs.getString("TEL");
				String y4 = rs.getString("ADDRESS");
				String y5 = rs.getString("MEMBER_ID");
				String y6 = rs.getString("PASSWORD");
				String y7 = rs.getString("MEMBERSHIP");
				String y8 = rs.getString("PT_PASS");
				String y9 = rs.getString("H_NUMBER");
				MemberVo data = new MemberVo(y1, y2, y3, y4, y5, y6, y7, y8, y9);

				list2.add(data);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list2;
	}

	public ArrayList<MemberVo> joinInsert(String name, String gender, String tel, String adress, String id, String pwd,
			String membership, String ptpass) {
		ArrayList<MemberVo> joinInsert = new ArrayList<MemberVo>();
		try {
			connDB();

			String query = "INSERT INTO MEMBER(NAME, GENDER, TEL, ADDRESS, MEMBER_ID, PASSWORD, MEMBERSHIP, PT_PASS) VALUES('"
					+ name + "','" + gender + "','" + tel + "','" + adress + "','" + id + "','" + pwd + "','"
					+ membership + "','" + ptpass + "')";
			rs = stmt.executeQuery(query);

			String sql2 = "UPDATE MEMBER SET H_NUMBER = ROUND(DBMS_RANDOM.VALUE(0, 100)) WHERE MEMBER_ID = '" + id
					+ "'";
			rs = stmt.executeQuery(sql2);

			String sql = "select * from member";
			rs = stmt.executeQuery(sql);
			if (id != null) {
				sql += " where MEMBER_ID =trim('" + id + "')";
			}
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				String y1 = rs.getString("NAME");
				String y2 = rs.getString("GENDER");
				String y3 = rs.getString("TEL");
				String y4 = rs.getString("ADDRESS");
				String y5 = rs.getString("MEMBER_ID");
				String y6 = rs.getString("PASSWORD");
				String y7 = rs.getString("MEMBERSHIP");
				String y8 = rs.getString("PT_PASS");
				String y9 = rs.getString("H_NUMBER");
				MemberVo data = new MemberVo(y1, y2, y3, y4, y5, y6, y7, y8, y9);
				joinInsert.add(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return joinInsert;
	}

	public ArrayList<MemberVo> ManagerLogin(String pwd2) {
		ArrayList<MemberVo> ManagerLogin = new ArrayList<MemberVo>();
		try {
			connDB();

			String query = "SELECT * FROM MENAGER";
			if (pwd2 != null) {
				query += " where MENAGER_PASSWORD='" + pwd2 + "'";
			}
			System.out.println("SQL : " + query);
			rs = stmt.executeQuery(query);
			rs.last();
			System.out.println("rs.getRow() : " + rs.getRow());
			if (rs.getRow() == 0) {
				System.out.println("0 row selected.....");
			} else {
				System.out.println(rs.getRow() + " rows selected.....");
				rs.previous();
				while (rs.next()) {
					String password = rs.getString("MENAGER_PASSWORD");

					MemberVo data = new MemberVo(password);
					ManagerLogin.add(data);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ManagerLogin;
	}

	public ArrayList<MemberVo> worktable(int index) {
		ArrayList<MemberVo> worktable = new ArrayList<MemberVo>();
		try {
			connDB();
			String query;
			if (index == 0) {
				query = "SELECT * FROM (SELECT * FROM ROUTINE WHERE PART = '팔' ORDER BY DBMS_RANDOM.RANDOM) WHERE ROWNUM < 6";
			} else if (index == 1) {
				query = "SELECT * FROM (SELECT * FROM ROUTINE WHERE PART = '등' ORDER BY DBMS_RANDOM.RANDOM) WHERE ROWNUM < 6";

			} else if (index == 2) {
				query = "SELECT * FROM (SELECT * FROM ROUTINE WHERE PART = '다리' ORDER BY DBMS_RANDOM.RANDOM) WHERE ROWNUM < 6";
			} else {
				query = "SELECT * FROM (SELECT * FROM ROUTINE WHERE PART = '가슴' ORDER BY DBMS_RANDOM.RANDOM) WHERE ROWNUM < 6";
			}
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				String list = rs.getString("gym");

				MemberVo data = new MemberVo(list);
				worktable.add(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return worktable;

	}

	public void connDB() {
		try {
			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("oracle connection success.");
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			System.out.println("statement create success.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}