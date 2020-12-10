package service;

import org.apache.ibatis.annotations.Param;

import vo.Course;

public interface IClassMangerService {
	  public boolean insertclass(String CNO,String CName,String Point);

	  public boolean deletclass(String CNO);
	  
	  public Course get( @Param("CNO")String CNO);
	  
	  public boolean updatecalss(@Param("Point")String Point,@Param("CNO")String CNO);
}
