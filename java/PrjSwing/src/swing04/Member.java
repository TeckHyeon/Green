package swing04;

public class Member {
	//  Fields
	//  번호,이름,이메일,연도
	private  int      num;
	private  String   name;
	private  String   email;
	private  String   birthYear;
	// Constructor
	public Member() {}
	public Member(int num, String name, String email, String birthYear) {
		this.num = num;
		this.name = name;
		this.email = email;
		this.birthYear = birthYear;
	}	
	public Member(String line) {
		String [] li = line.trim().split(",");
		this.num        = Integer.parseInt( li[0].trim() );
		this.name       = li[1].trim();
		this.email      = li[2].trim();
		this.birthYear  = li[3].trim();
	}
	
	// Getter / Setter
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirthYear() {
		return birthYear;
	}
	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}
	
	// toString
	@Override
	public String toString() {
		return "Member [num=" + num + ", name=" + name + ", email=" + email + ", birthYear=" + birthYear + "]";
	}
	
	
}
