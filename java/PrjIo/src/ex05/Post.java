package ex05;

//모두 대문자 
public class Post {
	private String zipcode;
	private String sido;
	private String gugun;
	private String dong;
	private String bunji;
	private int seq;
	
	// Getter Sertter
	
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getSido() {
		return sido;
	}
	public void setSido(String sido) {
		this.sido = sido;
	}
	public String getGugun() {
		return gugun;
	}
	public void setGugun(String gugun) {
		this.gugun = gugun;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public String getBunji() {
		return bunji;
	}
	public void setBunji(String bunji) {
		this.bunji = bunji;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	// Getter Setter 끝
	
	public Post(String zipcode, String sido, String gugun, String dong, String bunji, int seq) {
		super();
		this.zipcode = zipcode;
		this.sido = sido;
		this.gugun = gugun;
		this.dong = dong;
		this.bunji = bunji;
		this.seq = seq;
	}
	
	public Post(String line) {
		String[] li = line.trim().split(",");
		this.zipcode = li[0];
		this.sido = li[1];
		this.gugun = li[2];
		this.dong = li[3];
		this.bunji = li[4];
		this.seq = Integer.parseInt(li[5]);
	}
	@Override
	public String toString() {
		return "ZipCode [zipcode=" + zipcode + ", sido=" + sido + ", gugun=" + gugun + ", dong=" + dong + ", bunji="
				+ bunji + ", seq=" + seq + "]";
	}
	
	
	
}
