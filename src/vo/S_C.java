package vo;

public class S_C {
	private String SNO;
	private String userName;
	private String  CNO;
	private String  CName;
	private int  Score;
	public S_C(String sNO, String userName, String cNO, String cName, int score) {
		super();
		SNO = sNO;
		this.userName = userName;
		CNO = cNO;
		CName = cName;
		Score = score;
	}
	public S_C() {
		super();
	}
	public String getSNO() {
		return SNO;
	}
	public void setSNO(String sNO) {
		SNO = sNO;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCNO() {
		return CNO;
	}
	public void setCNO(String cNO) {
		CNO = cNO;
	}
	public String getCName() {
		return CName;
	}
	public void setCName(String cName) {
		CName = cName;
	}
	public int getScore() {
		return Score;
	}
	public void setScore(int score) {
		Score = score;
	}
	@Override
	public String toString() {
		return "S_C [SNO=" + SNO + ", userName=" + userName + ", CNO=" + CNO + ", CName=" + CName + ", Score=" + Score
				+ "]";
	}
	
	
	
}
