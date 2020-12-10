package dao;

import org.apache.ibatis.annotations.Param;

import vo.Course;
import vo.User;

public interface IClassMangerDAO {
	//创建课程
  public boolean insertclass(@Param("CNO")String CNO,@Param("CName")String CName,@Param("Point")String Point);

  public boolean deletclass(@Param("CNO")String CNO);
  
  public Course get( @Param("CNO")String CNO);
  
  public boolean updatecalss(@Param("Point")String Point,@Param("CNO")String CNO);

}
