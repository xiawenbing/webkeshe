package vo;

public class User {
    public User() {
		super();
	}
	private String userName;
    private String chrName;
    private String password;
    private String SNO;
    private String role;
	public User(String userName, String chrName, String password, String sNO, String role) {
		super();
		this.userName = userName;
		this.chrName = chrName;
		this.password = password;
		this.SNO = sNO;
		this.role = role;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getChrName() {
		return chrName;
	}
	public void setChrName(String chrName) {
		this.chrName = chrName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSNO() {
		return SNO;
	}
	public void setSNO(String sNO) {
		SNO = sNO;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", chrName=" + chrName + ", password=" + password + ", SNO=" + SNO
				+ ", role=" + role + "]";
	}
	
 


    	 
}
