package db;

public class MemberVo {
	// Fields
	private int mid;
	private String name;
	private String phone;
	private String indate;
	// Constructor
	public MemberVo() {
		
	}
	public MemberVo(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}
	//Getter / Setter
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getIndate() {
		return indate;
	}
	public void setIndate(String indate) {
		this.indate = indate;
	}
	
	//toString
	@Override
	public String toString() {
		return "MemberVo [mid=" + mid + ", name=" + name + ", phone=" + phone + ", indate=" + indate + "]";
	}
	
	
}
