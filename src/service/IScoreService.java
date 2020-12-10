package service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import vo.Course;
import vo.Page;
import vo.S_C;
import vo.User;

public interface IScoreService {
	public ArrayList<S_C> Score(User user,Page page,int begin);
	public ArrayList<S_C> scorecount(User user,Page page);
	public ArrayList<S_C> teacherclass(User user,Page page,int begin);
	public ArrayList<S_C> teachercount(@Param("user")User user,@Param("page")Page page);
	public boolean updateclass(String SNO, String CNO, String Score);
	public boolean insertclass(String SNO, String CNO, String Score);
}
