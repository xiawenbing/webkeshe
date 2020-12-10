package dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import vo.Course;
import vo.Page;
import vo.S_C;
import vo.User;

public interface IScoreDAO {
	public ArrayList<S_C> Score(@Param("user")User user,@Param("page")Page page,@Param("begin")int begin);
	
	public ArrayList<S_C> scorecount(@Param("user")User user,@Param("page")Page page);
	
	
	public ArrayList<S_C> teacherclass(@Param("user")User user,@Param("page")Page page,@Param("begin")int begin);
	public ArrayList<S_C> teachercount(@Param("user")User user,@Param("page")Page page);

	public boolean updatescore(@Param("SNO")String SNO, @Param("CNO")String CNO, @Param("Score") String Score);
	
	//新增学生成绩
	public boolean insertclass(@Param("SNO")String SNO, @Param("CNO")String CNO, @Param("Score") String Score);

}
