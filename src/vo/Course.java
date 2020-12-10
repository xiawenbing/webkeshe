package vo;

public class Course {
	private String CNO;
	private String CName;
	private String Point;
	public Course(String cNO, String cName, String point) {
		super();
		CNO = cNO;
		CName = cName;
		Point = point;
	}
	public Course() {
		super();
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
	public String getPoint() {
		return Point;
	}
	public void setPoint(String point) {
		Point = point;
	}
	@Override
	public String toString() {
		return "Class [CNO=" + CNO + ", CName=" + CName + ", Point=" + Point + "]";
	}
	
}
