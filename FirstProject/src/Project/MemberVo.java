package Project;

public class MemberVo {
	private String id;
	private String name;
	private String gender;
	private String tel;
	private String adress;
	private String pwd;
	private String membership;
	private String ptpass;
	private String hnumber;
	public MemberVo(String pwd) {
		this.pwd = pwd;
	}
	public MemberVo(String id, String pwd) {
		this.id = id;
		this.pwd = pwd;

	}

	public MemberVo(String name, String gender, String tel, String adress, String id, String pwd, String membership,
			String ptpass, String hnumber) {
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.gender = gender;
		this.tel = tel;
		this.adress = adress;
		this.membership = membership;
		this.ptpass = ptpass;
		this.hnumber = hnumber;
	}

	public String getId() {
		return id;
	}

	public String getPwd() {
		return pwd;
	}

	public String getName() {
		return name;
	}

	public String getGender() {
		return gender;
	}

	public String getTel() {
		return tel;
	}

	public String getAdress() {
		return adress;
	}

	public String getMembership() {
		return membership;
	}

	public String getPtpass() {
		return ptpass;
	}

	public String getHnumber() {
		return hnumber;
	}

}